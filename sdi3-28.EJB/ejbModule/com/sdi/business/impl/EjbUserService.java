package com.sdi.business.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;

/**
 * Session Bean implementation class EjbUserService
 */
@Stateless
//@LocalBean
public class EjbUserService implements EjbUserServiceRemote, EjbUserServiceLocal {

    /**
     * Default constructor. 
     */
    public EjbUserService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Long registerUser(User user) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findLoggableUser(String login, String password)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
