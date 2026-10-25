package ATM;

import java.util.Scanner;

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Creating sample accounts
        Account account1 = new Account("123", "Dave", "013579", 1000.00);
        Account account2 = new Account("456", "Thomas", "246810", 2000.00);

        bank.addAccount(account1);
        bank.addAccount(account2);

        System.out.println("*****************************************");
        System.out.println("Welcome to the PMT ATM Management System!");
        System.out.println("*****************************************");

        while (true) {
            System.out.print("Enter your account number: ");
            String accountNumber = scanner.nextLine();
            Account account = bank.getAccount(accountNumber);

            if (account == null) {
                System.out.println("Account not found!");
                continue;
            }

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (account.validatePassword(password)) {
                System.out.println("Welcome, " + account.getAccountHolderName() + "!");
                showMenu(account, bank);
            } else {
                System.out.println("Invalid password! Please Try Again");
            }
        }
    }

    private static void showMenu(Account account, Bank bank) {
        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient account number: ");
                    String recipientAccountNumber = scanner.nextLine();
                    Account recipient = bank.getAccount(recipientAccountNumber);
                    if (recipient == null) {
                        System.out.println("Recipient account not found!");
                        break;
                    }
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(recipient, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using PMT ATM Management System!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
