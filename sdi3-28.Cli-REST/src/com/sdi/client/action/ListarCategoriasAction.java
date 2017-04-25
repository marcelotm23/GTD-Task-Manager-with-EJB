package com.sdi.client.action;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.sdi.client.Authenticator;
import com.sdi.client.dtos.Category;
import com.sdi.util.Output;

import alb.util.menu.Action;

public class ListarCategoriasAction implements Action {

	private static final String REST_SERVICE_URL = 
			"http://localhost:8280/sdi3-28.Web/rest/ServiceRs/findCategoriesByUsername";

	@Override
	public void execute() throws Exception {
		GenericType<List<Category>> categorias = new GenericType<List<Category>>() {
		};

		List<Category> res = ClientBuilder.newClient()
		.register(new Authenticator("user1", "user1"))
		.target(REST_SERVICE_URL)
		.path("user1") 
		.request()
		.accept( MediaType.APPLICATION_XML )
		.get()
		.readEntity(categorias);
		Output.printCategories(res);
	}

}
