package com.project.hit.Tests;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderNotFoundExcption;
import com.project.hit.model.orderSystem.OrderSystem;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierExistsException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderSystemTest {

    private OrderSystem orderSystem;
    private Order order;
    private MangeSupplier mangeSupplier;
    private Supplier supplier;



    @BeforeEach
    void setUp() {
        supplier = Supplier.builder().CompanyName("test").SupplierNumber("test").build();
        order = new Order(supplier,500,"new order");
        try {
           mangeSupplier =  MangeSupplier.getMangeSupplierSinglton();
           mangeSupplier.addSupplier(supplier);

           orderSystem = OrderSystem.getOrderSystem();

        } catch (EnumNameNotFoundException | IOException | ClassNotFoundException  e) {
            e.printStackTrace();
        }catch (SupplierExistsException e){
            try {
                mangeSupplier.removeSupplier(supplier);
                setUp();
            } catch (IOException | EnumNameNotFoundException | SupplierNotFoundException ex) {
                ex.printStackTrace();
            }
            e.getMessage();
        }
    }


    @Test
    @Before
    void createOrder() {
        assertDoesNotThrow(()->orderSystem.createOrder(order));
        assertThrows(Exception.class, ()->orderSystem.createOrder(order));
        assertThrows(Exception.class, ()->orderSystem.createOrder(null));

        try {
            assertEquals(500,mangeSupplier.findSupplier("test").getTotalExpenses());
        } catch (SupplierNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateOrder() {
    }

    @Test
    void findOrder() {
    }

    @Test
    void testFindOrder() {
    }

    @Test
    void createPdf() {
    }

    @Test
    void deleteOrder() {
        order.setOrderNumber(1000);
        assertDoesNotThrow(()->orderSystem.deleteOrder(order));
        assertThrows(OrderNotFoundExcption.class, ()->orderSystem.deleteOrder(order));

        try {
            assertEquals(0,mangeSupplier.findSupplier("test").getTotalExpenses());
        } catch (SupplierNotFoundException e) {
            e.printStackTrace();
        }

    }
}