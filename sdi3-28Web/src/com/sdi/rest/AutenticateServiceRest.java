package com.sdi.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;

@Path("/LoginRs")
public interface AutenticateServiceRest {
	
	@GET 
	@Path("authenticate")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User authenticate(String login, String password)
			throws BusinessException;
	
}
