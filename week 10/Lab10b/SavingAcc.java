package accounts;

public class SavingAcc extends Account {
    private double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = (rate > 0 && rate < 1) ? rate : 0.2;
    }

    public SavingAcc(double balance, double rate) {
        super(balance);
        setRate(rate);
    }

    public SavingAcc(double balance) {
        this(balance, 0.2);
    }

    @Override
    public String toString() {
        return String.format("Saving account with balance %.2f and rate %.2f",
                getBalance(), rate);
    }
}
