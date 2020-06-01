package com.project.hit.Supplier;

import java.io.Serializable;

public class Supplier implements Serializable{

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

   /* public Supplier (String company_Name, String supplier_Number, String supplier_Address
            , String supplier_Phone_Number, String supplier_Email_Address, double total_Expenses
            , boolean is_Disable, BankAccount bankAccount){
        this.companyName =company_Name;
        this.supplierNumber =supplier_Number;
        this.supplierAddress =supplier_Address;
        this.supplierPhoneNumber =supplier_Phone_Number;
        this.supplierEmailAddress =supplier_Email_Address;
        this.totalExpenses =total_Expenses;
        this.isDisable =is_Disable;
        this.bankAccount=bankAccount;
        this.supplierId=SUPPLIER_ID++;
    }*/

    public Supplier() {
        this.supplierId = SUPPLIER_ID++;
    }

    /*public Supplier(Supplier s1){
        this.companyName =s1.companyName;
        this.supplierNumber =s1.supplierNumber;
        this.supplierAddress =s1.supplierAddress;
        this.supplierPhoneNumber =s1.supplierPhoneNumber;
        this.supplierEmailAddress =s1.supplierEmailAddress;
        this.totalExpenses =s1.totalExpenses;
        this.isDisable =s1.isDisable;
        this.bankAccount=s1.bankAccount;
        this.supplierId=SUPPLIER_ID++; //error
    }*/

    /////// Builder //////
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

  /*  @Override
    public void companyName(String companyName) {
        setCompanyName(companyName);

    }


    @Override
    public void supplierNumber(String supplierNumber) {
        setSupplierNumber(supplierNumber);

    }

    @Override
    public void supplierAddress(String supplierAddress) {
        setSupplierAddress(supplierAddress);

    }

    @Override
    public void supplierPhoneNumber(String supplierPhoneNumber) {
        setSupplierPhoneNumber(supplierPhoneNumber);
    }

    @Override
    public void supplierEmailAddress(String supplierEmailAddress) {
        setSupplierEmailAddress(supplierEmailAddress);
    }

    @Override
    public void totalExpenses(double totalExpenses) {
        setTotalExpenses(totalExpenses);
    }

    public void isDisable(boolean isDisable)
    {
        setDisable(isDisable);
    }

    @Override
    public void bankAccount(BankAccount bankAccount) {
        setBankAccount(bankAccount);
    }*/

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
