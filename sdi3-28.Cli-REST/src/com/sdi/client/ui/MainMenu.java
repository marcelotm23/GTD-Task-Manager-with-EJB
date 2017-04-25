package com.sdi.client.ui;

import com.sdi.client.action.AuthenticateAction;

import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu{
	
	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "GTD REST Client", null},
			{ "Authenticate", AuthenticateAction.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	
	}
}
