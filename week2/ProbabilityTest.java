public class ProbabilityTest {
    public static void main(String[] args) {
        Probability probability = new Probability();
        String percentage = String.format("%.2f%%", probability.probability() * 100);

        System.out.printf("All numbers are %d.%n", probability.allNumbers());
        System.out.printf("The numbers divisible by 12 are %d.%n", probability.numbersDivisibleBy12());
        System.out.printf("The probability is %s.%n", percentage);

    }
}
