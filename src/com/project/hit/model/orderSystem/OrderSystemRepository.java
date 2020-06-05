package com.project.hit.model.orderSystem;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface OrderSystemRepository {

    public void createOrder(Order order) throws Exception;

    public void deleteOrder(Order order)throws Exception;

    public OrderUpdate updateOrder(int orderNumber) throws OrderNotFoundExcption;

    public Order findOrder(int orderNumber) throws OrderNotFoundExcption;

    public Order findOrder(String orderName) throws OrderNotFoundExcption;

    public void createPdf(Order order, String Url) throws FileNotFoundException, IOException, DocumentException;

    public Set<Order> getOrders();
}
