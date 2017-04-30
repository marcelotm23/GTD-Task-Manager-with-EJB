package com.sdi.business;

import java.util.List;

import javax.jms.JMSException;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;
import com.sdi.model.UserDTO;

public interface AdminService {

	public void deepDeleteUser(Long id) throws BusinessException, JMSException;
	public void disableUser(Long id) throws BusinessException, JMSException;
	public void enableUser(Long id) throws BusinessException, JMSException;

	public List<User> findAllUsers() throws BusinessException, JMSException;
	public User findUserById(Long id) throws BusinessException, JMSException;

	public List<UserDTO> findAllUsersDTO() throws BusinessException,
			JMSException;
}
