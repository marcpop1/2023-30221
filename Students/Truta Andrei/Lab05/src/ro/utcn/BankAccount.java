package ro.utcn;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {


    public static enum AccountType {
        CURRENT, SAVINGS
    }
    public static Integer nextId = -1;
    private Integer accountNumber;
    private AccountType accountType;
    private Double balance;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public BankAccount(AccountType accountType) {
        this.accountType = accountType;
        this.balance = 0.0;
        this.accountNumber = ++nextId;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    //Add necessary check for negative values and so on
    public void depositCurrency(Double amount) {
        this.balance += amount;
    }

    public void withdrawCurrency(Double amount) {
        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Double getBalance() {
        return this.balance;
    }
}
