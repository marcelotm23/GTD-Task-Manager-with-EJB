package com.sdi.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

@Path("/TasksServiceRs")
public interface TasksServiceRest {
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Long createCategory(Category category) throws BusinessException;

	@POST 
	@Path("duplicateCategory/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Long duplicateCategory(@PathParam("id")Long id) throws BusinessException;

	@POST 
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updateCategory(Category category) throws BusinessException;

	@DELETE
	@Path("deleteCategory/{id}")
	public void deleteCategory(@PathParam("id")Long id) throws BusinessException;

	@GET 
	@Path("findCategoryById/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Category findCategoryById(@PathParam("id")Long id) throws BusinessException;

	@GET 
	@Path("findCategoriesByUserId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Category> findCategoriesByUserId(@PathParam("id")Long id)
			throws BusinessException;

	@GET 
	@Path("{id}/{name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Category findCategoryByUserIdAndName(Long id, String name)
			throws BusinessException;

	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Long createTask(Task task) throws BusinessException;

	@DELETE
	public void deleteTask(Long id) throws BusinessException;

	@POST 
	@Path("markTaskAsFinished/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void markTaskAsFinished(@PathParam("id")Long id) throws BusinessException;

	@POST 
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updateTask(Task task) throws BusinessException;

	@GET 
	@Path("findTaskById/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Task findTaskById(@PathParam("id")Long id) throws BusinessException;

	@GET 
	@Path("findInboxTasksByUserId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findInboxTasksByUserId(@PathParam("id")Long id) throws BusinessException;

	@GET 
	@Path("findWeekTasksByUserId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findWeekTasksByUserId(@PathParam("id")Long id) throws BusinessException;

	@GET 
	@Path("findTodayTasksByUserId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findTodayTasksByUserId(Long id) throws BusinessException;

	@GET 
	@Path("findTasksByCategoryId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findTasksByCategoryId(@PathParam("id")Long id)
			throws BusinessException;

	@GET 
	@Path("findFinishedTasksByCategoryId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findFinishedTasksByCategoryId(@PathParam("id")Long id)
			throws BusinessException;

	@GET 
	@Path("findFinishedInboxTasksByUserId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> findFinishedInboxTasksByUserId(@PathParam("id")Long id)
			throws BusinessException;
}
