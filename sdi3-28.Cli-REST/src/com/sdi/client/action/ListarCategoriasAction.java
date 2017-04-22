package com.sdi.client.action;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import com.sdi.client.Authenticator;
import com.sdi.client.Category;
import com.sdi.util.Output;

import alb.util.menu.Action;

public class ListarCategoriasAction implements Action {

	private static final String REST_SERVICE_URL = "findCategoriesByUserId/{id}";

	@Override
	public void execute() throws Exception {
		GenericType<List<Category>> categorias = new GenericType<List<Category>>() {
		};

		List<Category> res = ClientBuilder.newClient()
		.register(new Authenticator("sdi", "password"))
		.target(REST_SERVICE_URL)
		.path( "usuario.getId().toString()" ) 
		.request()
		.get()
		.readEntity(categorias);
		Output.printCategories(res);
	}

}
