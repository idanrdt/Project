package com.project.hit.model.orderSystem;



import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;
import com.project.hit.model.supplierSystem.*;

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

    public OrderUpdate price(double price) throws EnumNameNotFoundException, IOException, ClassNotFoundException, SupplierNotFoundException {
        this.oldPrice = order.getPrice();
        order.setPrice(price);

        MangeSupplier mangeSupplier = MangeSupplier.getMangeSupplierSinglton();
        for (Supplier supplier : mangeSupplier.getSuppliers()){
            if(supplier.getSupplierId() == order.getSupplier().getSupplierId())
                mangeSupplier.updater(supplier.getSupplierId()).totalExpenses(price- this.oldPrice).update();
        }
        return this;
    }

    public OrderUpdate details(String details){
        order.setDetails(details);
        return this;
    }

    public Order update() throws IOException, EnumNameNotFoundException {
        FileManger<Order> save = new FileManger<>();



        save.saveToFile(this.orders, FileNameSelect.ORDERFILE);
        return this.order;
    }
}
