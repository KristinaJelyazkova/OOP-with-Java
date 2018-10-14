import java.util.Scanner;

public class ComputeSinTest {
    public static void main(String[] args) {
        double epsilon,
                from = 0,
                to = Math.PI,
                stepSize = 0.1;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter epsilon: ");
        epsilon = in.nextDouble();

        ComputeSin sin = new ComputeSin(from, epsilon);

        while(Double.compare( Math.abs(from - to), stepSize ) > 0){
            System.out.printf("x = %.3f\ty = %.3f%n", from, sin.computeSin());
            from += stepSize;
            sin.setX(from);
        }

        sin.setX(to);
        System.out.printf("x = %.3f\ty = %.3f%n", to, sin.computeSin());
    }
}
