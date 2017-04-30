package com.sdi.client.action;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.sdi.client.model.Task;
import com.sdi.client.model.User;
import com.sdi.client.ui.Action;
import com.sdi.util.Authenticator;

import alb.util.console.Console;
import alb.util.date.DateUtil;

public class RegistrarTareaAction implements Action {

	private static final String REST_SERVICE_URL = "http://localhost:8280/sdi3-28.Web/rest/ServiceRs/saveTask";

	@Override
	public void execute(User user) throws Exception {

		try {
			Task task = new Task();
			task.setTitle(Console.readString("Título de la tarea"));
			task.setComments(Console.readString("Comentarios"));
			task.setCreated(DateUtil.today());
			task.setPlanned(DateUtil.fromString(Console
					.readString("Fecha planeada (dd/MM/AAAA)")));
			task.setUserId(user.getId());

			ClientBuilder
					.newClient()
					.register(
							new Authenticator(user.getLogin(), user
									.getPassword())).target(REST_SERVICE_URL)
					.request()
					.put(Entity.entity(task, MediaType.APPLICATION_XML));

			Console.println("Tarea añadida");
		} catch (ProcessingException pe) {
			Console.println("Ha ocurrido un error procesando la petición."
					+ "Asegúrse que los datos proporcionados son correctos.");
		}
	}

}
