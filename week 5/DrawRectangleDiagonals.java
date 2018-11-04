import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class DrawRectangleDiagonals extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        Group pane = new Group();
        Scene scene = new Scene(pane, 300, 300);

        double[] x = new double[2];
        double[] y = new double[2];
        Point[] uPoint = new Point[2];

        for (int i = 0; i < 2; i++) {
            x[i] = random.nextDouble() * scene.getWidth() / 2;
            y[i] = random.nextDouble() * scene.getHeight() / 2;
            uPoint[i] = new Point(x[i], y[i]);
        }

        Rectangle[] rectangle = new Rectangle[2];
        rectangle[0] = new Rectangle(uPoint[0], 100, 70);
        rectangle[1] = new Rectangle(uPoint[1], 60, 110);

        Point[] diagonalPoint = new Point[6];
        Line[] diagonal = new Line[4];

        for (int i = 0; i < 2; i++) {
            diagonalPoint[i * 3] = new Point(x[i] + rectangle[i].getWidth(),
                    y[i]);
            diagonalPoint[i * 3 + 1] = new Point(x[i] + rectangle[i].getWidth(),
                    y[i] + rectangle[i].getHeight());
            diagonalPoint[i * 3 + 2] = new Point(x[i],
                    y[i] + rectangle[i].getHeight());

            diagonal[i * 2] = new Line(uPoint[i], diagonalPoint[i * 3 + 1]);
            diagonal[i * 2 + 1] = new Line(diagonalPoint[i * 3], diagonalPoint[i * 3 + 2]);
        }

        for (int i = 0; i < 2; i++) {
            rectangle[i].draw(pane);
            diagonal[i * 2].draw(pane);
            diagonal[i * 2 + 1].draw(pane);
        }

        primaryStage.setTitle("Rectangles and diagonals");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
