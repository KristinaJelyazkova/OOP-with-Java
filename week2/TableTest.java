import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class TableTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double from = getInterval("from");
        double to = getInterval("to");
        int steps = getSteps();

        if(Double.compare(from, to) > 0){
            double swap = from;
            from = to;
            to = swap;
        }

        Table table = new Table(from, to, steps);

        table.makeTable();
    }

    private double getInterval(String endpoint) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(endpoint);
        dialog.setHeaderText(null);
        dialog.setContentText("The interval is " + endpoint + ": ");

        return Double.parseDouble(dialog.showAndWait().get());
    }

    private int getSteps() {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("steps");
        dialog.setHeaderText(null);
        dialog.setContentText("The number os steps is: ");

        return Integer.parseInt(dialog.showAndWait().get());
    }
}
