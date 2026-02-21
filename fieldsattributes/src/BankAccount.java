public class BankAccount {
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public String withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return "Success";
        } else {
            return "Insufficient funds";
        }
    }
}