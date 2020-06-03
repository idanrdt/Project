package com.project.hit.main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.project.hit.controller.mainController.NavigationFailedException;
import com.project.hit.details.User;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;
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