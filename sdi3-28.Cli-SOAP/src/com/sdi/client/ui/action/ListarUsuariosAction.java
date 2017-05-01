package com.sdi.client.ui.action;

import java.util.List;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.ws.AdminService;
import com.sdi.ws.EjbAdminServiceService;
import com.sdi.ws.UserDTO;

public class ListarUsuariosAction implements Action {
	

	@Override
	public void execute() throws Exception {
		
		AdminService adminService = new EjbAdminServiceService()
									.getAdminServicePort();
		try {
			List<UserDTO> users = adminService.findAllUsersDTO();

			if (users.size() == 0) {
				Console.println("No hay usuarios registrados");
			} else {
				printUsersList(users);
			}
		} catch (Exception e) {
			Console.println("ERROR:" + e.getCause().getMessage());
		}
	}
	
	private void printUsersList(List<UserDTO> users) {
		Console.println("Id\tLogin\tEmail\tAdministrador\tEstado"
				+ "\tNº tareas completadas\tNº tareas retrasadas\t"
				+ "Nº tareas planificadas\tNº tareas sin planificar");
		for (UserDTO user : users) {
			Console.println(user.getId() + "\t" + user.getLogin()
					+ "\t" + user.getEmail() + "\t" + user.isIsAdmin()
					+ "\t" + user.getStatus() +"\t\t\t"+
					user.getTareasCompletadas()+"\t\t\t"
					+user.getTareasCompletadasRetrasadas()+"\t\t\t"
					+user.getTareasPlanificadas()+"\t\t\t"
					+user.getTareasSinPlanificar());
		}
	}
}
