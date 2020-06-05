package com.project.hit.model.orderSystem;

import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.hit.fileManager.*;
import com.project.hit.model.supplierSystem.*;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class OrderSystem implements OrderSystemRepository {

    private Set<Order> orders;
    private FileManger<Order> orderFileManger;
    static OrderSystem orderSystem;

    private OrderSystem() throws IOException, ClassNotFoundException, EnumNameNotFoundException {
        this.orderFileManger = new FileManger<>();
        this.orders = orderFileManger.loadFromFile(FileNameSelect.ORDERFILE);
    }

    public static OrderSystem getOrderSystem() throws EnumNameNotFoundException, IOException, ClassNotFoundException {
        if (orderSystem == null)
            orderSystem = new OrderSystem();
        return orderSystem;
    }

    /**
     * the function add a new order to a Set collection and automatic save
     * and update the supplier total expenses
     * @param order
     * @throws Exception if there's a problem with the order object
     */
    @Override
    public void createOrder(Order order) throws Exception {
        if (order == null) {
            throw new Exception("Order cannot be NULL");
        }
        if (this.orders.contains(order)) {
            throw new Exception("Order number: " +order.getOrderNumber() +" Already exists!");
        }
        //***update supplier and save***//
        double price = order.getPrice();

        MangeSupplier mangeSupplier = MangeSupplier.getMangeSupplierSinglton();
        for (Supplier supplier : mangeSupplier.getSuppliers()){
            if(supplier.getSupplierId() == order.getSupplier().getSupplierId())
                mangeSupplier.updater(supplier.getSupplierId()).totalExpenses(price).update();
        }

        this.orders.add(order);
        this.orderFileManger.saveToFile(this.orders,FileNameSelect.ORDERFILE);

    }

    /**
     * the function is a Updater pattern design (like a Builder pattern)
     * @param orderNumber
     * @return OrderUpdate class
     * @throws OrderNotFoundExcption if the order does not exist
     */
    @Override
    public OrderUpdate updateOrder(int orderNumber) throws OrderNotFoundExcption {

        return new OrderUpdate(findOrder(orderNumber), this.orders);
    }

    /**
     * the function delete order from the list and update the supplier total expenses
     * @param order object
     * @return true if everything was successful
     * @throws OrderNotFoundExcption if the order does not exist
     * @throws IOException if cant save the Set on file
     * @throws EnumNameNotFoundException if Enum value does not exist
     */
    @Override
    public void deleteOrder(Order order) throws OrderNotFoundExcption, IOException, EnumNameNotFoundException, ClassNotFoundException, SupplierNotFoundException {

        if(this.orders.contains(order)) {
            this.orders.remove(order);

            double price = order.getPrice();
            MangeSupplier mangeSupplier = MangeSupplier.getMangeSupplierSinglton();
            for (Supplier supplier : mangeSupplier.getSuppliers()){
                if(supplier.getSupplierId() == order.getSupplier().getSupplierId())
                    mangeSupplier.updater(supplier.getSupplierId()).totalExpenses(-price).update();
            }

            this.orderFileManger.saveToFile(this.orders, FileNameSelect.ORDERFILE);
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

    /**
     * the function create receipt pdf file from the sent object
     * @param order
     * @param Url path to save the file
     * @throws FileNotFoundException if the order object does not exist
     */
    @Override
    public void createPdf(Order order, String Url) throws IOException, DocumentException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy\nHH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        Document document = new Document();
        Url = Url +"/" + order.getOrderNumber() +".pdf";
        PdfWriter.getInstance(document, new FileOutputStream(Url));
        document.open();

        String nowDate = sdf.format(new Date());
        String title = "Order number: " + order.getOrderNumber();
        String orderDate = "\nDate: " + sdf2.format(order.getDate());
        String supplier = "\n\nSupplier Details:" +
                "\nSupplier name: " + order.getSupplier().getCompanyName() +
                "\nSupplier ID: " + order.getSupplier().getSupplierId() +
                "\nSupplier Address: " + order.getSupplier().getSupplierAddress() +
                "\nSupplier Phone number: " + order.getSupplier().getSupplierPhoneNumber() +
                "\nSupplier Email Address: " + order.getSupplier().getSupplierEmailAddress();
        String price = "\nPrice: "+order.getPrice();
        String details = "Order description: " + order.getDetails();

        Font timeFont = new Font(Font.FontFamily.TIMES_ROMAN,11);
        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN,16);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN,12);

        Paragraph time = new Paragraph(nowDate,timeFont);
        document.add(time);

        Paragraph pdfTitle = new Paragraph(title,titleFont);
        pdfTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(pdfTitle);

        Paragraph pdfSubTitle = new Paragraph(details+orderDate,font);
        pdfSubTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(pdfSubTitle);

        Paragraph pdfRest = new Paragraph(price + supplier,font);
        document.add(pdfRest);

        document.close();
        File file = new File(Url);
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    @Override
    public Set<Order> getOrders() {
        return orders;
    }
}
