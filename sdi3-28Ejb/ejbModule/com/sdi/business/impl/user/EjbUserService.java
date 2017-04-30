package com.sdi.business.impl.user;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;

/**
 * Session Bean implementation class EjbUserService
 */
@Stateless
public class EjbUserService implements RemoteUserService, LocalUserService {

//	@EJB private Auditor auditor;
	
    /**
     * Default constructor. 
     */
    public EjbUserService() {
    }

	@Override
	public Long registerUser(User user) throws BusinessException {
//		auditor.audit("registerUser(" + user.getLogin() + ")");
		return new UserServiceImpl().registerUser(user);
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		new UserServiceImpl().updateUserDetails(user);
//		auditor.audit("updateUserDetails(" + user.getLogin() + ")");
	}

	@Override
	public User findLoggableUser(String login, String password)
			throws BusinessException {
//		auditor.audit("findLoggableUser(" + login + ", " + password + ")");
		return new UserServiceImpl().findLoggableUser(login, password);
	}

}
