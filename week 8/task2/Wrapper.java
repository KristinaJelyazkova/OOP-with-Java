package money;

public class Wrapper {
    private static class Euro implements Change {

        @Override
        public double getValue(double money) {
            return 0.511 * money;
        }
    }

    public static Change getEuro(){
        return new Euro();
    }

    private static class Dollars implements Change{

        @Override
        public double getValue(double money) {
            return 0.580 * money;
        }
    }

    public static Change getDollars(){
        return new Dollars();
    }
}
