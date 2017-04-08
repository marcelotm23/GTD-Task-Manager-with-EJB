package com.sdi.business.impl.admin;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;

/**
 * Session Bean implementation class EjbAdminService
 */
@Stateless
public class EjbAdminService implements EjbAdminServiceRemote, EjbAdminServiceLocal {

    /**
     * Default constructor. 
     */
    public EjbAdminService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
