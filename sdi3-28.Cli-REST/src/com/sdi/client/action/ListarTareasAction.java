package com.sdi.client.action;

import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import alb.util.console.Console;

import com.sdi.client.model.Task;
import com.sdi.client.model.User;
import com.sdi.client.ui.Action;
import com.sdi.util.Authenticator;
import com.sdi.util.Output;

public class ListarTareasAction implements Action {

	private static final String REST_SERVICE_URL = 
	 "http://localhost:8280/sdi3-28.Web/rest/ServiceRs/findNotFinishedTasksByCategoryId";

	@Override
	public void execute(User user) throws Exception {
		
		try {
			Long id = Console.readLong("Id de la categoría");
			GenericType<List<Task>> tareas = new GenericType<List<Task>>() {
			};

			List<Task> res = ClientBuilder
					.newClient()
					.register(
							new Authenticator(user.getLogin(), user
									.getPassword())).target(REST_SERVICE_URL)
					.path(String.valueOf(id)).request()
					.accept(MediaType.APPLICATION_XML).get().readEntity(tareas);

			Output.printTasks(res);
		} catch (ProcessingException pe) {
			Console.println("Ha ocurrido un error procesando la petición."
					+ "Asegúrse que los datos proporcionados son correctos.");
		}
	}

}
