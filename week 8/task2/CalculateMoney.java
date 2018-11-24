package money;

public class CalculateMoney {
    public static Result calculate(Change change, double deposit, double interestRate, int years){
        double depositChange = change.getValue(deposit);
        double[] moneyWithRate = new double[years];

        for (int year = 0; year < years; year++) {
            moneyWithRate[year] = depositChange * Math.pow(1.0 + interestRate, year + 1);
        }

        return new Result(depositChange, moneyWithRate);
    }
}
