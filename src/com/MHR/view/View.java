package com.MHR.view;

import com.MHR.controller.Controller;

public interface View {
	
	void start();
	
	void close();
	
	void setController(Controller controller);
}
