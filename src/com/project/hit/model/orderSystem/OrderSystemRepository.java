package com.project.hit.model.orderSystem;

import com.itextpdf.text.DocumentException;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface OrderSystemRepository {

    public void createOrder(Order order) throws IOException, EnumNameNotFoundException, SupplierNotFoundException, ClassNotFoundException, OrderExistException;

    public void deleteOrder(Order order) throws OrderNotFoundExcption, IOException, EnumNameNotFoundException, ClassNotFoundException, SupplierNotFoundException;

    public OrderUpdate updateOrder(int orderNumber) throws OrderNotFoundExcption;

    public Order findOrder(int orderNumber) throws OrderNotFoundExcption;

    public Order findOrder(String orderName) throws OrderNotFoundExcption;

    public void createPdf(Order order, String Url) throws IOException, DocumentException;

    public Set<Order> getOrders();
}
