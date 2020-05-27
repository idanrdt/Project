package com.project.hit.model;

import java.util.Calendar;
import java.util.Objects;

public class Order {

    private static int orderNumberCount = 1000;
    private Supplier supplier;
    private double price;
    private Calendar date;
    private int orderNumber;

    public Order(Supplier supplier, double price, Calendar date) {
        this.supplier = supplier;
        this.price = price;
        this.date = date;
        orderNumber = ++orderNumber;
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.price, price) == 0 &&
                Objects.equals(supplier, order.supplier) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplier, price, date);
    }
}
