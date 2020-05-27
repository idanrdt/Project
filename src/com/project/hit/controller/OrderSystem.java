package com.project.hit.controller;

import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;
import com.project.hit.model.Order;

import java.io.IOException;
import java.util.Set;

public class OrderSystem implements OrderSystemRepository {

    private Set<Order> orders;
    private FileManger<Order> orderFileManger;

    public OrderSystem() throws IOException, ClassNotFoundException {
        this.orderFileManger = new FileManger<>();
        this.orders = orderFileManger.loadFromFile(FileNameSelect.ORDERFILE);
    }

    @Override
    public boolean createOrder(Order order) throws Exception {
        if (order == null) {
            throw new Exception("must have a value");
        }
        if (this.orders.contains(order)) {
            throw new Exception("Already exists!");
        }

        //***update supplier and save***//
        this.orders.add(order);
        this.orderFileManger.saveToFile(this.orders,FileNameSelect.ORDERFILE);
        return true;
    }

    @Override
    public Order updateOrder(int orderNumber) throws Exception {

        return null;

    }

    @Override
    public boolean deleteOrder(Order order) throws Exception {
        this.orders.remove(order);
        //***update supplier and save***//

        this.orderFileManger.saveToFile(this.orders,FileNameSelect.ORDERFILE);
        return true;
    }

    @Override
    public Order findOrder(int orderNumber) {
        for (Order i: this.orders) {
            if (i.getOrderNumber() == orderNumber)
                return i;
        }
        return null;
    }

    @Override
    public Order findOrder(String orderName) {
        for (Order i: this.orders) {
            if (i.getSupplier().getCompanyName().equals(orderName))
                return i;
        }
        return null;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
