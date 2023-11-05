package ro.utcn;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    //TODO: Do you think it's a good idea to have this enum here?
    //TODO: Would a separate class be better?
    public static enum AccountType {
        CURRENT, SAVINGS
    }

    //TODO: Is this a good way to handle the id?
    //TODO: As in, is it a good idea to have it as a static field?
    //TODO: The idea is to have a way to keep track of the used ids across all instances of BankAccount
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

    //TODO: How do you handle cases where the user input is invalid in an actual app?
    //TODO: Is throwing an exception a good idea or is there a better way? Should I just ignore the input or print an error message?
    public void depositCurrency(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance += amount;
    }

    public void withdrawCurrency(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Amount cannot be greater than balance");
        }
        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        //TODO: Duplicate branches but it's easier to read, is it worth it?
        switch (transaction.getTransactionType()) {
            case DEPOSIT:
                this.balance += transaction.getAmount();
                break;
            case WITHDRAWAL:
                this.balance -= transaction.getAmount();
                break;
            case TRANSFER_IN:
                this.balance += transaction.getAmount();
                break;
            case TRANSFER_OUT:
                this.balance -= transaction.getAmount();
                break;
        }

        transactions.add(transaction);
    }

    public Double getBalance() {
        return this.balance;
    }
}
