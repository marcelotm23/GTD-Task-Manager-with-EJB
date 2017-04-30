package com.sdi.client.ui;

import com.sdi.client.action.FinalizarTareaAction;
import com.sdi.client.action.ListarTareasAction;
import com.sdi.client.action.RegistrarTareaAction;

import alb.util.menu.BaseMenu;

public class OptionsMenu extends BaseMenu{
	
	public OptionsMenu() {
		menuOptions = new Object[][] { 
			{ "Opciones", null},
			{ "Ver las tareas de la pseudolista Hoy y atrasadas", ListarTareasAction.class },
			{ "Finalizar una tarea", FinalizarTareaAction.class },
			{ "Añadir una tarea", RegistrarTareaAction.class },
		};
	}
}
