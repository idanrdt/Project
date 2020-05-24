package com.project.hit.view;

import com.project.hit.controller.LoginController;

public interface LoginView {
	
	void start();
	
	void close();
	
	void setController(LoginController controller);
}
