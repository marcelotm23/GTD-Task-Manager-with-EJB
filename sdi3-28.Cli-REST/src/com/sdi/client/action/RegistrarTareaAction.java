package com.sdi.client.action;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.sdi.client.Authenticator;
import com.sdi.client.dtos.Task;

import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.menu.Action;

public class RegistrarTareaAction implements Action{

	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/ServiceRs/saveTask";
	
	@Override
	public void execute() throws Exception {
		 Task task=new Task();
		 task.setTitle(Console.readString("Título de la tarea"));
		 task.setComments(Console.readString("Comentarios"));
		 task.setCreated(DateUtil.today());
		 task.setPlanned(DateUtil.fromString(
				 Console.readString("Fecha planeada (dd/MM/AAAA)")));
		 task.setId(new Long(146));
		 
		ClientBuilder.newClient() 
		.register( new Authenticator("user1", "user1") ) 
		.target( REST_SERVICE_URL ) 
		.request() 
		.put( Entity.entity(task, MediaType.APPLICATION_JSON) ); 
		
		Console.println("Tarea añadida");
	}

}
