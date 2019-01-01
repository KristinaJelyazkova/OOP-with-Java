package accounts;

public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = (balance > 0) ? balance : 0;
    }

    public Account(double balance) {
        setBalance(balance);
    }
}
