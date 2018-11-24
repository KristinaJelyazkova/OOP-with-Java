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
import secretchars.CipherGenerator;
import secretchars.Cipherable;
import secretchars.Result;
import secretchars.Wrapper;


public class RandomSequence extends Application {

    private TextField textSeed;
    private TextField textSize;
    private Alert messageBox;
    private int seed;
    private int size;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane(14, 14);
        root.setAlignment(Pos.CENTER);

        textSeed = new TextField("Enter the seed");
        textSeed.setPrefWidth(200);
        textSize = new TextField("Enter the size");
        textSize.setPrefWidth(200);
        messageBox = new Alert(Alert.AlertType.INFORMATION);

        Button leftButton = new Button();
        leftButton.setText("Generate random A-Z");
        leftButton.setPrefWidth(150);

        Button rightButton = new Button();
        rightButton.setText("Random sunset of A-Z");
        rightButton.setPrefWidth(150);

        Button quit = new Button();
        quit.setText("Quit");
        quit.setPrefWidth(150);



        leftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAction("random");
            }
        });

        rightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAction("selection");
            }
        });

        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        root.getChildren().addAll(textSeed, textSize, leftButton, rightButton, quit);

        primaryStage.setTitle("Generate random sequence");
        primaryStage.setScene(new Scene(root, 350, 200));
        primaryStage.show();
    }

    public void onAction(String str){
        seed = Integer.parseInt(textSeed.getText());
        size = Integer.parseInt(textSize.getText());

        Wrapper wrapper = new Wrapper(size);
        Cipherable fixed = null;

        if(str.equals("selection")) {
            fixed = wrapper.makeFixedSelection();
            messageBox.setTitle("Random subsequence of letters A-Z");
        }
        else if(str.equals("random")){
            fixed = wrapper.makeFixedRandom();
            messageBox.setTitle("Generate random subset A-Z");
        }

        CipherGenerator cipherGenerator = new CipherGenerator();
        Result result = cipherGenerator.countDistinct(fixed, seed);

        messageBox.setHeaderText("Count distinct characters out of " + size);
        messageBox.setContentText(result.toString());
        messageBox.showAndWait();
    }
}
