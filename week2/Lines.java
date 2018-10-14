import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Lines extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 400);

        double width = scene.getWidth();
        double height = scene.getHeight();

        Rectangle rectangle = new Rectangle(0, 0, width, height);
        rectangle.setFill(Color.BLACK);
        group.getChildren().add(rectangle);

        drawLines(height, 0, 1, 0, Color.GREEN, width,  group);
        drawLines(height, width, -1, width, Color.RED, width, group);
        drawLines(0, 0, -1, width, Color.YELLOW, width, group);
        drawLines(0, width, 1, 0, Color.BLUE, width, group);

        primaryStage.setTitle("Drawing lines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawLines(double startY, double endX, double sign, double plusStartX,
                           Paint color, double width, Group group){
        for(int startX = 20; startX <= width; startX += 20) {
            Line line = new Line(startX * sign + plusStartX, startY, endX, startX);
            line.setStroke(color);
            line.setStrokeWidth(1);
            group.getChildren().add(line);
        }
    }
}