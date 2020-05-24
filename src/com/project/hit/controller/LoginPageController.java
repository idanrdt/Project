package com.project.hit.controller;

import com.project.hit.model.AuthenticationSystem;
import com.project.hit.model.InvalidCredentialsException;
import com.project.hit.view.LoginView;

public class LoginPageController implements LoginController {
	
	private LoginView view;
	private AuthenticationSystem authSystem;
	
	public LoginPageController(LoginView view, AuthenticationSystem model) {
		this.view = view;
		this.authSystem = model;
	}
	
	
	private void openMainMenu() {
		//TODO: open the main window;
	}


	@Override
	public void authenticate(String username, char[] password) throws InvalidCredentialsException {
		if (authSystem.authenticate(username, password)) {
			view.close();
			openMainMenu();
		}
	}
}
