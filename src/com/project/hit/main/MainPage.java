package com.project.hit.main;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.controller.loginController.LoginPageController;
import com.project.hit.model.AuthenticationSystem;
import com.project.hit.view.loginPage.LoginPageView;
import com.project.hit.view.loginPage.LoginView;

public class MainPage {

	/**
	 * Launch the application - main function.
	 */
	public static void main(String[] args) {
		LoginView view = new LoginPageView();
		
		AuthenticationSystem model = new AuthenticationSystem();
		
		LoginController controller = new LoginPageController(view, model);
		
		view.setController(controller);

		view.start();
	}
}