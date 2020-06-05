package com.project.hit.viewSwitcher;

import java.io.IOException;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.controller.loginController.LoginPageController;
import com.project.hit.controller.mainController.MainController;
import com.project.hit.controller.mainController.MainPageController;
import com.project.hit.controller.mainController.NavigationFailedException;
import com.project.hit.controller.supplierController.SupplierController;
import com.project.hit.controller.supplierController.SupplierPageController;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.authenticationSystem.AuthenticationSystem;
import com.project.hit.model.managerSystem.details.User;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.view.loginPage.LoginPageView;
import com.project.hit.view.loginPage.LoginView;
import com.project.hit.view.*;
import com.project.hit.view.mainView.MainPageView;
import com.project.hit.view.mainView.MainView;
import com.project.hit.view.supplierView.SupplierPageView;
import com.project.hit.view.supplierView.SupplierView;


public class ViewSwitcher {
	
	private static int loginCounter = 0;
	
	/**
	 * Not allowing the creation of a new instance.
	 */
	private ViewSwitcher() {
	}
	
	/**
	 * Change the view to the {@link LoginView}.
	 * @param select - The requested {@link View} from the {@link ViewSelect}.
	 * @throws NavigationFailedException if the navigation fails or the {@link LoginView} called more than once.
	 */
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
	
	/**
	 * Change the view to the requested {@link View}.
	 * @param select - The requested {@link View} from the {@link ViewSelect}.
	 * @param user - The {@link User} that logged in.
	 * @throws NavigationFailedException if the navigation fails.
	 */
	public static void changeView(ViewSelect select, User user) throws NavigationFailedException {
		switch(select) {
		case MAIN_VIEW:
			startMain(user);
			break;
		case SUPPLIER_VIEW:
			startSupplier(user);
			break;
		case ORDER_VIEW:
		case REPORT_VIEW:
		case SETTINGS_VIEW:
		default:
			throw new NavigationFailedException("Failed to navigate to the requested page.");
		}
	}
	
	/**
	 * Set and starts the {@link LoginView}.
	 */
	private static void startLogin() {
		
		LoginView view = new LoginPageView();
		
		AuthenticationSystem model = new AuthenticationSystem();
		
		LoginController controller = new LoginPageController(view, model);
		
		view.setController(controller);

		view.start();
	}
	
	/**
	 * Set and starts the {@link MainView}.
	 * @param user - The {@link User} that logged in.
	 */
	private static void startMain(User user) {
		
		MainView view = new MainPageView(user);
		
		MainController controller = new MainPageController(view);
		
		view.setController(controller);
		
		view.start();
	}
	
	private static void startSupplier(User user) throws NavigationFailedException {
		
		SupplierView view = new SupplierPageView(user);
		
		try {
			MangeSupplier model = new MangeSupplier();
		} catch (EnumNameNotFoundException | IOException e) {
			throw new NavigationFailedException("Faild to navigate");
			//TODO: add log.
		} catch (ClassNotFoundException e) {
			throw new NavigationFailedException("File missing or corrupted");
		}
		
		SupplierController controller = new SupplierPageController();
		
		view.setController(controller);
		
		view.start();
	}
}
