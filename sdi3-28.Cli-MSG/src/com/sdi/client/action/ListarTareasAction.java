package com.sdi.client.action;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import alb.util.console.Console;

import com.sdi.client.model.Task;

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
	public void onMessage(MapMessage msg) {
		System.out.println("GTD CLiente MSG: Msg recibido");
		
		try {
			List<Task> tasks = 
					(List<Task>) msg.getObject("tasksTodayAndDelayed");
			if (tasks != null) {
				printTasks(tasks);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}
	
	public static void printTasks(List<Task> tasks) {
		if (tasks.size() == 0) {
			Console.println("Ninguna tarea asociada a dicha categoría");
		} else {
			Console.println("Nombre\tComentarios\tFecha planificada");
			for (Task t : tasks) {
				Console.println(t.getTitle() + "\t" + t.getComments() + "\t"
						+ t.getPlanned() + "\t");
			}
		}
	}

	

}
