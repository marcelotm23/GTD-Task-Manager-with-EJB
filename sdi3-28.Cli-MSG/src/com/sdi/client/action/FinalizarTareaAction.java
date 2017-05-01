package com.sdi.client.action;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import alb.util.console.Console;

public class FinalizarTareaAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage();
		Long idTask=Console.readLong("Id de la tarea");
		
		msg.setString("command", "finishTask"); 
		msg.setLong("idTask", idTask);
		msg.setLong("idUser", idUser);
		
		return msg; 
	}

	@Override
	public void onMessage(MapMessage msg) {
		try {
			String resultado = msg.getString("resultado");
			
			Console.println(resultado);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}

}
