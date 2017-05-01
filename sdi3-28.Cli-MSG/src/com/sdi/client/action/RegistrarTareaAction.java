package com.sdi.client.action;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

import alb.util.console.Console;

public class RegistrarTareaAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage(); 
		
		String title=Console.readString();
		String comments=Console.readString();
		String planned=Console.readString();
		
		msg.setString("command", "finishTask");
//		TODO msg.setLong("idUser", user.getId());
		msg.setString("title", title);
		msg.setString("comments", comments);
		msg.setString("planned", planned);
		
		return msg; 
	}

	@Override
	public void onMessage(MapMessage arg0) {
		// TODO Auto-generated method stub
		
	}

}
