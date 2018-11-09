import javax.swing.*;
import java.util.Random;

public class BubbleSortTest {
    private static final int SIZE = 3;
    private static Comparable arrComparable[] = new Comparable[SIZE];

    public static void main(String[] args) {
        Random generator = new Random();
        int x, y, radius, height;
        Point point[] = new Point[SIZE];
        Circle circle[] = new Circle[SIZE];
        Cylinder cylinder[] = new Cylinder[SIZE];

        for (int i = 0; i < SIZE; i++) {
            x = generator.nextInt(41)  + 10;
            y = generator.nextInt(41) + 10;
            radius = generator.nextInt(21) + 10;
            height = generator.nextInt(51) + 10;

            point[i] = new Point(x, y);
            circle[i] = new Circle(point[i], radius);
            cylinder[i] = new Cylinder(circle[i], height);

            arrComparable[i] = point[i];
        }

        BubbleSort.sortArray(arrComparable);

        String message = String.format("Sorted array of points:%n [%s,%n%s,%n%s]%n",
                arrComparable[0], arrComparable[1], arrComparable[2]);
        JOptionPane.showMessageDialog(null, message);

        for (int i = 0; i < SIZE; i++) {
            arrComparable[i] = circle[i];
        }

        BubbleSort.sortArray(arrComparable);

        message = String.format("Sorted array of circles:%n [%s,%n%s,%n%s]%n",
                arrComparable[0], arrComparable[1], arrComparable[2]);
        JOptionPane.showMessageDialog(null, message);


        for (int i = 0; i < SIZE; i++) {
            arrComparable[i] = cylinder[i];
        }

        BubbleSort.sortArray(arrComparable);

        message = String.format("Sorted array of cylinders:%n [%s,%n%s,%n%s]%n",
                arrComparable[0], arrComparable[1], arrComparable[2]);
        JOptionPane.showMessageDialog(null, message);
    }
}
