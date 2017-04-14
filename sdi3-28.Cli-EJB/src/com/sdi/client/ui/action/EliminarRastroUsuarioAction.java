package com.sdi.client.ui.action;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.sdi.business.AdminService;
import com.sdi.business.exception.BusinessException;

import alb.util.console.Console;
import alb.util.menu.Action;

public class EliminarRastroUsuarioAction implements Action{

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
		try{
			adminService.deepDeleteUser(id);
		} catch (BusinessException e) {
			Console.println("ERROR:" + e.getMessage());
		}
		
		
		Console.println("Usuario eliminado");
	}

}
