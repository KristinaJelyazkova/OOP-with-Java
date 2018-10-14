import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class StockTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String name = getAttribute("name");
        String symbol = getAttribute("symbol");

        Stock stock = new Stock(symbol, name);

        double previousClosingPrice = getPrice("previous closing price");
        double currentPrice = getPrice("current price");

        stock.setPreviousClosingPrice(previousClosingPrice);
        stock.setCurrentPrice(currentPrice);

        double percent = stock.changePercent();

        displayResult(percent, stock.getName(), stock.getSymbol());
    }

    private void displayResult(double percent, String name, String symbol) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Percent of change");
        alert.setHeaderText("The percentage of change of this "
                + name + " with symbol " + symbol);
        alert.setContentText("The percentage of change is " + percent + ".\n");

        alert.showAndWait();
    }

    private String getAttribute(String attribute) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(attribute);
        dialog.setHeaderText("Enter " + attribute);
        dialog.setContentText(attribute + ": ");

        return dialog.showAndWait().get();
    }

    private double getPrice(String price) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(price);
        dialog.setHeaderText("Enter " + price);
        dialog.setContentText(price + ": ");

        return Double.parseDouble(dialog.showAndWait().get());
    }
}
