package com.sdi.client.action;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import alb.util.console.Console;

public class FinalizarTareaAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage();
		Long idTask=Console.readLong();
		
		msg.setString("command", "finishTask"); 
		msg.setLong("idTask", idTask);
		
		return msg; 
	}

}
