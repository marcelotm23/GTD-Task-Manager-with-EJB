package com.sdi.client.action;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import com.sdi.util.Jndi;

import alb.util.menu.Action;

public abstract class AbstractAction implements Action, MessageListener {

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
		con.close();
	}

	protected abstract MapMessage createMessage() throws JMSException;

	private void initialize() throws JMSException {

		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);

		Destination queue = (Destination) Jndi.find(GTD_QUEUE);

		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		sender = session.createProducer(queue);
		tempQueue = session.createTemporaryQueue();
		consumer = session.createConsumer(tempQueue);
		consumer.setMessageListener(this);
		con.start();
	}
}
