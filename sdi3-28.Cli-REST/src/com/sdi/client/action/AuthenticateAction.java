package com.sdi.client.action;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.client.model.User;
import com.sdi.client.ui.OptionsMenu;
import com.sdi.util.Authenticator;

public class AuthenticateAction implements Action {
	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/LoginRs/authenticate";

	@Override
	public void execute() throws Exception {

		try {
			String user = Console.readString("Usuario");
			String password = Console.readString("Contraseña");
			String datos64 = DatatypeConverter
					.printBase64Binary((user + ":" + password)
							.getBytes("UTF-8"));

			User res = ClientBuilder.newClient()
					.register(new Authenticator(user, password))
					.target(REST_SERVICE_URL).path(datos64).request()
					.accept(MediaType.APPLICATION_XML).get()
					.readEntity(User.class);

			new OptionsMenu().execute(res);
		} catch (ProcessingException pe) {
			Console.println("Ha ocurrido un error procesando la petición.\n"
					+ "Asegúrese que los proporcionados son correctos.");
		}
	}
}
