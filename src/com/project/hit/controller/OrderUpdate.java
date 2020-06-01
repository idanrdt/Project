package com.project.hit.controller;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;
import com.project.hit.model.Order;

import java.io.IOException;
import java.util.Set;

public class OrderUpdate {

    private Order order;
    private Set<Order> orders;
    private double oldPrice;

    public OrderUpdate(Order order, Set<Order> orders) {
        this.orders = orders;
        this.order = order;
    }

    public OrderUpdate price(double price){
        this.oldPrice = order.getPrice();
        order.setPrice(price);
        return this;
    }

    public OrderUpdate details(String details){
        order.setDetails(details);
        return this;
    }

    public Order update() throws IOException, EnumNameNotFoundException {
        FileManger<Order> save = new FileManger<>();

        /*update Supplier set*/

        save.saveToFile(this.orders, FileNameSelect.ORDERFILE);
        return this.order;
    }
}
