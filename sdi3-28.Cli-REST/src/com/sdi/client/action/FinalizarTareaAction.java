package com.sdi.client.action;

import javax.ws.rs.client.ClientBuilder;

import com.sdi.client.Authenticator;

import alb.util.console.Console;
import alb.util.menu.Action;

public class FinalizarTareaAction implements Action{

	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/ServiceRs/markTaskAsFinished";


	@Override
	public void execute() throws Exception {
		
		Long id = Console.readLong("Id de la tarea");
//		ClientBuilder.newClient() 
//		      .register( new Authenticator("sdi", "password") ) 
//		      .target( REST_SERVICE_URL ) 
//		      .request()
//		      .put( id ); 
	}

}
