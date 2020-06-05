package com.project.hit.controller.loginController;

import java.io.IOException;

import com.project.hit.controller.mainController.NavigationFailedException;
import com.project.hit.details.User;
import com.project.hit.model.AuthenticationSystem;
import com.project.hit.model.InvalidCredentialsException;
import com.project.hit.view.loginPage.LoginView;
import com.project.hit.viewSwitcher.ViewSelect;
import com.project.hit.viewSwitcher.ViewSwitcher;

public class LoginPageController implements LoginController {
	
	private LoginView view;
	private AuthenticationSystem authSystem;
	
	/**
	 * The controller constructor.
	 * @param view - The view of the Login page.
	 * @param model - the model usage of the Login page.
	 */
	public LoginPageController(LoginView view, AuthenticationSystem model) {
		this.view = view;
		this.authSystem = model;
	}
	
	@Override
	public void authenticate(String username, char[] password) throws InvalidCredentialsException, ClassNotFoundException, IOException {
		User user = authSystem.authenticate(username, password);
		if (user != null) {
			view.close();
			openMainMenu(user);
		}
	}
	
	/**
	 * Opens the main menu dialog.
	 * @param user - The {@link User} object that authorize to use the application.
	 */
	private void openMainMenu(User user) {
		try {
			ViewSwitcher.changeView(ViewSelect.MAIN_VIEW, user);
		} catch (NavigationFailedException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
