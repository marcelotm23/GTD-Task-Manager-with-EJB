package com.sdi.client.ui;


import com.sdi.client.action.FinalizarTareaAction;
import com.sdi.client.action.ListarCategoriasAction;
import com.sdi.client.action.ListarTareasAction;
import com.sdi.client.action.RegistrarTareaAction;

public class OptionsMenu extends BaseMenu {

	public OptionsMenu() {
		menuOptions = new Object[][] { 
			{ "Usuario", null },
			{ "Ver lista de categorías", 			
				ListarCategoriasAction.class }, 
			{ "Ver tareas por categorías", 			
					ListarTareasAction.class },
			{ "Marcar tarea como finalizada", 	
						FinalizarTareaAction.class },
			{ "Registrar una nueva tarea", 	
							RegistrarTareaAction.class },
		};
	}
	

}
