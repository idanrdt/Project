package com.project.hit.model.orderSystem;


import com.project.hit.model.supplierSystem.Supplier;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int ORDER_NUMBER_COUNT = 1000;
    private Supplier supplier;
    private String details;
    private double price;
    private LocalDate date;
    private final int orderNumber;
    
    /**
     * The {@link Order} constructor.
     * @param supplier - The {@link Supplier} related to the {@link Order}.
     * @param price - The {@link Order} price.
     * @param details - The {@link Order} details.
     */
    public Order(Supplier supplier, double price, String details) {
        this.supplier = supplier;
        this.price = price;
        this.details = details;
        this.date = LocalDate.now();

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

    /**
     * Gets the {@link Order} number.
     * @return The {@link Order} number.
     */
    public int getOrderNumber() {
        return orderNumber;
    }
    
    /**
     * Gets the {@link Order} {@link Supplier}.
     * @return The {@link Order} {@link Supplier}.
     */
    public Supplier getSupplier() {
        return supplier;
    }
    
    /**
     * Gets the {@link Order} price.
     * @return The {@link Order} price.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Sets the {@link Order} price.
     * @param price - The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Gets the {@link Order} date in {@link LocalDate} format.
     * @return The {@link Order} date in {@link LocalDate}.
     */
    public LocalDate getDate() {
        return date;
    }
    
    /**
     * Sets the {@link Order} date.
     * @param date The {@link Order} date in {@link LocalDate} format.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    /**
     * Gets the {@link Order} details.
     * @return The {@link Order} details
     */
    public String getDetails() {
        return details;
    }
    
    /**
     * Sets the {@link Order} details.
     * @param details The {@link Order} details.
     */
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
