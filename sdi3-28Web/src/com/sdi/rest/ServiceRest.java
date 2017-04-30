package com.sdi.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sdi.model.Category;
import com.sdi.model.Task;
import com.sdi.rest.exception.ServerException;

@Path("/ServiceRs")
public interface ServiceRest {
	
	@GET 
	@Path("findCategoriesByUserId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Category> findCategoriesByUserId(@PathParam("id")Long id) 
			throws ServerException;

	@PUT
	@Path("saveTask")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void saveTask(Task task) throws ServerException;

	@POST 
	@Path("markTaskAsFinished")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void markTaskAsFinished(Task task) 
			throws ServerException;	
	
	@GET 
	@Path("findNotFinishedTasksByCategoryId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findNotFinishedTasksByCategoryId(@PathParam("id")Long id)
			throws ServerException;



}
