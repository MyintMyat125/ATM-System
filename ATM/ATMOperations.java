package ATM;

public interface ATMOperations {
	void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(Account recipient, double amount);
}



