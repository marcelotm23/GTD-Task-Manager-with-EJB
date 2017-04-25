package com.sdi.client.ui;

import com.sdi.client.dtos.User;




/**
 * Representa cada acción invocada por el usuario. 
 * 
 * 	Cada acción se encargará de la interacción con el usuario:
 * pantalla, teclado, listados y validaciones; e invocará a 
 * la capa de servicios.
 * 
 * @author alb
 */
public interface Action {
	void execute(User user) throws Exception;
}
