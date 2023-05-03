package org.FatimaHasT.qamp.zadaci.zadaca9.FinalTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private Map<String, Account> accountMap;

    public ATM() {
        accountMap = new HashMap<>();
    }

    public void addAccount(Account account) {
        if (accountMap.containsKey(account.getSerialNumber())) {
            throw new IllegalStateException("Account serial number must be unique.");
        }
        accountMap.put(account.getSerialNumber(), account);
    }

    public void addAccounts(List<Account> accountList) {
        for (Account account : accountList) {
            addAccount(account);
        }
    }

    public double withdraw(double amount, String serialNumber, int passcode) {
        Account account = findAccount(serialNumber, passcode);
        return account.withdraw(amount);
    }

    public double deposit(double amount, String serialNumber, int passcode) {
        Account account = findAccount(serialNumber, passcode);
        return account.deposit(amount);
    }

    public void reset(String serialNumber, int passcode) {
        Account account = findAccount(serialNumber, passcode);
        account.reset();
    }

    public String showAccountState(String serialNumber, int passcode) {
        Account account = findAccount(serialNumber, passcode);
        return account.showAccountState();
    }

    private Account findAccount(String serialNumber, int passcode) {
        if (passcode < 1000 || passcode > 9999) {
            throw new IllegalArgumentException("Passcode is out of range.");
        }
        Account account = accountMap.get(serialNumber);
        if (account == null) {
            throw new IllegalStateException("Account not found.");
        }
        if (!account.verifyPasscode(passcode)) {
            throw new IllegalStateException("Passcode is not correct.");
        }
        return account;
    }
}



