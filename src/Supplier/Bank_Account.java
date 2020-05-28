package Supplier;

public class Bank_Account {
    private String Bank_Number;
    private String Account;
    private String Bank_Branch_Number;

    public Bank_Account(String bank_Number,String account,String bank_Branch_Number){
        this.Bank_Number=bank_Number;
        this.Account=account;
        this.Bank_Branch_Number=bank_Branch_Number;

    }

    public String getAccount() {
        return Account;
    }

    public String getBank_Branch_Number() {
        return Bank_Branch_Number;
    }

    public String getBank_Number() {
        return Bank_Number;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public void setBank_Branch_Number(String bank_Branch_Number) {
        Bank_Branch_Number = bank_Branch_Number;
    }

    public void setBank_Number(String bank_Number) {
        Bank_Number = bank_Number;
    }
}
