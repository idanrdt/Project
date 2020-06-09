package com.project.hit.model.orderSystem;


import com.project.hit.model.supplierSystem.Supplier;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int ORDER_NUMBER_COUNT = 1000;
    private Supplier supplier;
    private String details;
    private double price;
    private Date date;
    private final int orderNumber;

    public Order(Supplier supplier, double price, String details) {
        this.supplier = supplier;
        this.price = price;
        this.details = details;
        this.date = Calendar.getInstance().getTime();

        if(ORDER_NUMBER_COUNT == 1000 && ((new File("ORDER_NUMBER_COUNT")).exists())){
            try(DataInputStream dis = new DataInputStream(new FileInputStream("ORDER_NUMBER_COUNT"))) {
                ORDER_NUMBER_COUNT = dis.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.orderNumber = ORDER_NUMBER_COUNT++;

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("ORDER_NUMBER_COUNT"))) {
            dos.write(ORDER_NUMBER_COUNT);
        } catch (IOException e) {
            e.printStackTrace();
        }


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

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
