package com.project.hit.view.supplierView;

import com.project.hit.controller.supplierController.SupplierController;
import com.project.hit.view.View;

public interface SupplierView extends View {
	
	/**
	 * Sets the controller to this view.
	 * @param controller related to this view.
	 */
	public void setController(SupplierController controller);
}
