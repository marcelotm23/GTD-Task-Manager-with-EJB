package com.sdi.business;

public interface ServicesFactory {
	
	UserService getUserService();
	
	AdminService getAdminService();
	
	TaskService getTaskService();

}
