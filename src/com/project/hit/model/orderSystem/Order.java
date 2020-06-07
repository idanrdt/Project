package com.project.hit.model.orderSystem;


import com.project.hit.model.supplierSystem.Supplier;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Supplier supplier;
    private String details;
    private double price;
    private Date date;
    private int orderNumber;

    public Order(Supplier supplier, double price, String details) {
        this.supplier = supplier;
        this.price = price;
        this.details = details;
        this.date = Calendar.getInstance().getTime();
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }
}
