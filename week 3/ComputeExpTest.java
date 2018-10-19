import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class
ComputeExpTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int accuracy; // number of terms in the series representation
        double  from = 0,
                to = 1,
                stepSize = 0.01;

        accuracy = inputAccuracy();

        ComputeExp exp = new ComputeExp(from, accuracy);

        while(Double.compare( Math.abs(from - to), stepSize ) > 0){
            displayResult(from, accuracy, exp.computeExp());
            from += stepSize;
            exp.setX(from);
        }

        exp.setX(to);
        displayResult(to, accuracy, exp.computeExp());
    }

    private void displayResult(double x, int accuracy, double computeExp) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        String computedValue = String.format("The computed value of exp(%.3f) with %d terms is %.3f.%n",
                x, accuracy, computeExp);
        String realValue = String.format("The accurate value of exp(%.3f) is %.3f.%n",
                x, Math.exp(x));

        alert.setTitle("Compute Exponent");
        alert.setHeaderText("Comparing the computed and the accurate value of exp.");
        alert.setContentText(computedValue + realValue);

        alert.showAndWait();
    }

    private int inputAccuracy() {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Accuracy");
        dialog.setHeaderText("Higher number of terms define higher acccuracy.");
        dialog.setContentText("Enter number of terms: ");

        return Integer.parseInt(dialog.showAndWait().get());
    }
}
