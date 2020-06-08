package com.project.hit.model.supplierSystem;

import java.io.Serializable;

public class Supplier implements Serializable{
    private static final long serialVersionUID=1L;
    private static int SUPPLIER_ID = 1000;

    private String companyName;
    private String supplierNumber;
    private String supplierAddress;
    private String supplierPhoneNumber;
    private String supplierEmailAddress;
    private double totalExpenses;
    private boolean isDisable;
    private BankAccount bankAccount;
    private int supplierId;
    
    /**
     * The constructor of the {@link Supplier}.
     */
    public Supplier() {
        this.supplierId = SUPPLIER_ID++;
    }
    
    /**
     * Gets a {@link SupplierBuilder} for creating new instances of {@link Supplier}.
     * @return {@link SupplierBuilder} instance.
     */
    public static SupplierBuilder builder(){
        return new SupplierBuilder();
    }
    
    /**
     * Gets this requested {@link Supplier} id.
     * @return the {@link the Supplier} id.
     */
    public int getSupplierId() {
        return supplierId;
    }
    
    /**
     * Gets this {@link Supplier} company name.
     * @return the {@link the Supplier} company name.
     */
    public String getCompanyName() {
        return companyName;
    }
    
    /**
     * Gets this {@link Supplier} number.
     * @return the {@link the Supplier} number.
     */
    public String getSupplierNumber() {
        return supplierNumber;
    }
    
    /**
     * Gets this {@link Supplier} address.
     * @return the {@link the Supplier} address.
     */
    public String getSupplierAddress() {
        return supplierAddress;
    }
    
    /**
     * Gets this {@link Supplier} phone number.
     * @return the {@link the Supplier} phone number.
     */
    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }
    
    /**
     * Gets this {@link Supplier} email.
     * @return the {@link the Supplier} email.
     */
    public String getSupplierEmailAddress() {
        return supplierEmailAddress;
    }
    
    /**
     * Gets this {@link Supplier} total expenses.
     * @return the {@link the Supplier} total expenses.
     */
    public double getTotalExpenses() {
        return totalExpenses;
    }
    
    /**
     * Gets this {@link Supplier} {@link BankAccount}.
     * @return the {@link the Supplier} {@link BankAccount}.
     */
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    
    /**
     * Sets this {@link Supplier} company name.
     * @param companyName - the {@link Supplier} company name. 
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    /**
     * Sets this {@link Supplier} number.
     * @param supplierNumber - the {@link Supplier} number.
     */
    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }
    
    /**
     * Sets this {@link Supplier} address.
     * @param supplierAddress - the {@link Supplier} address.
     */
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
    
    /**
     * Sets this {@link Supplier} phone number.
     * @param supplierPhoneNumber - the {@link Supplier} phone number.
     */
    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }
    
    /**
     * Sets this {@link Supplier} email.
     * @param supplierEmailAddress - the {@link Supplier} email.
     */
    public void setSupplierEmailAddress(String supplierEmailAddress) {
        this.supplierEmailAddress = supplierEmailAddress;
    }
    
    /**
     * Sets this {@link Supplier} total expenses.
     * @param totalExpenses - the {@link Supplier} total expenses.
     */
    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
    
    /**
     * Enable or disable this {@link Supplier}.
     * @param disable - the parameter.
     */
    public void setDisable(boolean disable) {
        isDisable = disable;
    }
    
    /**
     * Sets this {@link Supplier} {@link BankAccount}.
     * @param bankAccount - the {@link BankAccount} {@link Supplier}.
     */
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
