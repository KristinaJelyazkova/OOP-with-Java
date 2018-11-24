package money;

import java.util.Arrays;

public class Result {
    private double money;
    private double[] moneyWithRate;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = (money > 0) ? money : 0;
    }

    public double[] getMoneyWithRate() {
        return Arrays.copyOf(moneyWithRate, moneyWithRate.length);
    }

    public void setMoneyWithRate(double[] moneyWithRate) {
        this.moneyWithRate = Arrays.copyOf(moneyWithRate, moneyWithRate.length);
    }

    public Result(double money, double[] moneyWithRate) {
        setMoney(money);
        setMoneyWithRate(moneyWithRate);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < moneyWithRate.length; i++) {
            String current = String.format("After %d year: %.2f%n",
                    i + 1, moneyWithRate[i]);
            stringBuilder.append(current);
        }

        return String.format("deposit = %.3f%nafter interest rate:%n%s%n",
                money, stringBuilder);
    }
}
