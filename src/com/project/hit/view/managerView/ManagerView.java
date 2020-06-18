package com.project.hit.view.managerView;

import com.project.hit.controller.managerController.ManagerController;
import com.project.hit.view.View;

public interface ManagerView extends View {
	
	/**
	 * Sets the controller to this view.
	 * @param controller related to this view.
	 */
	public void setController(ManagerController controller);
}
