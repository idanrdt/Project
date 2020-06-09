package com.project.hit.Tests;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderNotFoundExcption;
import com.project.hit.model.orderSystem.OrderSystem;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierExistsException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderSystemTest {

    private OrderSystem orderSystem;
    private static Order order;
    private static Supplier  supplier;
    private static int orderId;
    private MangeSupplier mangeSupplier;

    @BeforeEach
    void getOrderSystem() throws EnumNameNotFoundException, IOException, ClassNotFoundException, SupplierExistsException {
        mangeSupplier =  MangeSupplier.getMangeSupplierSinglton();
        orderSystem = OrderSystem.getOrderSystem();
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void createOrder() throws Exception {
        supplier = Supplier.builder().CompanyName("test").SupplierNumber("test").build();
        mangeSupplier.addSupplier(supplier);
        order = new Order(supplier,500,"test");
        orderId = order.getOrderNumber();

        assertDoesNotThrow(()->orderSystem.createOrder(order));
        assertThrows(Exception.class, ()->orderSystem.createOrder(order));
        assertThrows(Exception.class, ()->orderSystem.createOrder(null));
        try {
            assertEquals(500,mangeSupplier.findSupplier(orderId).getTotalExpenses());
        } catch (SupplierNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Test
    @org.junit.jupiter.api.Order(7)
    void deleteOrder() {
        assertDoesNotThrow(()->orderSystem.deleteOrder(order));
        assertThrows(OrderNotFoundExcption.class, ()->orderSystem.deleteOrder(order));
        try {
            assertEquals(0,mangeSupplier.findSupplier("test").getTotalExpenses());
        } catch (SupplierNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void updateOrder() {
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void findOrderByNumber() {
        assertDoesNotThrow(()->orderSystem.findOrder(orderId));

    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void testFindOrder() {
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    void createPdf() {
    }

    @AfterAll
    static void afterAll() throws EnumNameNotFoundException, IOException, ClassNotFoundException, SupplierNotFoundException {
        MangeSupplier.getMangeSupplierSinglton().removeSupplier(supplier);
    }
}