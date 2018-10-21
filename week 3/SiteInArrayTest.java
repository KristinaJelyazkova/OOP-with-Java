import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class SiteInArrayTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int[] sortedArray = new int[]{1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 7};
        //int[] sortedArray = {1, 2, 3, 4, 5};
        int[] startIndexSite = new int[sortedArray.length];
        int[] lengthSite = new int[sortedArray.length];

        int counterSites = SiteInArray.allSites(sortedArray, startIndexSite, lengthSite);

        if(counterSites == 0){
            displayResult("No sites in the array.");
        }
        else{
            String table = String.format("%8s%8s%8s%n","Start", "Length", "Number");

            for (int i = 0; i < counterSites; i++) {
                table += String.format("%8d%8d%8d%n", startIndexSite[i] + 1, lengthSite[i], sortedArray[ startIndexSite[i] ]);
            }

            //System.out.println("The table shows the start indexes of the sites, their lengths and their repetitive numbers:");
            //System.out.println();
            //System.out.print(table);

             displayResult(table);
        }
    }

    private void displayResult(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Sites in the array");
        alert.setHeaderText(null);
        String table = String.format("%8s%8s%8s%n","Start", "Length", "Number");
        alert.setContentText(message);

        alert.showAndWait();
    }
}
