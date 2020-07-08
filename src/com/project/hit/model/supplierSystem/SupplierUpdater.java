package com.project.hit.model.supplierSystem;

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

    /**
     * Updates the company name.
     * @param companyName - The {@link Supplier} Company name.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater companyName(String companyName) {
        this.supplier.setCompanyName(companyName);
        return this;
    }


    /**
     * Updates the {@link Supplier} number.
     * @param supplierNumber - the {@link Supplier} number.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater supplierNumber(String supplierNumber) {
        this.supplier.setSupplierNumber(supplierNumber);
        return this;
    }


    /**
     * Updates the {@link Supplier} address.
     * @param supplierAddress - the {@link Supplier} address.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater supplierAddress(String supplierAddress) {
        this.supplier.setSupplierAddress(supplierAddress);
        return this;
    }

    /**
     * Updates the {@link Supplier} phone number.
     * @param supplierPhoneNumber - The {@link Supplier} phone number.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater supplierPhoneNumber(String supplierPhoneNumber) {
        this.supplier.setSupplierPhoneNumber(supplierPhoneNumber);
        return this;
    }

    /**
     * Updates the {@link Supplier} email address.
     * @param supplierEmailAddress - the {@link Supplier} email address.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater supplierEmailAddress(String supplierEmailAddress) {
        this.supplier.setSupplierEmailAddress(supplierEmailAddress);
        return this;
    }

    /**
      * Updates the {@link Supplier} total expenses.
     * @param totalExpenses - the {@link Supplier} total expenses.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater totalExpenses(double totalExpenses) {
        this.supplier.setTotalExpenses(totalExpenses);
        return this;
    }


    /**
     * Enable or disable the {@link Supplier}
     * @param disable parameter to enable or disable the {@link Supplier}.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater disable(boolean disable) {
        this.supplier.setDisable(disable);
        return this;
    }

    /**
     * Updates the {@link SUpplier} {@link BankAccount}.
     * @param bankAccount - the {@link BankAccount} of the {@link Supplier}.
     * @return {@link SupplierUpdater}.
     */
    public SupplierUpdater bankAccount(BankAccount bankAccount) {
        this.supplier.setBankAccount(bankAccount);
        return this;
    }

    /**
     * Update and save the saves to the Database.
     * @throws IOException if the file can't open.
     * @throws EnumNameNotFoundException if the enum param that not exists.
     */
    public Supplier update() throws IOException, EnumNameNotFoundException {
        FileManger<Supplier> save = new FileManger<>();

        save.saveToFile(this.suppliers, FileNameSelect.SUPPLIERFILE);
        return this.supplier;
    }
}
