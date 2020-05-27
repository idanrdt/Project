package com.project.hit.model;

public class BankAccount {

    private String accountNumber;
    private String bankNumber;
    private String bankBranchNumber;

    public BankAccount(String accountNumber, String bankNumber, String bankBranchNumber) {
        this.accountNumber = accountNumber;
        this.bankNumber = bankNumber;
        this.bankBranchNumber = bankBranchNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankBranchNumber() {
        return bankBranchNumber;
    }

    public void setBankBranchNumber(String bankBranchNumber) {
        this.bankBranchNumber = bankBranchNumber;
    }
}
