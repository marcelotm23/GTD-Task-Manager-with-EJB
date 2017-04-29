package com.sdi.client.action;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.sdi.client.Authenticator;
import com.sdi.client.model.Category;
import com.sdi.client.model.User;
import com.sdi.client.ui.Action;
import com.sdi.util.Output;


public class ListarCategoriasAction implements Action {

	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/ServiceRs/findCategoriesByUserId";

	@Override
	public void execute(User user) throws Exception {
		GenericType<List<Category>> categorias = new GenericType<List<Category>>() {
		};

		List<Category> res = ClientBuilder.newClient()
		.register(new Authenticator(user.getLogin(), user.getPassword()))
		.target(REST_SERVICE_URL)
		.path(user.getId().toString()) 
		.request()
		.accept( MediaType.APPLICATION_XML )
		.get()
		.readEntity(categorias);
		Output.printCategories(res);
	}

}
