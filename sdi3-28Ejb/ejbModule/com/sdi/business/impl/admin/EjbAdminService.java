package com.sdi.business.impl.admin;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jws.WebService;

import com.sdi.business.exception.BusinessException;
import com.sdi.business.integration.Auditor;
import com.sdi.model.User;
import com.sdi.model.UserDTO;

/**
 * Session Bean implementation class EjbAdminService
 */
@Stateless
@WebService(name = "AdminService")
public class EjbAdminService implements RemoteAdminService, LocalAdminService {

	@EJB
	private Auditor auditor;

	/**
	 * Default constructor.
	 */
	public EjbAdminService() {
	}

	@Override
	public void deepDeleteUser(Long id) throws BusinessException, JMSException {
		try {
			new AdminServiceImpl().deepDeleteUser(id);
		} catch (BusinessException be) {
			String message = be.getMessage();
			auditor.audit("deepDeleteUser(" + id + ")", message);

		}
	}

	@Override
	public void disableUser(Long id) throws BusinessException, JMSException {
		try {
			new AdminServiceImpl().disableUser(id);
		} catch (BusinessException be) {
			String message = be.getMessage();
			auditor.audit("disableUser(" + id + ")", message);
			throw new BusinessException(message);
		}
	}

	@Override
	public void enableUser(Long id) throws BusinessException, JMSException {
		try {
			new AdminServiceImpl().enableUser(id);
		} catch (BusinessException be) {
			String message = be.getMessage();
			auditor.audit("enableUser(" + id + ")", message);
			throw new BusinessException(message);
		}
	}

	@Override
	public List<User> findAllUsers() throws BusinessException, JMSException {
		try {
			return new AdminServiceImpl().findAllUsers();
		} catch (BusinessException be) {
			String message = be.getMessage();
			auditor.audit("findAllUsers()", message);
			throw new BusinessException(message);
		}
	}

	@Override
	public User findUserById(Long id) throws BusinessException, JMSException {
		try {
			return new AdminServiceImpl().findUserById(id);
		} catch (BusinessException be) {
			String message = be.getMessage();
			auditor.audit("findUserById(" + id + ")", message);
			throw new BusinessException(message);
		}
	}

	@Override
	public List<UserDTO> findAllUsersDTO() throws BusinessException,
			JMSException {
		try {
			return new AdminServiceImpl().findAllUsersDTO();
		} catch (BusinessException be) {
			String message = be.getMessage();
			auditor.audit("findAllUsersDTO()", message);
			throw new BusinessException(message);
		}
	}
}
