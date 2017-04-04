package com.sdi.business.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sdi.business.AdminService;
import com.sdi.business.TaskService;
import com.sdi.business.UserService;
import com.sdi.business.ServicesFactory;

public class LocalEjbServicesLocator implements ServicesFactory {
	private static final String ALUMNOS_SERVICE_JNDI_KEY = "java:global/"
			+ "Notaneitor_v4.0/" + "Notaneitor_v4.0EJB/" + "EjbAlumnosService!"
			+ "com.sdi.business.impl.LocalAlumnosService";

	/*@Override
	public UserService getUserService() {
		try {
			Context ctx = new InitialContext();
			return (UserService) ctx.lookup(ALUMNOS_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}*/

	@Override
	public UserService createUserService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminService createAdminService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskService createTaskService() {
		// TODO Auto-generated method stub
		return null;
	}
}