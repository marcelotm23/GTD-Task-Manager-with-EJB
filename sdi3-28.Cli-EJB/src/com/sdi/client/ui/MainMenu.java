package com.sdi.client.ui;

import com.sdi.client.ui.action.DeshabilitarUsuarioAction;
import com.sdi.client.ui.action.EliminarRastroUsuarioAction;
import com.sdi.client.ui.action.ListarUsuariosAction;

import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Administrador", null },
			{ "Listar usuarios del sistema", 			
				ListarUsuariosAction.class }, 
			{ "Deshabilitar un usuario del sistema", 			
					DeshabilitarUsuarioAction.class },
			{ "Eliminar todo rastro en el sistema de un usuario", 	
						EliminarRastroUsuarioAction.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
