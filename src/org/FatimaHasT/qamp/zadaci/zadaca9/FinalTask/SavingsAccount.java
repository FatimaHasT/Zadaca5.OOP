package org.FatimaHasT.qamp.zadaci.zadaca9.FinalTask;

public class SavingsAccount extends Account {
    private static final int DEFAULT_TRANSACTION_LIMIT = 1000;
    private static final int MAX_TRANSACTIONS_PER_DAY = 3;

    private double currentTransactionLimit;
    private int numberOfTransactionsLeft;

    public SavingsAccount(final Owner owner,
                          final String serialNumber,
                          final int passcode,
                          final double balance) {
        this(owner, serialNumber, passcode, balance, DEFAULT_TRANSACTION_LIMIT);
    }

    public SavingsAccount(final Owner owner,
                          final String serialNumber,
                          final int passcode,
                          final double balance,
                          final double initialTransactionLimit) {
        super(owner, serialNumber, passcode, balance);
        this.currentTransactionLimit = initialTransactionLimit;
        this.numberOfTransactionsLeft = MAX_TRANSACTIONS_PER_DAY;
    }

    @Override
    public double withdraw(final double amount) {
        checkTransactionAllowed();
        checkTransactionLimit(amount);
        checkSufficientFunds(amount);

        currentTransactionLimit -= amount;
        numberOfTransactionsLeft--;
        setBalance(getBalance() - amount);

        return amount;
    }

    @Override
    public double deposit(final double amount) {
        checkTransactionAllowed();
        numberOfTransactionsLeft--;
        setBalance(getBalance() + amount);

        return amount;
    }

    @Override
    public void reset() {
        numberOfTransactionsLeft = MAX_TRANSACTIONS_PER_DAY;
        currentTransactionLimit = DEFAULT_TRANSACTION_LIMIT;
    }

    @Override
    public String showAccountState() {
        return super.showAccountState() +
                "\nCurrent daily limit: " + currentTransactionLimit +
                ", number of available transactions: " + numberOfTransactionsLeft;
    }

    private void checkTransactionAllowed() {
        if (numberOfTransactionsLeft == 0) {
            throw new IllegalStateException("Daily maximum of transactions reached.");
        }
    }

    private void checkTransactionLimit(final double amount) {
        if (amount > currentTransactionLimit) {
            throw new IllegalStateException("Daily limit exceeded.");
        }
    }

    private void checkSufficientFunds(final double amount) {
        if (super.getBalance() - amount < 0) {
            throw new IllegalStateException("Insufficient funds.");
        }
    }
}
