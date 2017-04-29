package com.sdi.client.action;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import com.sdi.client.ui.OptionsMenu;
import com.sdi.util.Jndi;

import alb.util.menu.Action;

public abstract class AbstractAction implements Action{

	private static final String JMS_CONNECTION_FACTORY = 
            "jms/RemoteConnectionFactory";
	private static final String GTD_QUEUE = 
			"jms/queue/GTDQueue"; 
	private Connection con;
	protected Session session;
	private MessageProducer sender; 
	
	@Override
	public void execute() throws Exception {
		initialize();
		MapMessage msg = createMessage(); 
		sender.send(msg); 
		con.close(); 
		changeMenu(msg);
	}
	private void changeMenu(MapMessage msg) throws JMSException {
		if(msg.getString("command").equals("login")){
			new OptionsMenu().execute();
		}
	}
	protected abstract MapMessage createMessage() throws JMSException;
	private void initialize() throws JMSException {
		 
		ConnectionFactory factory =  
		                (ConnectionFactory) Jndi.find( JMS_CONNECTION_FACTORY );
		 
		Destination queue = (Destination) Jndi.find( GTD_QUEUE ); 

		con = factory.createConnection("sdi", "password"); 
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE); 
		sender = session.createProducer(queue);
		con.start(); 
	}
}
