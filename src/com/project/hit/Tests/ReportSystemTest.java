package com.project.hit.Tests;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderNotFoundExcption;
import com.project.hit.model.orderSystem.OrderSystem;
import com.project.hit.model.reportSystem.Report;
import com.project.hit.model.reportSystem.ReportEmptyExcption;
import com.project.hit.model.reportSystem.ReportSystem;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierExistsException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReportSystemTest {

    private OrderSystem orderSystem;
    private Order order,order1,order2;
    private Supplier supplier;
    private MangeSupplier mangeSupplier;
    ReportSystem reportSystem;

    @BeforeEach
    void setUp() throws Exception {

        supplier = Supplier.builder().CompanyName("test").SupplierNumber("test").build();
        order = new Order(supplier,500,"test");
        order1 = new Order(supplier,300,"test1");
        order2 = new Order(supplier,100,"test2");

        order1.setDate(LocalDate.of(2020,1,1));
        order2.setDate(LocalDate.of(2020,5,1));

        mangeSupplier =  MangeSupplier.getMangeSupplierSinglton();
        orderSystem = OrderSystem.getOrderSystem();

        mangeSupplier.addSupplier(supplier);

        orderSystem.createOrder(order);
        orderSystem.createOrder(order1);
        orderSystem.createOrder(order2);

        reportSystem = new ReportSystem();
    }

    @Test
    void genarateReportGeneral()  {

         assertSame(new HashSet<Order>().getClass(), assertDoesNotThrow(()->reportSystem.genarateReport().createReport()).getClass());

         assertEquals(reportSystem.getReport(),orderSystem.getOrders());
         
         assertTrue(reportSystem.getReport().contains(order));
    }

    @Test
    void genarateReportBySupplier()  {

        assertSame(new HashSet<Order>().getClass(), assertDoesNotThrow(()->reportSystem.genarateReport().supplierId(supplier.getSupplierId()).createReport()).getClass());

        assertTrue(reportSystem.getReport().contains(order));

        assertThrows(ReportEmptyExcption.class,()->reportSystem.genarateReport().supplierId(123456).createReport());
    }

    @Test
    void genarateReportByDate() throws Exception {

        assertDoesNotThrow(()->reportSystem.genarateReport().startDate(1,5,2020).createReport());

        assertFalse(reportSystem.getReport().contains(order1));

        assertDoesNotThrow(()->reportSystem.genarateReport().startDate(1,0,2020).createReport());

        assertTrue(reportSystem.getReport().contains(order1));
        assertTrue(reportSystem.getReport().contains(order2));
        assertTrue(reportSystem.getReport().contains(order));

        assertDoesNotThrow(()->reportSystem.genarateReport().endDate(1,2,2020).createReport());
        assertTrue(reportSystem.getReport().contains(order1));
        assertFalse(reportSystem.getReport().contains(order2));
        assertFalse(reportSystem.getReport().contains(order));

        assertDoesNotThrow(()->reportSystem.genarateReport().endDate(2,6,2020).createReport());
        assertTrue(reportSystem.getReport().contains(order1));
        assertTrue(reportSystem.getReport().contains(order2));
        assertFalse(reportSystem.getReport().contains(order));

    }

    @AfterEach
    void tearDown() throws EnumNameNotFoundException, IOException, SupplierNotFoundException, ClassNotFoundException, OrderNotFoundExcption {
        mangeSupplier.removeSupplier(supplier);
        orderSystem.deleteOrder(order);
        orderSystem.deleteOrder(order1);
        orderSystem.deleteOrder(order2);
    }
}