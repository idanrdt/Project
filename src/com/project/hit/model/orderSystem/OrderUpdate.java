package com.project.hit.model.orderSystem;



import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;
import com.project.hit.model.managerSystem.details.User;
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
    
    /**
     * Updates the {@link Order} price and update the {@link Order} {@link Supplier} total expenses.
     * @param price The {@link Order} price.
     * @return This {@link OrderUpdater} instance.
     * @throws EnumNameNotFoundException If the {@link Order} fails to save.
     * @throws IOException If the {@link Order} fails to save in the DateBase.
     * @throws ClassNotFoundException If the {@link Order} fail to save.
     * @throws SupplierNotFoundException If the {@link Supplier} not found.
     */
    public OrderUpdate price(double price) throws EnumNameNotFoundException, IOException, ClassNotFoundException, SupplierNotFoundException {
        this.oldPrice = order.getPrice();
        order.setPrice(price);

        MangeSupplier mangeSupplier = MangeSupplier.getMangeSupplierSinglton();
        for (Supplier supplier : mangeSupplier.getSuppliers()){
            if(supplier.getSupplierId() == order.getSupplier().getSupplierId())
                mangeSupplier.updater(supplier.getSupplierId()).totalExpenses(supplier.getTotalExpenses() + price- this.oldPrice).update();
        }
        return this;
    }
    
    /**
     * Updates the {@link Order} details.
     * @param details The {@link Order} details.
     * @return this {@link OrderUpdater} instance.
     */
    public OrderUpdate details(String details){
        order.setDetails(details);
        return this;
    }
    
    /**
     * Save the updated order to the DataBase.
     * @return The {@link Order} that saved.
     * @throws IOException If the {@link Order} fails to save in the DataBase.
     * @throws EnumNameNotFoundException If the {@link Order} fails to save.
     */
    public Order update() throws IOException, EnumNameNotFoundException {
        FileManger<Order> save = new FileManger<>();

        save.saveToFile(this.orders, FileNameSelect.ORDERFILE);
        return this.order;
    }
}
