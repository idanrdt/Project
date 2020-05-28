package com.project.hit.view.loginPage;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.view.View;

public interface LoginView extends View {
	
	/**
	 * Sets the controller to this view.
	 * @param controller related to this view.
	 */
	public void setController(LoginController controller);
}
