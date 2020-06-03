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

    /**
     *function to update company name
     * @param companyName string of Company name
     * @return obj of Supplier
     */
    public SupplierUpdater companyName(String companyName) {
        this.supplier.setCompanyName(companyName);
        return this;
    }


    /**
     *function to update Supplier number
     * @param supplierNumber string of Supplier number
     * @return obj of Supplier
     */
    public SupplierUpdater supplierNumber(String supplierNumber) {
        this.supplier.setSupplierNumber(supplierNumber);
        return this;
    }


    /**
     *function to update Supplier address
     * @param supplierAddress string of Supplier name
     * @return obj of Supplier
     */
    public SupplierUpdater supplierAddress(String supplierAddress) {
        this.supplier.setSupplierAddress(supplierAddress);
        return this;
    }


    /**
     *function to update Supplier phone number
     * @param supplierPhoneNumber string of Supplier phone number
     * @return obj of Supplier
     */
    public SupplierUpdater supplierPhoneNumber(String supplierPhoneNumber) {
        this.supplier.setSupplierPhoneNumber(supplierPhoneNumber);
        return this;
    }


    /**
     *function to update Supplier email address
     * @param supplierEmailAddress string of Supplier email address
     * @return obj of Supplier
     */
    public SupplierUpdater supplierEmailAddress(String supplierEmailAddress) {
        this.supplier.setSupplierEmailAddress(supplierEmailAddress);
        return this;
    }


    /**
     *function to update total expenses
     * @param totalExpenses double of total expenses
     * @return obj of Supplier
     */
    public SupplierUpdater totalExpenses(double totalExpenses) {
        this.supplier.setTotalExpenses(totalExpenses);
        return this;
    }


    /**
     *function to update if this supplier is disable
     * @param disable boolean of disable
     * @return obj of Supplier
     */
    public SupplierUpdater disable(boolean disable) {
        this.supplier.setDisable(disable);
        return this;
    }


    /**
     *function to update bank account
     * @param bankAccount obj of BankAccount
     * @return obj of Supplier
     */
    public SupplierUpdater bankAccount(BankAccount bankAccount) {
        this.supplier.setBankAccount(bankAccount);
        return this;
    }


    /**
     *function to exit from the updater and save the changes
     * @throws IOException if the file can't open
     * @throws EnumNameNotFoundException if the enum param that not exists
     */
    public Supplier update() throws IOException, EnumNameNotFoundException {
        FileManger<Supplier> save = new FileManger<>();

        save.saveToFile(this.suppliers, FileNameSelect.SUPPLIERFILE);
        return this.supplier;
    }
}
