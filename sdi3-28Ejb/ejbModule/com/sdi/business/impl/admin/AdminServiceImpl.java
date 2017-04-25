package com.sdi.business.impl.admin;

import java.util.List;

import com.sdi.business.AdminService;
import com.sdi.business.exception.BusinessException;
import com.sdi.business.impl.admin.command.DeepDeleteUserCommand;
import com.sdi.business.impl.admin.command.DisableUserCommand;
import com.sdi.business.impl.admin.command.EnableUserCommand;
import com.sdi.business.impl.command.Command;
import com.sdi.model.User;
import com.sdi.model.UserDTO;
import com.sdi.persistence.Persistence;

public class AdminServiceImpl implements AdminService {

	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		new DeepDeleteUserCommand(id).execute();
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		new DisableUserCommand(id).execute();
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		new EnableUserCommand(id).execute();
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		return (new Command<List<User>>() {
					@Override
					public List<User> execute() throws BusinessException {
						return Persistence.getUserDao().findAll();
					}
				}).execute();
	}

	@Override
	public User findUserById(final Long id) throws BusinessException {
		return (new Command<User>() {
			@Override
			public User execute() throws BusinessException {
				return Persistence.getUserDao().findById(id);
			}
		}).execute();
	}

	@Override
	public List<UserDTO> findAllUsersDTO() throws BusinessException {
		return (new Command<List<UserDTO>>() {
			@Override
			public List<UserDTO> execute() throws BusinessException {
				return Persistence.getUserDao().findAllDTO();
			}
		}).execute();
	}
}
