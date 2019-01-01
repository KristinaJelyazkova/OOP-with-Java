package accounts;

public class CreditCardAcc extends Account {
    public CreditCardAcc(double balance) {
        super(balance);
    }

    @Override
    public String toString() {
        return String.format("Credit card account with balance %.2f",
                getBalance());
    }
}
