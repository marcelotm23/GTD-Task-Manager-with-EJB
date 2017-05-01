package com.sdi.client.action;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

import alb.util.console.Console;

public class RegistrarTareaAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage(); 
		
		String title=Console.readString("Título");
		String comments=Console.readString("Comentarios");
		String planned=Console.readString("Fecha planeada(dd/MM/AAAA)");
		
		msg.setString("command", "saveTask");
		msg.setLong("idUser", idUser);
		msg.setString("title", title);
		msg.setString("comments", comments);
		msg.setString("planned", planned);
		
		return msg; 
	}

	@Override
	public void onMessage(Message msg) {
		MapMessage m=(MapMessage) msg;
		try {
			String resultado = m.getString("resultado");
			
			Console.println(resultado);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}

}
