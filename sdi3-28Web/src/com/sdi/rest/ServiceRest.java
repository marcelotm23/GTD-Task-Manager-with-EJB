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

import com.sdi.business.exception.BusinessException;
import com.sdi.model.Category;
import com.sdi.model.Task;

@Path("/ServiceRs")
public interface ServiceRest {
	
	@GET 
	@Path("findCategoriesByUsername/{username}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Category> findCategoriesByUsername(@PathParam("username")String username)
			throws BusinessException;

	
	@PUT
	@Path("saveTask")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Long saveTask(Task task) throws BusinessException;

	@POST 
	@Path("markTaskAsFinished/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void markTaskAsFinished(@PathParam("id")Long id) throws BusinessException;	
	
	@GET 
	@Path("findNotFinishedTasksByCategoryId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findNotFinishedTasksByCategoryId(@PathParam("id")Long id)
			throws BusinessException;



}
