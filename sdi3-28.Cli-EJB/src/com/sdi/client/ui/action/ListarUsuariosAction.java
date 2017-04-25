package com.sdi.client.ui.action;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import alb.util.console.Console;
import alb.util.menu.Action;

import com.sdi.business.AdminService;
import com.sdi.business.exception.BusinessException;
import com.sdi.model.User;
import com.sdi.model.UserDTO;

public class ListarUsuariosAction implements Action {
	private static final String BASE_JNDI_KEY = "sdi3-28/" + "sdi3-28.EJB/";
	private static final String ADMIN_SERVICE_JNDI_KEY = BASE_JNDI_KEY
			+ "EjbAdminService!"
			+ "com.sdi.business.impl.admin.RemoteAdminService";

	@Override
	public void execute() throws Exception {
		Context ctx = new InitialContext();
		AdminService adminService = (AdminService) ctx
				.lookup(ADMIN_SERVICE_JNDI_KEY);
		try {
			List<UserDTO> users = adminService.findAllUsersDTO();

			if (users.size() == 0) {
				Console.println("No hay usuarios registrados");
			} else {
				Console.println("Id\tLogin\tEmail\tAdministrador\tEstado");
				for (UserDTO user : users) {
					Console.println(user.getId() + "\t" + user.getLogin()
							+ "\t" + user.getEmail() + "\t" + user.getIsAdmin()
							+ "\t" + user.getStatus());
				}
				// TODO Falta el número de
				// tareas completadas, el número de tareas completadas
				// retrasadas, el
				// número de tareas planificadas y el número de tareas sin
				// planificar
			}
		} catch (BusinessException e) {
			Console.println("ERROR:" + e.getMessage());
		}
	}
}
