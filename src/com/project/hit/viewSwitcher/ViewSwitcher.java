package com.project.hit.viewSwitcher;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.controller.loginController.LoginPageController;
import com.project.hit.controller.mainController.MainController;
import com.project.hit.controller.mainController.MainPageController;
import com.project.hit.controller.mainController.NavigationFailedException;
import com.project.hit.details.User;
import com.project.hit.model.AuthenticationSystem;
import com.project.hit.view.loginPage.LoginPageView;
import com.project.hit.view.loginPage.LoginView;
import com.project.hit.view.mainView.MainPageView;
import com.project.hit.view.mainView.MainView;

public class ViewSwitcher {
	
	private static int loginCounter = 0;
	
	/**
	 * Not allowing the creation of a new instance.
	 */
	private ViewSwitcher() {
	}
	
	public static void changeView(ViewSelect select) throws NavigationFailedException {
		if(select == ViewSelect.LOGIN_VIEW) {
			if(loginCounter == 0) {
				loginCounter++;
				startLogin();
			}
			else {
				throw new NavigationFailedException("Too many attempts to call login Logain Page.");
			}
		}
		else {
			throw new NavigationFailedException("Failed to navigate to the requested page.");
		}
	}
	
	public static void changeView(ViewSelect select, User user) throws NavigationFailedException {
		switch(select) {
		case MAIN_VIEW:
			startMain(user);
			break;
		case ORDER_VIEW:
		case SUPPLIER_VIEW:
		case REPORT_VIEW:
		default:
			throw new NavigationFailedException("Failed to navigate to the requested page.");
		}
	}
	
	private static void startLogin() {
		
		LoginView view = new LoginPageView();
		
		AuthenticationSystem model = new AuthenticationSystem();
		
		LoginController controller = new LoginPageController(view, model);
		
		view.setController(controller);

		view.start();
	}
	
	private static void startMain(User user) {
		
		MainView view = new MainPageView(user);
		
		MainController controller = new MainPageController(view);
		
		view.setController(controller);
		
		view.start();
	}
}
