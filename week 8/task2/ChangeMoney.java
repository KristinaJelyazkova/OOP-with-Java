import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import money.CalculateMoney;
import money.Result;
import money.Wrapper;

public class ChangeMoney extends Application {
    private TextField depositText;
    private TextField interestRateText;
    private Alert messageBox;
    private double deposit;
    private double interestRate;
    private int years = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane(14, 14);
        root.setAlignment(Pos.CENTER);

        depositText = new TextField("Enter deposit...");
        depositText.setPrefWidth(250);
        interestRateText = new TextField("Enter interest rate...");
        interestRateText.setPrefWidth(250);
        messageBox = new Alert(Alert.AlertType.INFORMATION);

        Button euro = new Button();
        euro.setText("EUR");
        euro.setPrefWidth(60);

        Button dollar = new Button();
        dollar.setText("USD");
        dollar.setPrefWidth(60);

        Button quit = new Button();
        quit.setText("Quit");
        quit.setPrefWidth(60);

        euro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAction("EUR");
            }
        });

        dollar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAction("USD");
            }
        });

        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        root.getChildren().addAll(depositText, interestRateText, euro, dollar, quit);

        primaryStage.setTitle("Changing money");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    public void onAction(String currency){
        deposit = Double.parseDouble(depositText.getText());
        interestRate = Double.parseDouble(interestRateText.getText());
        Result result = null;
        if(currency.equals("EUR")){
            result = CalculateMoney.calculate(Wrapper.getEuro(), deposit, interestRate, years);
        }
        else if(currency.equals("USD")){
            result = CalculateMoney.calculate(Wrapper.getDollars(), deposit, interestRate, years);
        }

        messageBox.setTitle("Money in " + currency);
        messageBox.setHeaderText("Deposit in " + currency +
                " and money with interest rate for the next " + years + " years");
        messageBox.setContentText(result.toString());
        messageBox.showAndWait();
    }
}
