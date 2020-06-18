package com.project.hit.controller.mainController;

import com.project.hit.model.managerSystem.details.User;
import com.project.hit.view.mainView.MainView;
import com.project.hit.viewSwitcher.ViewSelect;
import com.project.hit.viewSwitcher.ViewSwitcher;

public class MainPageController implements MainController {
	private MainView view;  //for future usage. Remove this line if not used (and in the c'tor also!).
	ViewSwitcher viewSwitcher;
	
	public MainPageController(MainView view) {
		this.view = view;
	}
	
	@Override
	public void navigateTo(ViewSelect select, User user) throws NavigationFailedException {
		switch(select) {
		case ORDER_VIEW:
			openOrderMenu(user);
			break;
		case REPORT_VIEW:
			openRepordMenu(user);
			break;
		case SUPPLIER_VIEW:
			openSupplierMenu(user);
			break;
		case SETTINGS_VIEW:
			openSettingsMenu(user);
			break;			
		default:
			throw new NavigationFailedException("The window requested does not exist.");
		}
	}
	
	/**
	 * Opens the order window.
	 * @param user - The {@link User} that just logged in.
	 * @throws NavigationFailedException if the navigation fails.
	 */
	private void openOrderMenu(User user) throws NavigationFailedException {
		ViewSwitcher.changeView(ViewSelect.ORDER_VIEW, user);
	}
	
	/**
	 * Opens the supplier window.
	 * @param user - The {@link User} that just logged in.
	 * @throws NavigationFailedException if the navigation fails.
	 */
	private void openSupplierMenu(User user) throws NavigationFailedException {
		ViewSwitcher.changeView(ViewSelect.SUPPLIER_VIEW, user);
	}
	
	/**
	 * Opens the report window.
	 * @param user - The {@link User} that just logged in.
	 * @throws NavigationFailedException if the navigation fails.
	 */
	private void openRepordMenu(User user) throws NavigationFailedException {
		ViewSwitcher.changeView(ViewSelect.REPORT_VIEW, user);
	}
	
	/**
	 * Opens the settings window.
	 * @param user - The {@link User} that just logged in.
	 * @throws NavigationFailedException if the navigation fails.
	 */
	private void openSettingsMenu(User user) throws NavigationFailedException {
		ViewSwitcher.changeView(ViewSelect.SETTINGS_VIEW, user);
	}
}

