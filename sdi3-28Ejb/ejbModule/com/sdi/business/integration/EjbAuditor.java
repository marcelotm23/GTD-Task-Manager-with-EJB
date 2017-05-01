package com.sdi.business.integration;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * Session Bean implementation class EjbAuditor
 */
@Stateless
public class EjbAuditor implements Auditor {

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory factory;
	
	@Resource(mappedName = "java:/queue/AuditQueue")
	private Destination queue;

	@Resource
	private SessionContext ctx;

	/**
	 * Default constructor.
	 */
	public EjbAuditor() {
	}

	@Override
	public void audit(String operation, String message) throws JMSException {
		audit(ctx.getCallerPrincipal(), operation, message);
	}

	public void audit(Principal principal, String operation, String message)
			throws JMSException {
		Map<String, String> msg = new HashMap<String, String>();

		msg.put("user", principal.getName());
		msg.put("operation", operation);
		msg.put("message", message);
		msg.put("date", new Date().toString());

		sendMapMessage(msg);
		System.out.println("Msg sent with " + msg);
	}

	private void sendMapMessage(Map<String, String> msgMap) throws JMSException {
		Connection con = null;
		try {

			con = factory.createConnection("sdi", "password");
			Session session = con
					.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer sender = session.createProducer(queue);
			MapMessage msg = createJmsMapMessage(msgMap, session);

			sender.send(msg);
		} catch (JMSException jex) {
			jex.printStackTrace();
		} finally {
			close(con);
		}
	}

	private MapMessage createJmsMapMessage(Map<String, String> msgMap,
			Session session) throws JMSException {
		MapMessage msg = session.createMapMessage();

		for(String key:msgMap.keySet()){
			msg.setString(key, msgMap.get(key));
		}
		return msg;
	}

	private void close(Connection con) throws JMSException {
		con.close();
	}

}
