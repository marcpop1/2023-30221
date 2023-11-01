package ro.utcn;

public class Transaction {
    public static enum TransactionType {
        DEPOSIT, WITHDRAWAL, TRANSFER
    }
    private Integer id;
    private BankAccount sourceAccount;;
    private BankAccount destinationAccount;
    private TransactionType transactionType;
    private Double amount;
    private BankStaff representative;

    public Transaction(BankAccount sourceAccount, BankAccount destinationAccount, TransactionType transactionType, Double amount, BankStaff representative) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionType = transactionType;
        this.amount = amount;
        this.representative = representative;
    }
}
