package product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class FXMLProductsController implements Initializable {

    ListOfProducts<Product> listOfProducts;

    @FXML
    private Button btnAddToList;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtPrice;

    @FXML
    private Button btnSortProducts;

    @FXML
    private Button btnShowProducts;

    @FXML
    private Button btnAveragePrice;

    @FXML
    private Button btnGroupByCategory;

    @FXML
    private TextArea txaProductsInformation;

    @FXML
    void btnAddToListClicked(ActionEvent event) {
        Product product = new Product(txtDescription.getText(),
                txtCategory.getText(),
                Double.parseDouble(txtPrice.getText()));

        listOfProducts.addElement(product);
    }

    @FXML
    void btnAveragePriceClicked(ActionEvent event) {
        Double averagePrice = listOfProducts.averageOfElementsProperty(Product::getPrice);

        if(averagePrice == null){
            txaProductsInformation.setText("Average price is not present.\n");
        }
        else{
            String str = String.format("Average price is %.2f.%n", averagePrice);
            txaProductsInformation.setText(str);
        }
    }

    @FXML
    void btnGroupByCategoryClicked(ActionEvent event) {
        txaProductsInformation.setText("");
        Map<String, List<Product>> result = listOfProducts.groupByElementsProperty(Product::getCategory);

        result.entrySet().stream()
                .sorted(Map.Entry.<String, List<Product>>comparingByKey().reversed())
                .forEach(stringListEntry -> {
                    txaProductsInformation.appendText("Products of category " + stringListEntry.getKey() + ":\n");

                    for (Product product : stringListEntry.getValue()){
                        txaProductsInformation.appendText(product.toString() + "\n");
                    }

                    txaProductsInformation.appendText("\n");
                });
    }

    @FXML
    void btnShowProductsClicked(ActionEvent event) {
        txaProductsInformation.setText("");
        double enteredPrice = Double.parseDouble(txtPrice.getText());

        List<Product> result = listOfProducts.listOfFilteredElements(product ->
                Double.compare(product.getPrice(), enteredPrice) > 0);

        if(result.isEmpty()){
            txaProductsInformation.setText("All products are cheaper than the entered price.\n");
        }
        else {
            for (Product product : result) {
                txaProductsInformation.appendText(product.toString() + "\n");
            }
        }
    }

    @FXML
    void btnSortProductsClicked(ActionEvent event) {
        listOfProducts.sort((product1, product2) -> {
            int result = Double.compare(product2.getPrice() - product1.getPrice(), 0.);
            if(result > 0){
                return 1;
            }
            else if(result < 0){
                return -1;
            }
            else{
                return 0;
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listOfProducts = new ListOfProducts<>();
    }
}

