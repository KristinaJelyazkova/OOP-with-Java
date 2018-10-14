import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class DrawLines extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 400);

        double width = scene.getWidth();
        double height = scene.getHeight();

        lines(1, 0,width, 0, width, group);
        lines(1, 0,0, height, width, group);
        lines(-1, width, 0, 0, width, group);
        lines(-1, width,width, height, width, group);

        primaryStage.setTitle("Drawing lines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void lines(double sign, double plusStartX,
                       double endX, double endY, double width, Group group){
        for(int startX = 20; startX <= width; startX += 20){
            Line line = new Line(startX * sign + plusStartX, startX, endX, endY);
            line.setStroke(Color.ORANGE);
            line.setStrokeWidth(1);
            group.getChildren().add(line);
        }
    }
}
