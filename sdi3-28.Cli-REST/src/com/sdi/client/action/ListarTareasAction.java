package com.sdi.client.action;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;




import com.sdi.client.Authenticator;
import com.sdi.client.dtos.Task;
import com.sdi.client.dtos.User;
import com.sdi.client.ui.Action;
import com.sdi.util.Output;

public class ListarTareasAction implements Action{

	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/ServiceRs/findNotFinishedTasksByCategoryId";

	@Override
	public void execute(User user) throws Exception {
		GenericType<List<Task>> tareas = new GenericType<List<Task>>() {
		};

		List<Task> res = ClientBuilder.newClient()
		.register(new Authenticator(user.getLogin(), user.getPassword()))
		.target(REST_SERVICE_URL)
		.path( String.valueOf(276) ) 
		.request()
		.accept( MediaType.APPLICATION_XML )
		.get()
		.readEntity(tareas);
		System.out.println(res.size());
		Output.printTasks(res);
	}

}
