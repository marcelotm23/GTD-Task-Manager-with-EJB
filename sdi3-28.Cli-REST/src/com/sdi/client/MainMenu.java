package com.sdi.client;

import com.sdi.client.action.ListarCategoriasAction;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Usuario", null },
			{ "Ver lista de categorías", 			ListarCategoriasAction.class }, 
			{ "Ver tareas por categorías", 			NotYetImplementedAction.class },
			{ "Marcar tarea como finalizada", 	NotYetImplementedAction.class },
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
