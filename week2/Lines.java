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


        for(int startX = 20; startX <= width; startX += 20) {
            Line line = new Line(startX , height, 0, startX);
            line.setStroke(Color.GREEN);
            line.setStrokeWidth(1);
            group.getChildren().add(line);
        }

        primaryStage.setTitle("Drawing lines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
