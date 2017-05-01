package com.sdi.client.action;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import alb.util.console.Console;

public class RegistrarTareaAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage(); 
		
		String title=Console.readString();
		String comments=Console.readString();
		String planned=Console.readString();
		
		msg.setString("command", "saveTask");
		msg.setLong("idUser", idUser);
		msg.setString("title", title);
		msg.setString("comments", comments);
		msg.setString("planned", planned);
		
		return msg; 
	}

	@Override
	public void onMessage(MapMessage msg) {
		System.out.println("GTD CLiente MSG: Msg recibido");
		try {
			String resultado = msg.getString("resultado");
			
			Console.println(resultado);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}

}
