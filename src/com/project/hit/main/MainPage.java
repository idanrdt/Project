package com.project.hit.main;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.controller.loginController.LoginPageController;
import com.project.hit.model.AuthenticationSystem;
import com.project.hit.view.loginPage.LoginPageView;

public class MainPage {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginPageView view = new LoginPageView();
		
		AuthenticationSystem model = new AuthenticationSystem();
		
		LoginController controller = new LoginPageController(view, model);
		
		view.setController(controller);

		view.start();
	}
}