package com.project.hit.viewSwitcher;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.controller.loginController.LoginPageController;
import com.project.hit.controller.mainController.MainController;
import com.project.hit.controller.mainController.MainPageController;
import com.project.hit.model.AuthenticationSystem;
import com.project.hit.view.loginPage.LoginPageView;
import com.project.hit.view.loginPage.LoginView;
import com.project.hit.view.mainView.MainPageView;
import com.project.hit.view.mainView.MainView;

public class ViewSwitcher {
	
	private ViewSwitcher() {
	}
	
	public static void changeView(ViewSelect select) {
		switch(select) {
		case LOGIN_VIEW:
			startLogin();
			break;
		case MAIN_VIEW:
			startMain();
			break;
		}
	}
	
	private static void startLogin() {
		
		LoginView view = new LoginPageView();
		
		AuthenticationSystem model = new AuthenticationSystem();
		
		LoginController controller = new LoginPageController(view, model);
		
		view.setController(controller);

		view.start();
	}
	
	private static void startMain() {
		MainView view = new MainPageView();
		
		MainController controller = new MainPageController();
		
		view.setController(controller);
		
		view.start();
	}
}
