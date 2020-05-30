package com.project.hit.controller;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;
import com.project.hit.model.Order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class OrderSystem implements OrderSystemRepository {

    private Set<Order> orders;
    private FileManger<Order> orderFileManger;

    /**
     * OrderSystem constructor
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws EnumNameNotFoundException
     */
    public OrderSystem() throws IOException, ClassNotFoundException, EnumNameNotFoundException {
        this.orderFileManger = new FileManger<>();
        this.orders = orderFileManger.loadFromFile(FileNameSelect.ORDERFILE);
    }

    /**
     * the function add a new order to a Set collection and automatic save
     * and update the supplier total expenses
     * @param order
     * @return true if everything was successful
     * @throws Exception if there's a problem with the order object
     */
    @Override
    public boolean createOrder(Order order) throws Exception {
        if (order == null) {
            throw new Exception("Order cannot be NULL");
        }
        if (this.orders.contains(order)) {
            throw new Exception("Order number: " +order.getOrderNumber() +" Already exists!");
        }
        //***update supplier and save***//

        this.orders.add(order);
        this.orderFileManger.saveToFile(this.orders,FileNameSelect.ORDERFILE);
        return true;
    }

    /**
     * the function is a Updater pattern design (like a Builder pattern)
     * @param orderNumber
     * @return OrderUpdate class
     * @throws OrderNotFoundExcption
     */
    @Override
    public OrderUpdate updateOrder(int orderNumber) throws OrderNotFoundExcption {

        return new OrderUpdate(findOrder(orderNumber), this.orders);
    }

    /**
     * the function delete order from the list and update the supplier total expenses
     * @param order object
     * @return true if everything was successful
     * @throws OrderNotFoundExcption
     * @throws IOException
     * @throws EnumNameNotFoundException
     */
    @Override
    public boolean deleteOrder(Order order) throws OrderNotFoundExcption, IOException, EnumNameNotFoundException {

        if(this.orders.contains(order)) {
            this.orders.remove(order);

            //***update supplier and save***//

            this.orderFileManger.saveToFile(this.orders, FileNameSelect.ORDERFILE);
            return true;
        }
        throw new OrderNotFoundExcption("the order number: " + order.getOrderNumber() + " does not exist");
    }

    /**
     * find order function by order number
     * @param orderNumber
     * @return order object if exists
     * @throws OrderNotFoundExcption if the order does not exist
     */
    @Override
    public Order findOrder(int orderNumber) throws OrderNotFoundExcption{
        for (Order i: this.orders) {
            if (i.getOrderNumber() == orderNumber)
                return i;
        }
        throw new OrderNotFoundExcption("the order number: " + orderNumber + " does not exist");
    }

    /**
     * find order function by order name
     * @param orderName
     * @return order object if exists
     * @throws OrderNotFoundExcption if the order does not exist
     */
    @Override
    public Order findOrder(String orderName) throws OrderNotFoundExcption {
        for (Order i: this.orders) {
            if (i.getSupplier().getCompanyName().equals(orderName))
                return i;
        }
        throw new OrderNotFoundExcption("the order: " + orderName + " does not exist");
    }

    @Override
    public void createPdf(Order order, String Url) throws FileNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        PdfDocument pdf = new PdfDocument(new PdfWriter(Url + order.getOrderNumber() + ".pdf"));
        Document document = new Document(pdf);
        String nowDate = sdf.format(new Date());
        String title = "\t\tOrder number" + order.getOrderNumber();
        String orderDate = "\t\tDate: " + sdf.format(order.getDate());
        String supplier = "\n\tSupplier Details" +
                "\nSupplier name: " + order.getSupplier().getCompanyName() +
                "\nSupplier ID: " + order.getSupplier().getSupplierId() +
                "\nSupplier Address: " + order.getSupplier().getSupplierAddress() +
                "\nSupplier Phone number: " + order.getSupplier().getSupplierPhoneNumber() +
                "\nSupplier Email Address: " + order.getSupplier().getSupplierEmailNumber();
        String price = "\nPrice: "+order.getPrice();
        String details = "\nOrder description:\n" + order.getDetails();
        String line = nowDate +title+ orderDate + supplier + price + details;
        document.add(new Paragraph(line));
        document.close();
    }

    @Override
    public Set<Order> getOrders() {
        return orders;
    }
}
