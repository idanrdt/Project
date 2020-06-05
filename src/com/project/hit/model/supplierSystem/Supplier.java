package com.project.hit.model.supplierSystem;

import java.io.Serializable;

public class Supplier implements Serializable{
    private static final long serialVersionUID=1L;
    private static int  SUPPLIER_ID = 1000;

    private String companyName;
    private String supplierNumber;
    private String supplierAddress;
    private String supplierPhoneNumber;
    private String supplierEmailAddress;
    private double totalExpenses;
    private boolean isDisable;
    private BankAccount bankAccount;
    private int supplierId;

    public Supplier() {
        this.supplierId = SUPPLIER_ID++;
    }

    public static SupplierBuilder builder(){
        return new SupplierBuilder();
    }

    public  int getSupplierId() {
        return supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public String getSupplierEmailAddress() {
        return supplierEmailAddress;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public void setSupplierEmailAddress(String supplierEmailAddress) {
        this.supplierEmailAddress = supplierEmailAddress;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


}
