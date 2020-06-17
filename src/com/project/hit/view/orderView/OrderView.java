package com.project.hit.view.orderView;

import com.project.hit.controller.orderController.OrderController;
import com.project.hit.view.View;

public interface OrderView extends View {
	/**
	 * Sets the controller to this view.
	 * @param controller related to this view.
	 */
	public void setController(OrderController controller);
}
