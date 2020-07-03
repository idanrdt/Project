package com.project.hit.viewSwitcher;

import java.io.IOException;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.controller.loginController.LoginPageController;
import com.project.hit.controller.mainController.MainController;
import com.project.hit.controller.mainController.MainPageController;
import com.project.hit.controller.mainController.NavigationFailedException;
import com.project.hit.controller.managerController.ManagerController;
import com.project.hit.controller.managerController.ManagerPageController;
import com.project.hit.controller.reportController.ReportController;
import com.project.hit.controller.reportController.ReportPageController;
import com.project.hit.controller.supplierController.SupplierController;
import com.project.hit.controller.supplierController.SupplierPageController;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.authenticationSystem.AuthenticationSystem;
import com.project.hit.model.managerSystem.ManagerProperties;
import com.project.hit.model.managerSystem.ManagerPropertiesRepository;
import com.project.hit.model.managerSystem.details.User;
import com.project.hit.model.reportSystem.ReportSystem;
import com.project.hit.model.reportSystem.ReportSystemRepository;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.view.ReportView.ReportPageView;
import com.project.hit.view.ReportView.ReportView;
import com.project.hit.view.loginPage.LoginPageView;
import com.project.hit.view.loginPage.LoginView;
import com.project.hit.view.mainView.MainPageView;
import com.project.hit.view.mainView.MainView;
import com.project.hit.view.managerView.ManagerPageView;
import com.project.hit.view.managerView.ManagerView;
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
		case SETTINGS_VIEW:
			startSettings();
			break;
		case ORDER_VIEW:
			startOrder(user);
			break;
		case REPORT_VIEW:
			startReport(user);
			break;
		default:
			throw new NavigationFailedException("Failed to navigate to the requested page.");
		}
	}
	
	/**
	 * Set and starts the {@link LoginView}.
	 */
	private static void startLogin() {
		
		LoginView view = new LoginPageView();
		
		AuthenticationSystem model = AuthenticationSystem.getAuthenticationSystem();
		
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
	
	/**
	 * Set and starts the {@link SupplierPageView}.
	 * @param user - the {@link User} that logged in.
	 * @throws NavigationFailedException - if the navigation failed.
	 */
	private static void startSupplier(User user) throws NavigationFailedException {
		
		SupplierView view = new SupplierPageView(user);		
		try {
			MangeSupplier model = MangeSupplier.getMangeSupplierSinglton();
			
			SupplierController controller = new SupplierPageController(model);
			
			view.setController(controller);
			
			view.start();
		} catch (EnumNameNotFoundException | IOException e) {
			throw new NavigationFailedException("Faild to navigate");
			//TODO: add log.
		} catch (ClassNotFoundException e) {
			throw new NavigationFailedException("File missing or corrupted");
		}
	}
	
	/**
	 * Set and starts the {@link ManagerPageView}.
	 * @param user - the {@link User} that logged in.
	 * @throws NavigationFailedException - if the navigation failed.
	 */
	private static void startSettings() throws NavigationFailedException {
		
		ManagerView view = new ManagerPageView();		
		try {
			ManagerPropertiesRepository model = ManagerProperties.getManagerProperties();
			
			ManagerController controller = new ManagerPageController(model);
			
			view.setController(controller);
			
			view.start();
		} catch (EnumNameNotFoundException | IOException e) {
			throw new NavigationFailedException("Faild to navigate");
		} catch (ClassNotFoundException e) {
			throw new NavigationFailedException("File missing or corrupted");
		}
		

	}
	
	private static void startOrder(User user) throws NavigationFailedException {

	}
	
	private static void startReport(User user) throws NavigationFailedException{
		ReportView view = new ReportPageView();
		try {
			ReportSystemRepository model = new ReportSystem();
			
			ReportController controller = new ReportPageController(model);
			
			view.setController(controller);
			
			view.start();
		} catch ( IOException e) {
			throw new NavigationFailedException("Faild to navigate");
		} catch (ClassNotFoundException e) {
			throw new NavigationFailedException("File missing or corrupted");
		}
	}
}
