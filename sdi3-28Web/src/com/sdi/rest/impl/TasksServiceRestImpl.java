package com.sdi.rest.impl;

import java.util.List;

import com.sdi.business.TaskService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Category;
import com.sdi.model.Task;
import com.sdi.rest.TasksServiceRest;

public class TasksServiceRestImpl implements TasksServiceRest{

	private TaskService taskService = Factories.services.getTaskService();

	@Override
	public Long createCategory(Category category) throws BusinessException {
		return taskService.createCategory(category);
	}

	@Override
	public Long duplicateCategory(Long id) throws BusinessException {
		return taskService.duplicateCategory(id);
	}

	@Override
	public void updateCategory(Category category) throws BusinessException {
		taskService.updateCategory(category);
	}

	@Override
	public void deleteCategory(Long id) throws BusinessException {
		taskService.deleteCategory(id);
	}

	@Override
	public Category findCategoryById(Long id) throws BusinessException {
		return taskService.findCategoryById(id);
	}

	@Override
	public List<Category> findCategoriesByUserId(Long id)
			throws BusinessException {
		return taskService.findCategoriesByUserId(id);
	}

	@Override
	public Category findCategoryByUserIdAndName(Long id, String name)
			throws BusinessException {
		return taskService.findCategoryByUserIdAndName(id, name);
	}

	@Override
	public Long createTask(Task task) throws BusinessException {
		return taskService.createTask(task);
	}

	@Override
	public void deleteTask(Long id) throws BusinessException {
		taskService.deleteTask(id);
	}

	@Override
	public void markTaskAsFinished(Long id) throws BusinessException {
		taskService.markTaskAsFinished(id);
	}

	@Override
	public void updateTask(Task task) throws BusinessException {
		taskService.updateTask(task);
	}

	@Override
	public Task findTaskById(Long id) throws BusinessException {
		return taskService.findTaskById(id);
	}

	@Override
	public List<Task> findInboxTasksByUserId(Long id) throws BusinessException {
		return taskService.findInboxTasksByUserId(id);
	}

	@Override
	public List<Task> findWeekTasksByUserId(Long id) throws BusinessException {
		return taskService.findWeekTasksByUserId(id);
	}

	@Override
	public List<Task> findTodayTasksByUserId(Long id) throws BusinessException {
		return taskService.findTodayTasksByUserId(id);
	}

	@Override
	public List<Task> findTasksByCategoryId(Long id) throws BusinessException {
		return taskService.findTasksByCategoryId(id);
	}

	@Override
	public List<Task> findFinishedTasksByCategoryId(Long id)
			throws BusinessException {
		return taskService.findFinishedTasksByCategoryId(id);
	}

	@Override
	public List<Task> findFinishedInboxTasksByUserId(Long id)
			throws BusinessException {
		return taskService.findFinishedInboxTasksByUserId(id);
	}
	
	
}
