package Supplier;

public class BankAccount {
    private String bankNumber;
    private String account;
    private String bankBranchNumber;

    public BankAccount(String bank_Number, String account, String bank_Branch_Number){
        this.bankNumber =bank_Number;
        this.account =account;
        this.bankBranchNumber =bank_Branch_Number;

    }

    public String getAccount() {
        return account;
    }

    public String getBankBranchNumber() {
        return bankBranchNumber;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBankBranchNumber(String bankBranchNumber) {
        this.bankBranchNumber = bankBranchNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }
}
