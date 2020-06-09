package com.project.hit.model.supplierSystem;

import java.io.Serializable;

public class BankAccount implements Serializable{

	private static final long serialVersionUID = 10L;
	private String bankNumber;
    private String account;
    private String bankBranchNumber;
    
    /**
     * The {@link BankAccount} constructor.
     * @param bank_Number - The bank number.
     * @param account - The bank account number.
     * @param bank_Branch_Number - the bank branch number.
     */
    public BankAccount(String bank_Number, String account, String bank_Branch_Number){
        this.bankNumber =bank_Number;
        this.account =account;
        this.bankBranchNumber =bank_Branch_Number;

    }

    /**
     * Gets this {@link BankAccount}account number.
     * @return the requested account number as {@link String}.
     */
    public String getAccount() {
        return account;
    }
    
    /**
     * Gets this {@link BankAccount} branch number.
     * @return the requested branch number as {@link String}.
     */
    public String getBankBranchNumber() {
        return bankBranchNumber;
    }
    
    /**
     * Gets this {@link BankAccount} bank number.
     * @return the requested bankt number as {@link String}.
     */
    public String getBankNumber() {
        return bankNumber;
    }
    
    /**
     * Sets this {@link BankAccount} account number.
     * @param account - the account number.
     */
    public void setAccount(String account) {
        this.account = account;
    }
    
    /**
     * Sets this {@link BankAccount} branch number.
     * @param account - the branch number.
     */
    public void setBankBranchNumber(String bankBranchNumber) {
        this.bankBranchNumber = bankBranchNumber;
    }
    
    /**
     * Sets this {@link BankAccount} bank number.
     * @param account - the bank number.
     */
    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }
}
