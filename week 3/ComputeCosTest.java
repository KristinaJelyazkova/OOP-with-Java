import java.util.Scanner;

public class ComputeCosTest {
    public static void main(String[] args) {
        double epsilon, x;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter epsilon: ");
        epsilon = in.nextDouble();

        System.out.print("Enter x: ");
        x = in.nextDouble();

        ComputeCos cos = new ComputeCos(x, epsilon);

        String computedValue = String.format("The computed value of cos(%.3f) with %.3f accuracy is %.3f.%n",
                x, epsilon, cos.computeCos());
        String realValue = String.format("The accurate value of cos(%.3f) is %.3f.%n",
                x, Math.cos(x));

        System.out.println(computedValue + realValue);
    }
}
