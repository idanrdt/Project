package main;

import com.project.hit.controller.LoginController;
import com.project.hit.controller.LoginPageController;
import com.project.hit.model.AuthenticationSystem;
import com.project.hit.view.LoginPageView;

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
