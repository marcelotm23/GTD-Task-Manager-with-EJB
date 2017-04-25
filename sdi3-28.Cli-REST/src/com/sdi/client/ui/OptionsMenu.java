package com.sdi.client.ui;

import alb.util.menu.BaseMenu;

import com.sdi.client.action.FinalizarTareaAction;
import com.sdi.client.action.ListarCategoriasAction;
import com.sdi.client.action.ListarTareasAction;
import com.sdi.client.action.RegistrarTareaAction;
import com.sdi.client.dtos.User;

public class OptionsMenu extends BaseMenu {

	public OptionsMenu(User user) {
		menuOptions = new Object[][] { 
			{ "Usuario", null },
			{ "Ver lista de categorías", 			ListarCategoriasAction.class }, 
			{ "Ver tareas por categorías", 			ListarTareasAction.class },
			{ "Marcar tarea como finalizada", 	FinalizarTareaAction.class },
			{ "Registrar una nueva tarea", 	RegistrarTareaAction.class },
		};
	}

}
