package org.FatimaHasT.qamp.zadaci.zadaca9.FinalTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Owner fatima = new Owner("Fatima", "Hasanovic", "Ulica123");
        final Owner najla = new Owner ("Najla", "Tahunic", "Ulica321");

        final Account fatimaAccount = new CurrentAccount(fatima, "123", 1234, 1000);
        final Account najlaAccount = new SavingsAccount(najla, "321", 3210, 2000, 1000);

        final List<Account> accountList = new ArrayList<>();

        accountList.add(fatimaAccount);
        accountList.add(najlaAccount);

        final ATM atm = new ATM();

        atm.addAccounts(accountList);

        final Scanner scanner = new Scanner(System.in);

        for(;;) {
            System.out.println("Please choose one of the following options: ");
            System.out.println("1 - deposit");
            System.out.println("2 - withdraw");
            System.out.println("3 - reset");
            System.out.println("4 - show account info");

            final int option = scanner.nextInt();
            scanner.nextLine();

            if (option != 1 && option != 2 && option != 3 && option != 4 ) {
                break;
            }

            final String serialNumber;
            final int passcode;
            System.out.println("Enter the account's serial number: ");
            serialNumber = scanner.nextLine();
            System.out.println("Enter the account's passcode: ");
            passcode = scanner.nextInt();



            double amount = 0;
            if (1 == option || 2 == option) {
                System.out.println("Enter the amount of money: ");
                amount = scanner.nextDouble();
            }

            try {
                if (option == 1) {
                    atm.deposit(amount, serialNumber, passcode);
                    System.out.println("Successfully completed.\n");
                } else if (option == 2) {
                    atm.withdraw(amount, serialNumber, passcode);
                    System.out.println("Successfully completed.\n");
                } else if (option == 3) {
                    atm.reset(serialNumber, passcode);
                    System.out.println("Successfully completed.\n");
                } else if (option == 4) {
                    System.out.println(atm.showAccountState(serialNumber, passcode));
                    System.out.println("Successfully completed.\n");
                }
            } catch (final IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
