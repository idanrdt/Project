package com.MHR.model;

import com.MHR.controller.Controller;

import authentication.AuthenticationSystem;
import authentication.InvalidCredentialsException;

public class LoginPageModel implements Model{
	
	private AuthenticationSystem auth;
	private Controller controller;
	
	public boolean checkCredentials(String userName, char[] password) {
		auth = new AuthenticationSystem();
		try {
			auth.authenticate(userName, password);
			return true;
		} catch (InvalidCredentialsException ice) {
			controller.setError(ice.getMessage());
			return false;
		}
	}

	@Override
	public void setController(Controller controller) {	
		this.controller = controller;
	}
}
