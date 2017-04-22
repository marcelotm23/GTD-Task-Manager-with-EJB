package com.sdi.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;

@Path("/UserServiceRs")
public interface UserServiceRest {

	@GET 
	@Path("findLoggableUser/{login}/{password}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User findLoggableUser(@PathParam("login")String login, @PathParam("password")String password)
			throws BusinessException;

}
