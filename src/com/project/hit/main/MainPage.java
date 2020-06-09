package com.project.hit.main;

import com.project.hit.controller.mainController.NavigationFailedException;
import com.project.hit.viewSwitcher.ViewSelect;
import com.project.hit.viewSwitcher.ViewSwitcher;

public class MainPage {

	/**
	 * Launch the application - main function.
	 */
	public static void main(String[] args) {
		try {
			ViewSwitcher.changeView(ViewSelect.LOGIN_VIEW);
		}
		catch(NavigationFailedException n) {
			System.out.println(n.getMessage());
		}
	}
}