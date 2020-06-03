package com.project.hit.Supplier;

public class SupplierBuilder {

    private String companyName;
    private String supplierNumber;
    private String supplierAddress;
    private String supplierPhoneNumber;
    private String supplierEmailAddress;
    private boolean isDisable;
    private BankAccount bankAccount;


    /**
     *
     * @param companyName string of company name
     * @return
     */
    public SupplierBuilder CompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     *
     * @param supplierNumber
     * @return
     */
    public SupplierBuilder SupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
        return this;
    }

    /**
     *
     * @param supplierAddress
     * @return
     */
    public SupplierBuilder SupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
        return this;
    }

    /**
     *
     * @param supplierPhoneNumber
     * @return
     */
    public SupplierBuilder SupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
        return this;
    }

    /**
     *
     * @param supplierEmailAddress
     * @return
     */
    public SupplierBuilder SupplierEmailAddress(String supplierEmailAddress) {
        this.supplierEmailAddress = supplierEmailAddress;
        return this;
    }


    /**
     *
     * @param disable
     * @return
     */
    public SupplierBuilder Disable(boolean disable) {
        isDisable = disable;
        return this;
    }

    /**
     *
     * @param bankAccount
     * @return
     */
    public SupplierBuilder BankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    /**
     * Constructor
     * @return obj of supplier
     */
    public Supplier build(){
        Supplier supplier = new Supplier();
        supplier.setCompanyName(this.companyName);
        supplier.setSupplierNumber(this.supplierNumber);
        supplier.setSupplierAddress(this.supplierAddress);
        supplier.setSupplierPhoneNumber(this.supplierPhoneNumber);
        supplier.setSupplierEmailAddress(this.supplierEmailAddress);
        supplier.setDisable(this.isDisable);
        supplier.setBankAccount(this.bankAccount);
        return supplier;
    }
}
