package com.sdi.client.ui.action;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.ws.AdminService;
import com.sdi.ws.EjbAdminServiceService;

public class DeshabilitarUsuarioAction implements Action {

	@Override
	public void execute() throws Exception {
		Long id = Console.readLong("Id del usuario");
		
		AdminService adminService = new EjbAdminServiceService()
									.getAdminServicePort();
		try {
			adminService.disableUser(id);
			Console.println("Usuario deshabilitado");
		} catch (Exception e) {
			Console.println("ERROR:" + e.getCause().getMessage());
		}

	}

}
