package com.sdi.client.action;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import alb.util.console.Console;

import com.sdi.client.Authenticator;
import com.sdi.client.model.User;
import com.sdi.client.ui.Action;


public class FinalizarTareaAction implements Action{

	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/ServiceRs/markTaskAsFinished";


	@Override
	public void execute(User user) throws Exception {
		
		String id = Console.readString("Id de la tarea");
		
		ClientBuilder.newClient() 
		      .register( new Authenticator(user.getLogin(), user.getPassword()) ) 
		      .target( REST_SERVICE_URL ) 
		      .request()
		      .post(Entity.entity(id, MediaType.APPLICATION_XML )); 
	}

}
