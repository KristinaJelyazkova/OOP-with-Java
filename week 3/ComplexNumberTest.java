import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class ComplexNumberTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double imaginaryPart = getPart("imaginary");
        double realPart = getPart("real");

        ComplexNumber complexNumber = new ComplexNumber(imaginaryPart, realPart);

        displayComplexNumber("The representation of the complex number",
                complexNumber.getImaginaryPart(), complexNumber.getRealPart());
        displayTrigonometricForm(complexNumber.getAngle(), complexNumber.getMagnitude());

        double imaginaryPart2 = getPart("imaginary");
        double realPart2 = getPart("real");

        ComplexNumber complexNumber2 = new ComplexNumber(imaginaryPart2, realPart2);
        ComplexNumber sum = complexNumber.add(complexNumber2);

        displayComplexNumber("The sum of the complex numbers",
                sum.getImaginaryPart(), sum.getRealPart());

    }

    private double getPart(String partType) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(partType + " part");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter the " + partType + " part:");

        return Double.parseDouble(dialog.showAndWait().get());
    }

    private void displayTrigonometricForm(double angle, double magnitude) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        String result = String.format("%.2f(cos(%2$.2f) + i sin(%2$.2f))",
                magnitude, angle);

        alert.setTitle("Trigonometric form of the complex number");
        alert.setHeaderText(null);
        alert.setContentText("The trigonometric form is " + result);

        alert.showAndWait();
    }

    private void displayComplexNumber(String text, double imaginaryPart, double realPart) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        String result = String.format("%.2f + %.2f * i", realPart, imaginaryPart);

        alert.setTitle(text);
        alert.setHeaderText(null);
        alert.setContentText(text + " is " + result);

        alert.showAndWait();
    }
}
