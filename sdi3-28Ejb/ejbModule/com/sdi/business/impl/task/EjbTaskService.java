package com.sdi.business.impl.task;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.Category;
import com.sdi.model.Task;

/**
 * Session Bean implementation class EjbTaskService
 */
@Stateless
public class EjbTaskService implements EjbTaskServiceRemote, EjbTaskServiceLocal {

    /**
     * Default constructor. 
     */
    public EjbTaskService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Long createCategory(Category category) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long duplicateCategory(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCategory(Category category) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findCategoryById(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findCategoriesByUserId(Long id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategoryByUserIdAndName(Long id, String name)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long createTask(Task task) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTask(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markTaskAsFinished(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTask(Task task) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task findTaskById(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findInboxTasksByUserId(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findWeekTasksByUserId(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findTodayTasksByUserId(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findTasksByCategoryId(Long catId)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findFinishedTasksByCategoryId(Long catId)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findFinishedInboxTasksByUserId(Long userId)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
