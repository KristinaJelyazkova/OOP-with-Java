import org.w3c.dom.css.Rect;

import java.util.Random;

public class ShapesTest {
    public static void main(String[] args) {
        Random generator = new Random();
        int x = generator.nextInt(20) * (-1);
        int y = generator.nextInt(20);
        int x1 = generator.nextInt(20);
        int y1 = generator.nextInt(20) * (-1);

        Point p1 = new Point(x, y),
                p2 = new Point(x1, y1);
        Line line = new Line(p1, p2);
        Rectangle rectangle = new Rectangle(p1, p2);

        System.out.printf("The length of the line {%s} is %.2f.%n",
                line, line.measure());
        System.out.printf("The perimeter of the rectangle {%s} is %d.%n",
                rectangle, rectangle.measure());
    }
}
