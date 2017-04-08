package com.sdi.business.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sdi.business.AdminService;
import com.sdi.business.ServicesFactory;
import com.sdi.business.TaskService;
import com.sdi.business.UserService;

public class RemoteEjbServicesLocator implements ServicesFactory {

	private static final String USER_SERVICE_JNDI_KEY = "sdi3-28/"
			+ "sdi3-28Ejb/" + "EjbUserService!"
			+ "com.sdi.business.impl.user.EjbUserServiceRemote";

	private static final String TASK_SERVICE_JNDI_KEY = "sdi3-28/"
			+ "sdi3-28Ejb/" + "EjbTaskService!"
			+ "com.sdi.business.impl.task.EjbTaskServiceRemote";

	private static final String ADMIN_SERVICE_JNDI_KEY = "sdi3-28/"
			+ "sdi3-28Ejb/" + "EjbAdminService!"
			+ "com.sdi.business.impl.admin.EjbAdminServiceRemote";

	@Override
	public UserService getUserService() {
		try {
			Context ctx = new InitialContext();
			return (UserService) ctx.lookup(USER_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public AdminService getAdminService() {
		try {
			Context ctx = new InitialContext();
			return (AdminService) ctx.lookup(ADMIN_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public TaskService getTaskService() {
		try {
			Context ctx = new InitialContext();
			return (TaskService) ctx.lookup(TASK_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}
}