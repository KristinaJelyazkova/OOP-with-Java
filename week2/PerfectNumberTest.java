public class PerfectNumberTest {
    private static final int NUMBER_OF_PERFECTS = 1000;

    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();

        for(int number = 1; number < NUMBER_OF_PERFECTS; number++){
            if(perfectNumber.isPerfect(number)){
                System.out.printf("number = %d%n",number);
                System.out.println("Multipliers:");
                perfectNumber.showMultipliers(number);
                System.out.println();
            }
        }
    }
}
