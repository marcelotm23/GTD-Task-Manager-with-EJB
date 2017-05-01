package com.sdi.client.action;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import alb.util.console.Console;

public class ListarTareasAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage(); 
		
		msg.setString("command", "findTasksTodayAndDelayed"); 
		msg.setLong("idUser", idUser); 
		
		
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message msg) {
		
		ObjectMessage m=(ObjectMessage) msg;
		try {
			List<String> tasks = 
					 (List<String>) m.getObject();
			if (tasks != null) {
				printTasks(tasks);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}
	@Override
	protected void recibirMensaje() throws JMSException {
		consumer = session.createConsumer(tempQueue);
		
		ObjectMessage msg = (ObjectMessage) consumer.receive(10000);
		onMessage(msg);
	}
	
	public static void printTasks(List<String> tasks) {
		if (tasks.size() == 0) {
			Console.println("Ninguna tarea asociada a dicha categoría");
		} else {
			Console.println("Listado de tareas:");
			for (String t : tasks) {
				Console.println(t);
			}
		}
	}

	

}
