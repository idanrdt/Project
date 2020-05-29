package com.project.hit.controller.orderController;

import com.project.hit.model.OrderSystem;
import com.project.hit.view.orderView.OrderView;

public class OrderPageController implements OrderController{
	
	private OrderView view;
	private OrderSystem model;
	public OrderPageController(OrderView view, OrderSystem model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void createOrder(/*Order order*/)/*throws OrderNotSavedException*/ {
		/*
		 * try {
		 *   model.createOrder(order)
		 * }
		 * catch(Exception e) {
		 *   throw new OrderNotFoundException();
		 * }  
		 */
	}

	@Override
	public void editOrder(/*Order order*/) /*throws OrderNotFoundException*/{
		/*
		 * model.editOrder(order);
		 */
	}

	@Override
	public void cancelOrder(/*String number, Date date, String supplier*/) /*throws OrderNotFoundException*/{
		/*
		 * model.deleteOrder(String number, Date date, String supplier);
		 */
	}

	@Override
	public void/*Order*/ searchOrder(/*String number, Date date, String supplier*/) /*throws OrderNotFoundException*/{
		/*
		 * return mode.searchOrder(number, date, supplier);
		 */
	}
}
