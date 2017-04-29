package com.sdi.business.integration;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import alb.util.date.DateUtil;

import com.sdi.business.TaskService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Task;

@MessageDriven(activationConfig = { 
		@ActivationConfigProperty(
				propertyName = "destination", 
				propertyValue = "queue/GTDQueue") 
		})
public class GTDListener implements MessageListener {

	private TaskService userService = Factories.services.getUserService();
	private TaskService taskService = Factories.services.getTaskService();

	@Override
	public void onMessage(Message msg) {
		System.out.println("GTDListener: Msg recibido");
		try {
			process(msg);
		} catch (JMSException jex) {
			// TODO here we should log the exception
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
		}else if("login".equals(cmd)){
			doLogin(msg);
		}
	}

	private void doLogin(Object mdg) {
		// TODO Auto-generated method stub
		
	}

	private void doSaveTask(MapMessage msg) throws NumberFormatException, JMSException {
		Task task=new Task();
		task.setUserId(Long.parseLong(msg.getString("idUser")));
		task.setTitle(msg.getString("title"));
		task.setComments(msg.getString("comments"));
		task.setCreated(DateUtil.today());
		task.setPlanned(DateUtil.fromString(msg.getString("planned")));
		
		taskService.createTask(task);
	}

	private void doFinishTask(MapMessage msg) throws NumberFormatException,
			BusinessException, JMSException {
		taskService.markTaskAsFinished(Long.parseLong(msg.getString("idTask")));

	}

	private void doFindTasksTodayAndDelayed(MapMessage msg)
			throws NumberFormatException, BusinessException, JMSException {
		taskService.findTodayTasksByUserId(Long.parseLong(msg
				.getString("idUser")));

	}

	private boolean messageOfExpectedType(Message msg) {
		return msg instanceof MapMessage;
	}

}
