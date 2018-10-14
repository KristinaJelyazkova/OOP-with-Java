import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class RectangleTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double width = getSize("width");
        double height = getSize("height");

        Rectangle rectangle = new Rectangle(width, height);

        double area = rectangle.getArea();
        double perimeter = rectangle.getPerimeter();

        displayResult(area, perimeter);
    }

    private void displayResult(double area, double perimeter) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Area and perimeter");
        alert.setHeaderText("The rectangle's area and perimeter");
        alert.setContentText("The area is " + area
                + ".\nThe perimeter is " + perimeter + ".\n");

        alert.showAndWait();
    }

    private double getSize(String side) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(side);
        dialog.setHeaderText("Enter " + side);
        dialog.setContentText(side + ": ");

        return Double.parseDouble(dialog.showAndWait().get());
    }
}
