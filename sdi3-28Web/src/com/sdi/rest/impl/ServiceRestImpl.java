package com.sdi.rest.impl;

import java.util.List;

import com.sdi.business.TaskService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Category;
import com.sdi.model.Task;
import com.sdi.rest.ServiceRest;

public class ServiceRestImpl implements ServiceRest{

	private TaskService taskService = Factories.services.getTaskService();

	@Override
	public Long saveTask(Task task) throws BusinessException {
		return taskService.createTask(task);
	}
	
	@Override
	public List<Category> findCategoriesByUsername(String username)
			throws BusinessException {
		return taskService.findCategoriesByUsername(username);
	}

	@Override
	public List<Task> findNotFinishedTasksByCategoryId(Long id) throws BusinessException {
		return taskService.findNotFinishedTasksByCategoryId(id);
	}

	
	@Override
	public void markTaskAsFinished(Long id) throws BusinessException {
		taskService.markTaskAsFinished(id);
	}

	
	
	
}
