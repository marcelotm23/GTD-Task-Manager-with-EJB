package com.sdi.rest.impl;

import com.sdi.business.TaskService;
import com.sdi.business.UserService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.rest.UserServiceRest;

public class UserServiceRestImpl implements UserServiceRest{

	private UserService userService = Factories.services.getUserService();
	@Override
	public User findLoggableUser(String login, String password)
			throws BusinessException {
		return userService.findLoggableUser(login, password);
	}

}
