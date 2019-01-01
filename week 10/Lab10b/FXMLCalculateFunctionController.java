package func;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class FXMLCalculateFunctionController implements Initializable {

    private BigDecimal x, y, z, result;
    private static final NumberFormat numberFormat
            = NumberFormat.getInstance();

    @FXML
    private Text lblEnterValues;

    @FXML
    private Label lblX;

    @FXML
    private Label lblY;

    @FXML
    private Label lblZ;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtX;

    @FXML
    private TextField txtY;

    @FXML
    private TextField txtZ;

    @FXML
    private TextField txtResult;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnExit;

    @FXML
    void btnCalculateClicked(ActionEvent event) {
        x = new BigDecimal(txtX.getText());
        y = new BigDecimal(txtY.getText());
        z = new BigDecimal(txtZ.getText());
        BigDecimal x1 = x.multiply(x).add(new BigDecimal(1.)),
                y1 = x.multiply(z).add(y).multiply(new BigDecimal(-9.)),
                z1 = y.multiply(y).add(new BigDecimal(4.)),
                z2 = x.add(new BigDecimal(2.)).multiply(y)
                        .add(new BigDecimal(3.)).divide(z1, RoundingMode.HALF_UP);
        result = x.multiply(x).multiply(new BigDecimal(4.))
                .divide(x1, RoundingMode.HALF_UP).add(y1).add(z2);

        if(result.compareTo(new BigDecimal(10.)) > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error in result");
            alert.setContentText("Result is bigger than 10!");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            txtResult.setText(numberFormat.format(result));
        }
    }

    @FXML
    void btnExitClicked(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtX.setText("0.00");
        txtY.setText("0.00");
        txtZ.setText("0.00");
    }
}

