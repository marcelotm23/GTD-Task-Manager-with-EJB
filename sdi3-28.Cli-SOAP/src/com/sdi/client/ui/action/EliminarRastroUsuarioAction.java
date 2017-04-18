package com.sdi.client.ui.action;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.ws.AdminService;
import com.sdi.ws.EjbAdminServiceService;

public class EliminarRastroUsuarioAction implements Action{

	@Override
	public void execute() throws Exception {
		Long id = Console.readLong("Id del usuario");
		
		AdminService adminService = new EjbAdminServiceService()
									.getAdminServicePort();
		try{
			adminService.deepDeleteUser(id);
		} catch (Exception e) {
			Console.println("ERROR:" + e.getMessage());
		}
		
		
		Console.println("Usuario eliminado");
	}

}
