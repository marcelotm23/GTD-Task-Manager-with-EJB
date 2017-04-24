package com.sdi.client;

import com.sdi.client.action.FinalizarTareaAction;
import com.sdi.client.action.ListarCategoriasAction;
import com.sdi.client.action.ListarTareasAction;
import com.sdi.client.action.RegistrarTareaAction;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Usuario", null },
			{ "Ver lista de categorías", 			ListarCategoriasAction.class }, 
			{ "Ver tareas por categorías", 			ListarTareasAction.class },
			{ "Marcar tarea como finalizada", 	FinalizarTareaAction.class },
			{ "Registrar una nueva tarea", 	RegistrarTareaAction.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
		//TODO
				/*
				 * -Listar usuarios del sistema: sus datos personales, el número de
				 * tareas completadas, el número de tareas completadas retrasadas, el
				 * número de tareas planificadas y el número de tareas sin planificar.
				 * -Deshabilitar un usuario del sistema (UserStatus.DISABLED). 
				 * -Eliminar todo rastro en el sistema de un usuario. Implica eliminar 
				 * sus tareas, categorías y finalmente el usuario.
				 */
	}

}
