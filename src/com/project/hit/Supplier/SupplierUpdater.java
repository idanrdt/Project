package com.project.hit.Supplier;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;

import java.io.IOException;
import java.util.Set;

public class SupplierUpdater {

    private Supplier supplier;
    private Set<Supplier> suppliers;

    public SupplierUpdater(Supplier supplier, Set<Supplier> suppliers) {
        this.supplier = supplier;
        this.suppliers = suppliers;
    }

    public SupplierUpdater companyName(String companyName) {
        this.supplier.setCompanyName(companyName);
        return this;
    }

    public SupplierUpdater supplierNumber(String supplierNumber) {
        this.supplier.setSupplierNumber(supplierNumber);
        return this;
    }

    public SupplierUpdater supplierAddress(String supplierAddress) {
        this.supplier.setSupplierAddress(supplierAddress);
        return this;
    }

    public SupplierUpdater supplierPhoneNumber(String supplierPhoneNumber) {
        this.supplier.setSupplierPhoneNumber(supplierPhoneNumber);
        return this;
    }

    public SupplierUpdater supplierEmailAddress(String supplierEmailAddress) {
        this.supplier.setSupplierEmailAddress(supplierEmailAddress);
        return this;
    }

    public SupplierUpdater totalExpenses(double totalExpenses) {
        this.supplier.setTotalExpenses(totalExpenses);
        return this;
    }

    public SupplierUpdater disable(boolean disable) {
        this.supplier.setDisable(disable);
        return this;
    }

    public SupplierUpdater bankAccount(BankAccount bankAccount) {
        this.supplier.setBankAccount(bankAccount);
        return this;
    }

    public Supplier update() throws IOException, EnumNameNotFoundException {
        FileManger<Supplier> save = new FileManger<>();

        save.saveToFile(this.suppliers, FileNameSelect.SUPPLIERFILE);
        return this.supplier;
    }
}
