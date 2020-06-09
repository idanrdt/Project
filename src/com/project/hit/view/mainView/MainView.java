package com.project.hit.view.mainView;

import com.project.hit.controller.mainController.MainController;
import com.project.hit.view.View;

public interface MainView extends View {
	
	/**
	 * Sets the controller to this view.
	 * @param controller related to this view.
	 */
	public void setController(MainController controller);
}
