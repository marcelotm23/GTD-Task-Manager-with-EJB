package com.sdi.business.impl.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;
import com.sdi.model.UserDTO;

/**
 * Session Bean implementation class EjbAdminService
 */
@Stateless
@WebService(name="AdminService")
public class EjbAdminService implements RemoteAdminService, LocalAdminService {

    /**
     * Default constructor. 
     */
    public EjbAdminService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		new AdminServiceImpl().deepDeleteUser(id);
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		new AdminServiceImpl().disableUser(id);
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		new AdminServiceImpl().enableUser(id);
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		return new AdminServiceImpl().findAllUsers();
	}

	@Override
	public User findUserById(Long id) throws BusinessException {
		return new AdminServiceImpl().findUserById(id);
	}

	@Override
	public List<UserDTO> findAllUsersDTO() throws BusinessException {
		return new AdminServiceImpl().findAllUsersDTO();
	}
}
