package com.project.hit.controller;

import com.project.hit.model.Order;

public interface OrderSystemRepository {

    public boolean createOrder(Order order) throws Exception;

    public Order updateOrder(int orderNumber)throws Exception;

    public boolean deleteOrder(Order order)throws Exception;

    public Order findOrder(int orderNumber);

    public Order findOrder(String orderName);
}
