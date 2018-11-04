import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DrawTriangle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int size = 5;

        Group pane = new Group();
        Scene scene = new Scene(pane, 90 * size, 80 * size);

        Rpoint A = new Rpoint(25 * size, Math.PI/3),
                B = new Rpoint(60 * size, Math.PI/6),
                C = new Rpoint(100 * size, Math.PI/4);

        A.drawLine(pane, B);
        B.drawLine(pane, C);
        C.drawLine(pane, A);

        double[][] coordinates = new double[3][2];

        coordinates[0] = A.toCartesian();
        coordinates[1] = B.toCartesian();
        coordinates[2] = C.toCartesian();

        for (int i = 0; i < 3; i++) {
            String s1 = String.format("%.2s", coordinates[i][0]),
                    s2 = String.format("%.2s", coordinates[i][1]);
            Text text = new Text(coordinates[i][0] - 1, coordinates[i][1] - 5,
                    ((char) (i + 'A')) + "[" + s1 + ", " + s2+ "]");
            text.setFont(Font.font("Verdana", 5 * size / 2));
            text.setFill(Color.RED);

            pane.getChildren().add(text);
        }

        primaryStage.setTitle("Draw triangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
