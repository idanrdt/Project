package com.project.hit.Tests;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierExistsException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class MangeSupplierTest {

    private MangeSupplier mangeSupplier;
    private Supplier supplier;

    @BeforeEach
    void setUp() {
        supplier = Supplier.builder().CompanyName("test").SupplierNumber("test").build();
        try {
            mangeSupplier = MangeSupplier.getMangeSupplierSinglton();
        } catch (EnumNameNotFoundException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMangeSupplierSingleton() {
        MangeSupplier mangeSupplierTestSingleton = assertDoesNotThrow(MangeSupplier::getMangeSupplierSinglton);
        assertEquals(mangeSupplier,mangeSupplierTestSingleton,"The object are not equals");
    }

    @Test
    void addSupplier() {
        assertDoesNotThrow(() -> mangeSupplier.addSupplier(this.supplier));
        assertThrows(SupplierExistsException.class,()->mangeSupplier.addSupplier(supplier));

    }

    @Test
    void findSupplierByNumber() {
        assertSame(Supplier.class,assertDoesNotThrow(() -> mangeSupplier.findSupplier(1004)).getClass());
        assertThrows(SupplierNotFoundException.class,()->mangeSupplier.findSupplier(404));
    }

    @Test
    void FindSupplierByName() {
        assertSame(Supplier.class,assertDoesNotThrow(() -> mangeSupplier.findSupplier("test")).getClass());
        assertThrows(SupplierNotFoundException.class,()->mangeSupplier.findSupplier("not exists"));
    }

    @Test
    void updater() {
        assertSame(Supplier.class,assertDoesNotThrow(() -> mangeSupplier.updater(1004).disable(false).update()).getClass());
        assertThrows(SupplierNotFoundException.class,()->mangeSupplier.updater(404).disable(false).update());
    }

    @Test
    void removeSupplier() {

        assertDoesNotThrow(() -> mangeSupplier.removeSupplier(supplier));
        assertThrows(SupplierNotFoundException.class,() -> mangeSupplier.removeSupplier(supplier));
    }

}