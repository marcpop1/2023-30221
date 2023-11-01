class Transaction {
    private int transactionId;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private String transactionType;
    private double amount;

    public Transaction(BankAccount sourceAccount, BankAccount destinationAccount, String transactionType, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    // Additional getters for transaction attributes
}