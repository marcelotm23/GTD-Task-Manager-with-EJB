package com.sdi.business.integration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.xml.bind.DatatypeConverter;

import alb.util.date.DateUtil;

import com.sdi.business.TaskService;
import com.sdi.business.UserService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Task;
import com.sdi.model.User;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/GTDQueue") })
public class GTDListener implements MessageListener {

	private UserService userService = Factories.services.getUserService();
	private TaskService taskService = Factories.services.getTaskService();

	@EJB
	private Auditor auditor;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory factory;

	@Override
	public void onMessage(Message msg) {
		System.out.println("GTDListener: Msg recibido");
		try {
			process(msg);
		} catch (JMSException jex) {
			jex.printStackTrace();
		}
	}

	private void process(Message m) throws BusinessException, JMSException {

		if (!messageOfExpectedType(m)) {
			System.out.println("Not of expected type " + m);
			return;
		}
		MapMessage msg = (MapMessage) m;
		String cmd = msg.getString("command");
		if ("findTasksTodayAndDelayed".equals(cmd)) {
			doFindTasksTodayAndDelayed(msg);
		} else if ("finishTask".equals(cmd)) {
			doFinishTask(msg);
		} else if ("saveTask".equals(cmd)) {
			doSaveTask(msg);
		} else if ("login".equals(cmd)) {
			doLogin(msg);
		} else {
			auditor.audit(cmd, "operacion desconocida");
		}
	}

	private void sendMessage(MapMessage msg, Map<String, Object> msgMap) {
		Connection con = null;
		try {
			con = factory.createConnection("sdi", "password");
			Session session = con
					.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer sender = session.createProducer(null);
			MapMessage msgToSend = null;
			String cmd=msg.getString("command");
			if(cmd.equals("login")){
				msgToSend = createJmsMapMessageLogin(msgMap, session);
			}else if(cmd.equals("findTasksTodayAndDelayed")){
				msgToSend = createJmsMapMessageFindTasks(msgMap, session);
			}else if(cmd.equals("saveTask")){
				msgToSend = createJmsMapMessageSaveTask(msgMap, session);
			}
			sender.send(msg.getJMSReplyTo(), msgToSend);
		} catch (JMSException jex) {
			jex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	private MapMessage createJmsMapMessageSaveTask(Map<String, Object> msgMap,
			Session session) throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("resultado", (String) msgMap.get("resultado"));
		return msg;
	}

	private MapMessage createJmsMapMessageLogin(Map<String, Object> msgMap,
			Session session) throws JMSException {
		MapMessage msg = session.createMapMessage();
		if(msgMap.get("user")!=null){	
			User user = (User) msgMap.get("user");
			msg.setLong("idUser", user.getId());
		}else{
			msg.setObject("idUser", null);
		}
		return msg;
	}
	private MapMessage createJmsMapMessageFindTasks(Map<String, Object> msgMap,
			Session session) throws JMSException {
		MapMessage msg = session.createMapMessage();
		List<Task> tasks=
				(List<Task>) msgMap.get("tasksTodayAndDelayed");
		List<String> tasksSend= new ArrayList<String>();
		for(Task task:tasks){
			tasksSend.add(task.toString());
		}
		msg.setObject("tasksTodayAndDelayed", (Serializable)tasks);
		
		return msg;
	}

	private void doLogin(MapMessage msg) throws JMSException {
		String datos64 = msg.getString("datos64");
		String decodicado = new String(
				DatatypeConverter.parseBase64Binary(datos64));
		String[] datos = decodicado.split(":");
		String login = datos[0];
		String password = datos[1];

		User user = userService.findLoggableUser(login, password);
		Map<String, Object> msgToSend = new HashMap<String, Object>();
		if (user == null) {
			auditor.audit("login", "login incorrecto");
			msgToSend.put("user", null);
		} else {
			msgToSend.put("user", user);
			System.out.println("USER->>" + user.toString());
		}
		sendMessage(msg, msgToSend);

	}

	private void doSaveTask(MapMessage msg) throws NumberFormatException,
			JMSException {
		Task task = new Task();
		task.setUserId(Long.parseLong(msg.getString("idUser")));
		task.setTitle(msg.getString("title"));
		task.setComments(msg.getString("comments"));
		task.setCreated(DateUtil.today());
		task.setPlanned(DateUtil.fromString(msg.getString("planned")));
		String resultado="";
		Map<String, Object> msgToSend = new HashMap<String, Object>();
		try {
			taskService.createTask(task);
			resultado="Se añadido la tarea con éxito";
		} catch (BusinessException e) {
			auditor.audit("saveTask", "login incorrecto");
			resultado="Se añadido la tarea con éxito";
		}
		msgToSend.put("resultado", resultado);
		sendMessage(msg, msgToSend);
	}

	private void doFinishTask(MapMessage msg) throws NumberFormatException,
			BusinessException, JMSException {
		taskService.markTaskAsFinished(Long.parseLong(msg.getString("idTask")));
	}

	private void doFindTasksTodayAndDelayed(MapMessage msg)
			throws NumberFormatException, BusinessException, JMSException {
		List<Task> tasks = taskService.findTodayTasksByUserId(Long
				.parseLong(msg.getString("idUser")));
		Map<String, Object> msgToSend = new HashMap<String, Object>();
		if (tasks != null) {
			msgToSend.put("tasksTodayAndDelayed", tasks);
		} else {
			auditor.audit("findTasksTodayAndDelayed", "tareas para hoy y "
					+ "retrasadas no encontradas");
			msgToSend.put("tasksTodayAndDelayed", null);
		}
		sendMessage(msg, msgToSend);
	}

	private boolean messageOfExpectedType(Message msg) {
		return msg instanceof MapMessage;
	}

}
