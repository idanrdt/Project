package com.project.hit.controller.orderController;

import java.io.IOException;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderExistException;
import com.project.hit.model.orderSystem.OrderNotFoundExcption;
import com.project.hit.model.orderSystem.OrderSystemRepository;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public class OrderPageController implements OrderController{
	
	private OrderSystemRepository model;
	
	public OrderPageController(OrderSystemRepository model) {
		this.model = model;
	}
	
	@Override
	public void createOrder(Order order) throws ClassNotFoundException, IOException, SupplierNotFoundException, OrderExistException {
		try {
			model.createOrder(order);
		}
		catch (EnumNameNotFoundException | ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}
	}

	@Override
	public void editOrder(String orderNumber, String[] updateList) throws NumberFormatException, IOException, OrderNotFoundExcption, ClassNotFoundException {
		try {
			model.updateOrder(Integer.parseInt(orderNumber)).details(updateList[1]).price(Integer.parseInt(updateList[0])).update();
		}
		catch (ClassNotFoundException | EnumNameNotFoundException e1) {
			throw new ClassNotFoundException();
		} catch (SupplierNotFoundException e1) {
			throw new OrderNotFoundExcption("Wrong Supplier");
		}
	}

	@Override
	public Order searchOrderByNumber(int number) throws OrderNotFoundExcption {
		return model.findOrder(number);
	}
	
	@Override
	public Order searchOrderByName(String name) throws OrderNotFoundExcption {
		return model.findOrder(name);
	}

	@Override
	public void deleteOrder(Order order) throws ClassNotFoundException, OrderNotFoundExcption, IOException, SupplierNotFoundException {
		try {
			model.deleteOrder(order);
		}
		catch (ClassNotFoundException | EnumNameNotFoundException e) {
			throw new ClassNotFoundException();
		}
	}
	
	@Override
	public void createOrderPDF(Order order, String location) throws IOException, DocumentException {
		model.createPdf(order, location);
	}

	@Override
	public Set<Order> getOrders() {
		return model.getOrders();
	}
}
