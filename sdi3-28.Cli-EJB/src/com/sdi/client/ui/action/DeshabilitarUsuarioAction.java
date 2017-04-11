package com.sdi.client.ui.action;

import javax.naming.Context;
import javax.naming.InitialContext;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.business.AdminService;

public class DeshabilitarUsuarioAction implements Action{
	private static final String BASE_JNDI_KEY = "sdi3-28/" + "sdi3-28.EJB/";
	private static final String ADMIN_SERVICE_JNDI_KEY = BASE_JNDI_KEY
			+ "EjbAdminService!"
			+ "com.sdi.business.impl.admin.RemoteAdminService";
	@Override
	public void execute() throws Exception {
		Long id = Console.readLong("Id del usuario");
		Context ctx = new InitialContext();
		AdminService adminService = (AdminService) ctx
				.lookup(ADMIN_SERVICE_JNDI_KEY);
		
		adminService.disableUser(id);
		
		Console.println("Usuario deshabilitado");
		
	}

}
