package com.sdi.rest.impl;

import javax.xml.bind.DatatypeConverter;

import com.sdi.business.UserService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.rest.AutenticateServiceRest;

public class AuthenticateServiceRestImpl implements AutenticateServiceRest{

	private UserService userService = Factories.services.getUserService();
	
	@Override
	public User authenticate(String datos)
			throws BusinessException {
		String datos64=new String(
				DatatypeConverter.parseBase64Binary(datos));
		String[] datosSeparados=datos64.split(":");
		System.out.println("DATOS_"+datosSeparados.toString());
		return userService.findLoggableUser(datosSeparados[0], datosSeparados[1]);
	}

}
