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
     *Part of the builder that gets the company name
     * @param companyName string of company name
     * @return SupplierBuilder
     */
    public SupplierBuilder CompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     *Part of the builder that gets the supplier number
     * @param supplierNumber string of supplier number
     * @return SupplierBuilder
     */
    public SupplierBuilder SupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
        return this;
    }

    /**
     *Part of the builder that gets the supplier address
     * @param supplierAddress string of supplier address
     * @return SupplierBuilder
     */
    public SupplierBuilder SupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
        return this;
    }

    /**
     *Part of the builder that gets the supplier phone number
     * @param supplierPhoneNumber string of supplier phone number
     * @return SupplierBuilder
     */
    public SupplierBuilder SupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
        return this;
    }

    /**
     *Part of the builder that gets the supplier email address
     * @param supplierEmailAddress string of supplier email address
     * @return SupplierBuilder
     */
    public SupplierBuilder SupplierEmailAddress(String supplierEmailAddress) {
        this.supplierEmailAddress = supplierEmailAddress;
        return this;
    }


    /**
     *Part of the builder that said if it disable
     * @param disable boolean if this disable
     * @return SupplierBuilder
     */
    public SupplierBuilder Disable(boolean disable) {
        isDisable = disable;
        return this;
    }

    /**
     *Part of the builder that gets the bank account
     * @param bankAccount obj of Bank Account
     * @return SupplierBuilder
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
