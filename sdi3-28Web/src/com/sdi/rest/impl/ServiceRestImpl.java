package com.sdi.rest.impl;

import java.util.List;

import com.sdi.business.TaskService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Category;
import com.sdi.model.Task;
import com.sdi.rest.ServiceRest;
import com.sdi.rest.exception.ServerException;

public class ServiceRestImpl implements ServiceRest{

	private TaskService taskService = Factories.services.getTaskService();
	//TODO No lanzar Bussiness

	@Override
	public void saveTask(Task task) throws ServerException {
		try{
			taskService.createTask(task);
		} catch (BusinessException e) {
			throw new ServerException(e.getMessage());
		}
	}
	
	@Override
	public List<Category> findCategoriesByUserId(Long id) throws ServerException{
		
		try {
			return taskService.findCategoriesByUserId(id);
		} catch (BusinessException e) {
			throw new ServerException(e.getMessage());
		}
		
	}

	@Override
	public List<Task> findNotFinishedTasksByCategoryId(Long id) 
			throws ServerException {
		try{
			return taskService.findNotFinishedTasksByCategoryId(id);
		} catch (BusinessException e) {
			throw new ServerException(e.getMessage());
		}
	}

	
	@Override
	public void markTaskAsFinished(String id) throws ServerException {
		try{
			taskService.markTaskAsFinished(Long.parseLong(id));
		} catch (BusinessException e) {
			throw new ServerException(e.getMessage());
		}
	}
	
}
