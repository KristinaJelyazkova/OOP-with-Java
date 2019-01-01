package accounts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLAccountController implements Initializable {

    private Account[] arrAccount;
    private final int SIZE = 10;
    private int current;

    @FXML
    private Button btnCreateSavingAccount;

    @FXML
    private Button btnCreateCreditAccount;

    @FXML
    private TextArea txaSavingAccounts;

    @FXML
    private TextArea txaCreditAccount;

    @FXML
    private Label lblRate;

    @FXML
    private TextField txtRate;

    @FXML
    private Button btnChangeRate;

    @FXML
    private Button btnShowAccounts;

    @FXML
    private Label lblBalance;

    @FXML
    private TextField txtBalance;


    @FXML
    void btnChangeRateClicked(ActionEvent event) {
        for (int i = 0; i < current; i++) {
            if(arrAccount[i] instanceof SavingAcc){
                SavingAcc savingAcc = (SavingAcc)arrAccount[i];
                savingAcc.setRate(Double.parseDouble(txtRate.getText()));
            }
        }
    }

    @FXML
    void btnCreateCreditAccountClicked(ActionEvent event) {
        CreditCardAcc savingAcc = new CreditCardAcc(
                Double.parseDouble(txtBalance.getText())
        );
        if(current < SIZE) {
            arrAccount[current] = savingAcc;
            current++;
        }
    }

    @FXML
    void btnCreateSavingAccountClicked(ActionEvent event) {
        SavingAcc savingAcc = new SavingAcc(
                Double.parseDouble(txtBalance.getText())
        );
        if(current < SIZE) {
            arrAccount[current] = savingAcc;
            current++;
        }
    }

    @FXML
    void btnShowAccountsClicked(ActionEvent event) {
        txaCreditAccount.setText("");
        txaSavingAccounts.setText("");
        for (int i = 0; i < current; i++) {
            if(arrAccount[i] instanceof SavingAcc){
                txaSavingAccounts.appendText(arrAccount[i].toString() + "\n");
            }
            if(arrAccount[i] instanceof CreditCardAcc){
                txaCreditAccount.appendText(arrAccount[i].toString() + "\n");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arrAccount = new Account[SIZE];
        current = 0;
        txtRate.setText("0.20");
        txtBalance.setText("1122.15");
    }
}

