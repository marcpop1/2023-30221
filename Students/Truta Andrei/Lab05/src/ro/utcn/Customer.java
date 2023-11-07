package ro.utcn;

import jdk.jfr.Unsigned;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static Integer nextId = -1;
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    public Customer(String name, String address, String email, String phone) {
        this.id = ++nextId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public void openAccount(BankAccount.AccountType accountType) {
        BankAccount account = new BankAccount(accountType);
        accounts.add(account);
    }

    private BankAccount getAccount(Integer accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void depositCurrency(Integer accountNumber, Double amount) {
        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        account.depositCurrency(amount);
    }

    public void withdrawCurrency(Integer accountNumber, Double amount) {
        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        account.withdrawCurrency(amount);
    }

    //Moves currency between own accounts
    public void transferInternalCurrency(Integer sourceAccountNumber, Integer destinationAccountNumber, Double amount) {
        BankAccount sourceAccount = getAccount(sourceAccountNumber);
        BankAccount destinationAccount = getAccount(destinationAccountNumber);

        if (sourceAccount == null || destinationAccount == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        Transaction transaction = new Transaction(sourceAccount, destinationAccount, Transaction.TransactionType.TRANSFER_OUT, amount, null);
        sourceAccount.addTransaction(transaction);

        transaction = new Transaction(sourceAccount, destinationAccount, Transaction.TransactionType.TRANSFER_IN, amount, null);
        destinationAccount.addTransaction(transaction);
    }

    //Transfer between accounts of different customers
    public void transferExternalCurrency(Integer sourceAccountNumber, Customer destinationCustomer, Integer destinationAccountNumber, Double amount) {
        BankAccount sourceAccount = getAccount(sourceAccountNumber);
        BankAccount destinationAccount = destinationCustomer.getAccount(destinationAccountNumber);

        if (sourceAccount == null || destinationAccount == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        //TODO: If I handle the invalid input here, addTransaction() can assume that the input is valid
        //TODO: Should I add checks in addTransaction() as well? I see no reason because it's only called from here
        //TODO: But having a method that doesn't validate the input seems weird
        if (amount > sourceAccount.getBalance()) {
            throw new IllegalArgumentException("Amount cannot be greater than balance");
        }

        Transaction transaction = new Transaction(sourceAccount, destinationAccount, Transaction.TransactionType.TRANSFER_OUT, amount, null);
        sourceAccount.addTransaction(transaction);
        transaction = new Transaction(sourceAccount, destinationAccount, Transaction.TransactionType.TRANSFER_IN, amount, null);
        destinationAccount.addTransaction(transaction);
    }

    public Double getBalance(Integer accountNumber) {
        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        return account.getBalance();
    }

    public String getName() {
        return this.name;
    }

    public Integer getAccountNumber(Integer accountNumber) {
        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        return account.getAccountNumber();
    }

}
