package ATM;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    // Constructor
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // Adding a new account
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    // Retrieving an account by account number
    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

