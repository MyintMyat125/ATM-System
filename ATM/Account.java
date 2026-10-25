package ATM;

public class Account implements ATMOperations {
    private String accountNumber;
    private String accountHolderName;
    private String password;
    private double balance;
    private int failedAttempts;
    private boolean isLocked;

    public Account(String accountNumber, String accountHolderName, String password, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = balance;
        this.failedAttempts = 0;
        this.isLocked = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public boolean validatePassword(String password) {
        if (isLocked) {
            System.out.println("Account is locked due to too many failed login attempts.");
            return false;
        }

        if (this.password.equals(password)) {
            failedAttempts = 0; // reset failed attempts on successful login
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= 5) {
                isLocked = true;
                System.out.println("Account locked due to too many failed login attempts.");
            }
            return false;
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transferred: " + amount + " to " + recipient.getAccountHolderName());
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
