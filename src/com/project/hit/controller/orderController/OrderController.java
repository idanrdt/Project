package com.project.hit.controller.orderController;

import java.io.IOException;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderExistException;
import com.project.hit.model.orderSystem.OrderNotFoundExcption;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public interface OrderController {
	
	public void createOrder(Order order) throws ClassNotFoundException, IOException, SupplierNotFoundException, OrderExistException;
	
	public void editOrder(String orderNum, String[] updateList) throws NumberFormatException, IOException, OrderNotFoundExcption, ClassNotFoundException;
		
	public Order searchOrderByNumber(int number) throws OrderNotFoundExcption;
	
	public Order searchOrderByName(String name) throws OrderNotFoundExcption;
	
	public void deleteOrder(Order order) throws Exception;
	
	public void createOrderPDF(Order order, String location) throws IOException, DocumentException;
	
	public Set<Order> getOrders();
}
