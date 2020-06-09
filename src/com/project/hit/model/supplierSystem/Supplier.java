package com.project.hit.model.supplierSystem;

import java.io.*;
import java.util.Objects;

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

        if(SUPPLIER_ID == 1000 && ((new File("SUPPLIER_ID")).exists())){
            try(DataInputStream dis = new DataInputStream(new FileInputStream("SUPPLIER_ID"))) {
                SUPPLIER_ID = dis.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.supplierId = SUPPLIER_ID++;
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("SUPPLIER_ID"))) {
            dos.write(SUPPLIER_ID);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return
                supplierId == supplier.supplierId &&
                Objects.equals(companyName, supplier.companyName) &&
                Objects.equals(supplierNumber, supplier.supplierNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, supplierNumber, supplierId);
    }
}
