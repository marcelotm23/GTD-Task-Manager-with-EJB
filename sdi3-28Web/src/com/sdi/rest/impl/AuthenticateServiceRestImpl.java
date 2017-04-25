package com.sdi.rest.impl;

import com.sdi.business.UserService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.rest.AutenticateServiceRest;

public class AuthenticateServiceRestImpl implements AutenticateServiceRest{

	private UserService userService = Factories.services.getUserService();
	
	@Override
	public User authenticate(String login, String password)
			throws BusinessException {
		return userService.findLoggableUser(login, password);
	}

}
