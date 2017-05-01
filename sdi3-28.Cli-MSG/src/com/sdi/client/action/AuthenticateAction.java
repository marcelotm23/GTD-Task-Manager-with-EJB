package com.sdi.client.action;

import java.io.UnsupportedEncodingException;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.xml.bind.DatatypeConverter;

import alb.util.console.Console;

import com.sdi.client.ui.OptionsMenu;

public class AuthenticateAction extends AbstractAction{

	@Override
	protected MapMessage createMessage() throws JMSException {
		String user=Console.readString("Usuario");
		String password=Console.readString("Contraseña");
		String datos64 = null;
		try {
			datos64 = DatatypeConverter.printBase64Binary(
					(user+":"+password).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MapMessage msg = session.createMapMessage();
		msg.setString("command", "login"); 
		msg.setString("datos64", datos64);
	
		return msg;
	}
	
	@Override
	public void onMessage(Message msg) {
		MapMessage m=(MapMessage)msg;
		try {
			idUser = m.getLong("idUser");
			if (idUser != -1L) {
				new OptionsMenu().execute();
			}else{
				Console.println("Usuario o password incorrectos");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}
	
	

}
