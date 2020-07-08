package com.project.hit.view.ReportView;

import com.project.hit.controller.reportController.ReportController;
import com.project.hit.view.View;

public interface ReportView extends View {
	
	/**
	 * Sets the controller to this view.
	 * @param controller related to this view.
	 */
	public void setController(ReportController controller);
}
