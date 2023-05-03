package org.FatimaHasT.qamp.zadaci.zadaca9.FinalTask;

public class CurrentAccount extends Account {
    public CurrentAccount(final Owner owner, final String serialNumber, final int passcode, final double balance) {
        super(owner, serialNumber, passcode, balance);
    }

    public CurrentAccount(final String firstName, final String lastName, final String address, final String serialNumber, final int passcode, final double balance) {
        this(new Owner(firstName, lastName, address), serialNumber, passcode, balance);
    }

    @Override
    public double withdraw(final double amount) {
        if (amount > super.getBalance()) {
            throw new IllegalStateException("Insufficient funds.");
        }
        return super.withdraw(amount);
    }

    @Override
    public void reset() {
    }
}