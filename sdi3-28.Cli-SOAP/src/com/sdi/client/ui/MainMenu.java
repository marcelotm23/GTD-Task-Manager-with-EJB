package com.sdi.client.ui;

import com.sdi.client.ui.action.DeshabilitarUsuarioAction;
import com.sdi.client.ui.action.EliminarRastroUsuarioAction;
import com.sdi.client.ui.action.ListarUsuariosAction;

import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Administrador", null },
			{ "Listar usuarios del sistema", 			ListarUsuariosAction.class }, 
			{ "Deshabilitar un usuario del sistema", 			DeshabilitarUsuarioAction.class },
			{ "Eliminar todo rastro en el sistema de un usuario", 	EliminarRastroUsuarioAction.class },
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
