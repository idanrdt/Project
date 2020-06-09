package com.project.hit.model.supplierSystem;

public class SupplierBuilder {

    private String companyName;
    private String supplierNumber;
    private String supplierAddress;
    private String supplierPhoneNumber;
    private String supplierEmailAddress;
    private boolean isDisable;
    private BankAccount bankAccount;


    /**
     * Part of the builder that sets the company name.
     * @param companyName  - The company name.
     * @return {@link SupplierBuilder}.
     */
    public SupplierBuilder CompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * Part of the builder that sets the supplier number.
     * @param supplierNumber - The supplier number.
     * @return {@link SupplierBuilder}.
     */
    public SupplierBuilder SupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
        return this;
    }

    /**
     * Part of the builder that sets the supplier address.
     * @param supplierAddress - The supplier address
     * @return {@link SupplierBuilder}.
     */
    public SupplierBuilder SupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
        return this;
    }

    /**
     * Part of the builder that sets the supplier phone number.
     * @param supplierPhoneNumber - The supplier phone number.
     * @return {@link SupplierBuilder}.
     */
    public SupplierBuilder SupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
        return this;
    }

    /**
     * Part of the builder that sets the supplier email address.
     * @param supplierEmailAddress - The supplier email address.
     * @return {@link SupplierBuilder}.
     */
    public SupplierBuilder SupplierEmailAddress(String supplierEmailAddress) {
        this.supplierEmailAddress = supplierEmailAddress;
        return this;
    }


    /**
     * Part of the builder that enable or disable the {@link Supplier}.
     * @param disable - the parameter.
     * @return {@link SupplierBuilder}.
     */
    public SupplierBuilder Disable(boolean disable) {
        isDisable = disable;
        return this;
    }

    /**
     * Part of the builder that gets the {@link BankAccount}.
     * @param bankAccount the {@link Supplier} {@link BankAccunt}.
     * @return {@link SupplierBuilder}.
     */
    public SupplierBuilder BankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    /**
     * The {@link Supplier} builder.<br>
     * Initialize the values and creates a new instance of {@link Supplier}.
     * @return a new {@link Supplier}.
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
