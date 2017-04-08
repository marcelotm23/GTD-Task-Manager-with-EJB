package com.sdi.business.impl;


import com.sdi.business.AdminService;
import com.sdi.business.ServicesFactory;
import com.sdi.business.TaskService;
import com.sdi.business.UserService;

public class SimpleServicesFactory implements ServicesFactory {

	

	@Override
	public UserService getUserService() {
		return new SimpleUserService();
	}

	@Override
	public AdminService getAdminService() {
		return new SimpleAdminService();
	}

	@Override
	public TaskService getTaskService() {
		return new SimpleTaskService();
	}

}
