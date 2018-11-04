public class SavingsAccount {
    private static double mAnnualInterestRate = 1.5;
    private double mSavingsBalance;
    private static int count = 0;
    private int mNumber;

    public SavingsAccount(double mSavingsBalance) {
        setMSavingsBalance(mSavingsBalance);

        count++;
        mNumber = count;

        System.out.printf("SavingsAccount constructor: balance = %f, count = %d. %n",
                mSavingsBalance, count);
    }

    public SavingsAccount() {
        this(0.0);
    }

    public SavingsAccount(SavingsAccount other){
        this(other.mSavingsBalance);
    }

    public void setMSavingsBalance(double mSavingsBalance) {
        this.mSavingsBalance = mSavingsBalance;
    }

    public static double getMAnnualInterestRate() {
        return mAnnualInterestRate;
    }

    public double getMSavingsBalance() {
        return mSavingsBalance;
    }

    public static int getCount() {
        return count;
    }

    public int getMNumber() {
        return mNumber;
    }

    public void calculateMonthlyInterest(){
        mSavingsBalance += mSavingsBalance * mAnnualInterestRate / 12;
    }

    public static void modifyInterestRate(double newAnnualInterestRate){
        mAnnualInterestRate = newAnnualInterestRate;
    }

    public boolean isGreater(SavingsAccount acc){
        return mSavingsBalance > acc.mSavingsBalance;
    }

    public int getNumberOfObjects(){
        return count;
    }

    @Override
    protected void finalize(){
        count--;
        System.out.printf("SavingsAccount finalizer: balance = %f, count = %d. %n",
                mSavingsBalance, count);
    }
}
