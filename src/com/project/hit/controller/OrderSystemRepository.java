package com.project.hit.controller;

import com.project.hit.model.Order;

import java.io.FileNotFoundException;
import java.util.Set;

public interface OrderSystemRepository {

    public void createOrder(Order order) throws Exception;

    public void deleteOrder(Order order)throws Exception;

    public OrderUpdate updateOrder(int orderNumber) throws OrderNotFoundExcption;

    public Order findOrder(int orderNumber) throws OrderNotFoundExcption;

    public Order findOrder(String orderName) throws OrderNotFoundExcption;

    public void createPdf(Order order, String Url) throws FileNotFoundException;

    public Set<Order> getOrders();
}
