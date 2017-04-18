package com.sdi.client.ui.action;

import java.util.List;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.ws.AdminService;
import com.sdi.ws.EjbAdminServiceService;
import com.sdi.ws.User;

public class ListarUsuariosAction implements Action {
	

	@Override
	public void execute() throws Exception {
		
		AdminService adminService = new EjbAdminServiceService()
									.getAdminServicePort();
//		try {
			List<User> users = adminService.findAllUsers();

			if (users.size() == 0) {
				Console.println("No hay usuarios registrados");
			} else {
				Console.println("Id\tLogin\tEmail\tAdministrador\tEstado");
				for (User user : users) {
					Console.println(user.getId() + "\t" + user.getLogin()
							+ "\t" + user.getEmail() + "\t" + user.isIsAdmin()
							+ "\t" + user.getStatus());
				}
				// TODO Falta el número de
				// tareas completadas, el número de tareas completadas
				// retrasadas, el
				// número de tareas planificadas y el número de tareas sin
				// planificar
			}
//		} catch (Exception e) {
//			Console.println("ERROR:" + e.getMessage());
//		}
	}
}
