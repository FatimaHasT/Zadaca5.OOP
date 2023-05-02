package org.FatimaHasT.qamp.zadaci.zadaca9.FinalTask;

import java.util.Objects;

public class Account {
    private final Owner owner;
    private final String serialNumber;
    private final int passcode;
    private double balance;

    public Account(Owner owner, String serialNumber, int passcode, double balance) {
        if (passcode < 1000 || passcode > 9999) {
            throw new IllegalArgumentException("Passcode must be between 1000 and 9999.");
        }

        this.owner = Objects.requireNonNull(owner, "Owner cannot be null.");
        this.serialNumber = Objects.requireNonNull(serialNumber, "Serial number cannot be null.");
        this.passcode = passcode;
        this.balance = balance;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Must be > than 0.");
        }

        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds.");
        }

        balance -= amount;

        return amount;
    }

    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        balance += amount;

        return balance;
    }

    public void reset() {
        balance = 0;
    }

    public String showAccountState() {
        return "Owner: " + owner + "\nCurrent balance: " + balance;
    }

    public boolean verifyPasscode(int passcode) {
        return this.passcode == passcode;
    }
}
