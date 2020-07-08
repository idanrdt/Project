package com.project.hit.controller.orderController;

import java.io.IOException;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderExistException;
import com.project.hit.model.orderSystem.OrderNotFoundExcption;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public interface OrderController {
	
	/**
	 * Creates new {@link Order} and save it to the DateBase.
	 * @param order - The {@link Order} to save.
	 * @throws ClassNotFoundException If the {@link Order} creation fails.
	 * @throws IOException If the {@link Order} fails to saved in the DataBase.
	 * @throws SupplierNotFoundException If the {@link Supplier} not found.
	 * @throws OrderExistException If the {@link Order} already exist.
	 */
	public void createOrder(Order order) throws ClassNotFoundException, IOException, SupplierNotFoundException, OrderExistException;
	
	/**
	 * Edit the requested {@link order}.
	 * @param orderNum - The {@link Order} number.
	 * @param updateList - The {@link String} {@link Array} that contain updates.
	 * <li>[0] - The {@link Order} price.
	 * <li> [1] - The {@link Order} description.
	 * @throws NumberFormatException If the price is not a number.
	 * @throws IOException If the {@link Order} fails to save in the DataBase.
	 * @throws OrderNotFoundExcption If the {@link Order} not found. 
	 * @throws ClassNotFoundException If the {@link Order} fails to save.
	 */
	public void editOrder(String orderNum, String[] updateList) throws NumberFormatException, IOException, OrderNotFoundExcption, ClassNotFoundException;
		
	/**
	 * Search the request {@link Order} by number in the DataBase.
	 * @param number - The {@link Order} number.
	 * @return The request {@link Order} that's been found.
	 * @throws OrderNotFoundExcption If the {@link Order} not found.
	 */
	public Order searchOrderByNumber(int number) throws OrderNotFoundExcption;
	
	/**
	 * Search the request {@link Order} by name in the DateBase.
	 * @param name - The {@link Order} name.
	 * @return The requested {@link Order} that's been found.
	 * @throws OrderNotFoundExcption If the {@link Order} not found.
	 */
	public Order searchOrderByName(String name) throws OrderNotFoundExcption;
	
	/**
	 * Delete the requested {@link Order} from the DateBase.
	 * @param order - the {@link Order} to delete.
	 * @throws ClassNotFoundException If the {@link Order} fails to save.
	 * @throws OrderNotFoundExcption If the {@link Order} not found.
	 * @throws IOException If the {@link Order} fails to save in the DataBase.
	 * @throws SupplierNotFoundException If the {@link Supplier} not found.
	 */
	public void deleteOrder(Order order) throws ClassNotFoundException, OrderNotFoundExcption, IOException, SupplierNotFoundException;
	
	/**
	 * Export the requested {@link Order} to PDF.
	 * @param order - The {@link Order} to export.
	 * @param location - The save path.
	 * @throws IOException If the PDF fails to save.
	 * @throws DocumentException - If PDF creation fails.
	 */
	public void createOrderPDF(Order order, String location) throws IOException, DocumentException;
	
	/**
	 * Gets the {@link Order} list to the DataBase.
	 * @return {@link Set} of {@link Order}.
	 */
	public Set<Order> getOrders();
}
