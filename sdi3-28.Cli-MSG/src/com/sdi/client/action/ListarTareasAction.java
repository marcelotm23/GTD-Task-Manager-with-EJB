package com.sdi.client.action;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

public class ListarTareasAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage(); 
		
		msg.setString("command", "findTasksTodayAndDelayed"); 
		//TODO msg.setString("idUser", user.getId()); 
		
		
		return msg;
	}

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
