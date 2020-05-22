package com.MHR.controller;

import com.MHR.model.*;
import com.MHR.view.*;

public class LoginPageController implements Controller {
	
	private View view;
	private Model model;
	
	public LoginPageController(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void loginButtonClicked(String username, char[] password) {
		if(((LoginPageModel)model).checkCredentials(username, password)) {
			view.close();
			openMainMenu();
		}
	}
	
	private void openMainMenu() {
		//TODO: open the main window;
	}

	@Override
	public void setError(String msg) {
		((LoginPageView)view).setLoginError(msg);
	}
}
