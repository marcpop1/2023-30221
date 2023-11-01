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

    //getters/setters to moditfy the private fields

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
        account.depositCurrency(amount);
    }

    public void withdrawCurrency(Integer accountNumber, Double amount) {
        BankAccount account = getAccount(accountNumber);
        account.withdrawCurrency(amount);
    }

    //Moves currency between own accounts
    public void transferInternalCurrency(Integer sourceAccountNumber, Integer destinationAccountNumber, Double amount) {
        BankAccount sourceAccount = getAccount(sourceAccountNumber);
        BankAccount destinationAccount = getAccount(destinationAccountNumber);
        sourceAccount.withdrawCurrency(amount);
        destinationAccount.depositCurrency(amount);

        Transaction transaction = new Transaction(sourceAccount, destinationAccount, Transaction.TransactionType.TRANSFER, amount, null);
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);
    }

    //Transfer between accounts of different customers
    public void transferExternalCurrency(Integer sourceAccountNumber, Customer destinationCustomer, Integer destinationAccountNumber, Double amount) {
        BankAccount sourceAccount = getAccount(sourceAccountNumber);
        BankAccount destinationAccount = destinationCustomer.getAccount(destinationAccountNumber);
        sourceAccount.withdrawCurrency(amount);
        destinationAccount.depositCurrency(amount);

        Transaction transaction = new Transaction(sourceAccount, destinationAccount, Transaction.TransactionType.TRANSFER, amount, null);
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);
    }

    public Double getBalance(Integer accountNumber) {
        BankAccount account = getAccount(accountNumber);
        return account.getBalance();
    }

}
