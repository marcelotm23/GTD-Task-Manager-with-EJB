package com.sdi.client.action;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import com.sdi.client.model.User;
import com.sdi.client.ui.OptionsMenu;
import com.sdi.util.Jndi;

import alb.util.console.Console;
import alb.util.menu.Action;

public abstract class AbstractAction implements Action {

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String GTD_QUEUE = "jms/queue/GTDQueue";

	private Connection con;
	protected Session session;
	private MessageProducer sender;
	
	private MessageConsumer consumer;
	private Destination tempQueue;

	
	@Override
	public void execute() throws Exception {
		initialize();
		MapMessage msg = createMessage();
		msg.setJMSReplyTo(tempQueue);
		sender.send(msg);
		recibirMensaje();
		con.close();
	}

	private void recibirMensaje() throws JMSException {
		consumer = session.createConsumer(tempQueue);
		
		MapMessage msg = (MapMessage) consumer.receive(10000);
		onMessage(msg);
	}

	protected abstract MapMessage createMessage() throws JMSException;
	protected abstract void onMessage(MapMessage msg);

	private void initialize() throws JMSException {

		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);

		Destination queue = (Destination) Jndi.find(GTD_QUEUE);

		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		sender = session.createProducer(queue);
		tempQueue = session.createTemporaryQueue();
		
		con.start();
	}
}
