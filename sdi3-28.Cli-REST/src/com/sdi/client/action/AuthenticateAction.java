package com.sdi.client.action;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.client.Authenticator;
import com.sdi.client.dtos.User;
import com.sdi.client.ui.OptionsMenu;

public class AuthenticateAction implements Action{
	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/LoginRs/authenticate";

	@Override
	public void execute() throws Exception {
		String user=Console.readString("Usuario");
		String password=Console.readString("Contraseña");
		
		User res = ClientBuilder.newClient()
				.register(new Authenticator(user, password))
				.target(REST_SERVICE_URL)
				.request()
				.accept( MediaType.APPLICATION_XML )
				.get()
				.readEntity(User.class);
		
		new OptionsMenu().execute(res);
	}

}
