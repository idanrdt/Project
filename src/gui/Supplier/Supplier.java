package Supplier;

import java.io.Serializable;

public class Supplier implements Serializable {

    private String Company_Name;
    private String Supplier_Number;
    private String Supplier_Address;
    private String Supplier_Phone_Number;
    private String Supplier_Email_Address;
    private double Total_Expenses;
    private boolean Is_Disable;
    private Bank_Account bankAccount;

    public Supplier (String company_Name,String supplier_Number,String supplier_Address
            ,String supplier_Phone_Number,String supplier_Email_Address,double total_Expenses
            ,boolean is_Disable,Bank_Account bankAccount){
        this.Company_Name=company_Name;
        this.Supplier_Number=supplier_Number;
        this.Supplier_Address=supplier_Address;
        this.Supplier_Phone_Number=supplier_Phone_Number;
        this.Supplier_Email_Address=supplier_Email_Address;
        this.Total_Expenses=total_Expenses;
        this.Is_Disable=is_Disable;
        this.bankAccount=bankAccount;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public String getSupplier_Number() {
        return Supplier_Number;
    }

    public String getSupplier_Address() {
        return Supplier_Address;
    }

    public String getSupplier_Phone_Number() {
        return Supplier_Phone_Number;
    }

    public String getSupplier_Email_Address() {
        return Supplier_Email_Address;
    }

    public double getTotal_Expenses() {
        return Total_Expenses;
    }

    public boolean isIs_Disable() {
        return Is_Disable;
    }

    public Bank_Account getBankAccount() {
        return bankAccount;
    }

    public void setCompany_Name(String company_Name) {
        Company_Name = company_Name;
    }

    public void setSupplier_Number(String supplier_Number) {
        Supplier_Number = supplier_Number;
    }

    public void setSupplier_Address(String supplier_Address) {
        Supplier_Address = supplier_Address;
    }

    public void setSupplier_Phone_Number(String supplier_Phone_Number) {
        Supplier_Phone_Number = supplier_Phone_Number;
    }

    public void setSupplier_Email_Address(String supplier_Email_Address) {
        Supplier_Email_Address = supplier_Email_Address;
    }

    public void setTotal_Expenses(double total_Expenses) {
        Total_Expenses = total_Expenses;
    }

    public void setIs_Disable(boolean is_Disable) {
        Is_Disable = is_Disable;
    }

    public void setBankAccount(Bank_Account bankAccount) {
        this.bankAccount = bankAccount;
    }
}
