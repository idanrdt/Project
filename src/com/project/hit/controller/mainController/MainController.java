package com.project.hit.controller.mainController;

import com.project.hit.model.managerSystem.details.User;
import com.project.hit.viewSwitcher.ViewSelect;

public interface MainController {
	
	/**
	 * Navigate to a different view.
	 * @param select - The requested window to display.
	 * @param user - {@link User} Object that logged in.
	 * @throws NavigationFailedException if the navigation fails.
	 */
	public void navigateTo(ViewSelect select, User user) throws NavigationFailedException;
}
