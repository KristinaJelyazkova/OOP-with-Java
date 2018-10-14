import java.util.Scanner;

public class Table {
    private double from;
    private double to;
    private int steps;
    private int STEPS_AT_ONCE = 20;

    public Table(double from, double to, int steps) {
        this.from = from;
        this.to = to;
        this.steps = steps;
    }

    public void makeTable(){
        int counterSteps = 0;
        double stepSize = findStepSize();

        while(counterSteps < steps){
            counterSteps = printTable(counterSteps, stepSize);

            System.out.println("Press enter to continue...");
            Scanner in = new Scanner(System.in);

            while(in.nextLine().length() > 0){
                System.out.println("Press enter to continue...");
            }

        }
    }

    private int printTable(int counterSteps, double stepSize) {
        int i;

        for(i = counterSteps; i < counterSteps + STEPS_AT_ONCE && i < steps; i++){
            System.out.printf("x = %.4f\ty = %.4f%n", from, f(from));
            from += stepSize;
        }

        if(i == steps){
            System.out.printf("x = %.4f\ty = %.4f%n", to, f(to));
        }

        return i;
    }

    private double f(double from) {
        return Math.pow(Math.abs(from - 2), 2) / (Math.pow(from, 2) + 1);
    }

    private double findStepSize() {
        return (to - from) / steps;
    }
}
