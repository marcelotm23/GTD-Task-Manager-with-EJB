package com.sdi.business.impl.task;

import java.util.List;

import com.sdi.business.TaskService;
import com.sdi.business.exception.BusinessException;
import com.sdi.business.impl.command.Command;
import com.sdi.business.impl.task.command.CreateCategoryCommand;
import com.sdi.business.impl.task.command.CreateTaskCommand;
import com.sdi.business.impl.task.command.DeleteCategoryCommand;
import com.sdi.business.impl.task.command.DuplicateCategoryCommand;
import com.sdi.business.impl.task.command.MarkTaskAsFinishedCommand;
import com.sdi.business.impl.task.command.UpdateCategoryCommand;
import com.sdi.business.impl.task.command.UpdateTaskCommand;
import com.sdi.model.Category;
import com.sdi.model.Task;
import com.sdi.persistence.Persistence;

public class TaskServiceImpl implements TaskService {

	@Override
	public Long createCategory(Category category) throws BusinessException {
		return new CreateCategoryCommand(
				category).execute();
	}

	@Override
	public Long duplicateCategory(Long id) throws BusinessException {
		return new DuplicateCategoryCommand(id).execute();
	}

	@Override
	public void updateCategory(Category category) throws BusinessException {
		new UpdateCategoryCommand(category).execute();
	}

	@Override
	public void deleteCategory(Long catId) throws BusinessException {
		new DeleteCategoryCommand(catId).execute();
	}

	@Override
	public Category findCategoryById(final Long id) throws BusinessException {
		return (new Command<Category>() {
			@Override
			public Category execute() throws BusinessException {

				return Persistence.getCategoryDao().findById(id);
			}
		}).execute();
	}
	
	@Override
	public Category findCategoryByUserIdAndName(final Long id, final String name)
			throws BusinessException {
		return (new Command<Category>() {
			@Override
			public Category execute() throws BusinessException {
				return Persistence.getCategoryDao().findByUserIdAndName(id, name);
			}
		}).execute();
	}

	@Override
	public List<Category> findCategoriesByUserId(final Long id)
			throws BusinessException {
		return (new Command<List<Category>>() {
					@Override
					public List<Category> execute() throws BusinessException {

						return Persistence.getCategoryDao().findByUserId(id);
					}
				}).execute();
	}

	@Override
	public Long createTask(Task task) throws BusinessException {
		return new CreateTaskCommand(task).execute();
	}

	@Override
	public void deleteTask(final Long id) throws BusinessException {
		(new Command<Void>() {
			@Override
			public Void execute() throws BusinessException {
				Persistence.getTaskDao().delete(id);
				return null;
			}
		}).execute();
	}

	@Override
	public void markTaskAsFinished(Long id) throws BusinessException {
		new MarkTaskAsFinishedCommand(id).execute();
	}

	@Override
	public void updateTask(Task task) throws BusinessException {
		new UpdateTaskCommand(task).execute();
	}

	@Override
	public Task findTaskById(final Long id) throws BusinessException {
		return (new Command<Task>() {
			@Override
			public Task execute() throws BusinessException {

				return Persistence.getTaskDao().findById(id);
			}
		}).execute();
	}

	@Override
	public List<Task> findInboxTasksByUserId(final Long id)
			throws BusinessException {
		return (new Command<List<Task>>() {
					@Override
					public List<Task> execute() throws BusinessException {

						return Persistence.getTaskDao().findInboxTasksByUserId(
								id);
					}
				}).execute();
	}

	@Override
	public List<Task> findWeekTasksByUserId(final Long id)
			throws BusinessException {
		return (new Command<List<Task>>() {
					@Override
					public List<Task> execute() throws BusinessException {

						return Persistence.getTaskDao().findWeekTasksByUserId(
								id);
					}
				}).execute();
	}

	@Override
	public List<Task> findTodayTasksByUserId(final Long id)
			throws BusinessException {
		return (new Command<List<Task>>() {
					@Override
					public List<Task> execute() throws BusinessException {

						return Persistence.getTaskDao().findTodayTasksByUserId(
								id);
					}
				}).execute();
	}

	@Override
	public List<Task> findTasksByCategoryId(final Long id)
			throws BusinessException {
		return (new Command<List<Task>>() {
					@Override
					public List<Task> execute() throws BusinessException {

						return Persistence.getTaskDao().findTasksByCategoryId(
								id);
					}
				}).execute();
	}

	@Override
	public List<Task> findFinishedTasksByCategoryId(final Long id)
			throws BusinessException {
		return (new Command<List<Task>>() {
					@Override
					public List<Task> execute() throws BusinessException {

						return Persistence.getTaskDao()
								.findFinishedTasksByCategoryId(id);
					}
				}).execute();
	}

	@Override
	public List<Task> findFinishedInboxTasksByUserId(final Long id)
			throws BusinessException {
		return (new Command<List<Task>>() {
					@Override
					public List<Task> execute() throws BusinessException {

						return Persistence.getTaskDao()
								.findFinishedTasksInboxByUserId(id);
					}
				}).execute();
	}

}
