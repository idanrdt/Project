package com.project.hit.model;

public class Supplier {

    private String companyName;
    private String supplierNumber;
    private String supplierAddress;
    private String supplierPhoneNumber;
    private String supplierEmailNumber;
    private double totalExpenses;
    private BankAccount account;
    private boolean isDisable;
    private static int supplierId = 5000;

    public Supplier(String companyName, String supplierNumber, String supplierAddress, String supplierPhoneNumber, String supplierEmailNumber, BankAccount account) {
        this.companyName = companyName;
        this.supplierNumber = supplierNumber;
        this.supplierAddress = supplierAddress;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierEmailNumber = supplierEmailNumber;
        this.account = account;
        ++supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public String getSupplierEmailNumber() {
        return supplierEmailNumber;
    }

    public void setSupplierEmailNumber(String supplierEmailNumber) {
        this.supplierEmailNumber = supplierEmailNumber;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "companyName='" + companyName + '\'' +
                ", supplierNumber='" + supplierNumber + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierPhoneNumber='" + supplierPhoneNumber + '\'' +
                ", supplierEmailNumber='" + supplierEmailNumber + '\'' +
                ", totalExpenses=" + totalExpenses +
                ", account=" + account +
                ", isDisable=" + isDisable +
                '}';
    }
}
