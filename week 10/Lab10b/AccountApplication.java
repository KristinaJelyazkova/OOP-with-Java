package accounts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAccount.fxml"));
        primaryStage.setTitle("Manage Accounts");
        primaryStage.setScene(new Scene(root, 733, 315));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
