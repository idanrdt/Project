package com.project.hit.Tests;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierExistsException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

import org.junit.jupiter.api.*;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MangeSupplierTest {

    private MangeSupplier mangeSupplier;
    private static Supplier supplier;
    private static int supplierid;

    @BeforeEach
    void setUp() {
        try {
            mangeSupplier = MangeSupplier.getMangeSupplierSinglton();
        } catch (EnumNameNotFoundException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void getMangeSupplierSingleton() {
        MangeSupplier mangeSupplierTestSingleton = assertDoesNotThrow(MangeSupplier::getMangeSupplierSinglton);
        assertEquals(mangeSupplier,mangeSupplierTestSingleton,"The object are not equals");
    }

    @Test
    @Order(2)
    void addSupplier() {
        supplier=Supplier.builder().CompanyName("test").SupplierNumber("test").build();
        supplierid = supplier.getSupplierId();
        assertDoesNotThrow(() -> mangeSupplier.addSupplier(supplier));
        assertThrows(SupplierExistsException.class,()->mangeSupplier.addSupplier(supplier));

    }

    @Test
    @Order(3)
    void findSupplierByNumber() {
        assertSame(Supplier.class,assertDoesNotThrow(() -> mangeSupplier.findSupplier(supplierid)).getClass());
        assertThrows(SupplierNotFoundException.class,()->mangeSupplier.findSupplier(404));
    }

    @Test
    @Order(4)
    void FindSupplierByName() {
        assertSame(Supplier.class,assertDoesNotThrow(() -> mangeSupplier.findSupplier("test")).getClass());
        assertThrows(SupplierNotFoundException.class,()->mangeSupplier.findSupplier("not exists"));
    }

    @Test
    @Order(5)
    void updater() {
        assertSame(Supplier.class,assertDoesNotThrow(() -> mangeSupplier.updater(supplierid).disable(false).update()).getClass());
        assertThrows(SupplierNotFoundException.class,()->mangeSupplier.updater(404).disable(false).update());
    }

    @Test
    @Order(7)
    void removeSupplier() {

        assertDoesNotThrow(() -> mangeSupplier.removeSupplier(supplier));
        assertThrows(SupplierNotFoundException.class,() -> mangeSupplier.removeSupplier(supplier));
    }
}