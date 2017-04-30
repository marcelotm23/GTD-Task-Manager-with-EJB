package com.sdi.client.action;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.sdi.client.Authenticator;
import com.sdi.client.model.Task;
import com.sdi.client.model.User;
import com.sdi.client.ui.Action;

import alb.util.console.Console;


public class FinalizarTareaAction implements Action{

	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/ServiceRs/markTaskAsFinished";


	@Override
	public void execute(User user) throws Exception {
		
		Long id = Console.readLong("Id de la tarea");
		Task task=new Task();
		task.setId(id);
		task.setUserId(user.getId());
		ClientBuilder.newClient() 
		      .register( new Authenticator(user.getLogin(), user.getPassword()) ) 
		      .target( REST_SERVICE_URL ) 
		      .request()
		      .post(Entity.entity(task, MediaType.APPLICATION_XML )); 
	}

}
