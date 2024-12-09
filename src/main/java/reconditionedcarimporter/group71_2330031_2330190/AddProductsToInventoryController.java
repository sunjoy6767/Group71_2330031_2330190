package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddProductsToInventoryController
{
    @javafx.fxml.FXML
    private TextField brandNameFxid;
    @javafx.fxml.FXML
    private ComboBox<String> transmissiontypeComboBoxFXid;
    @javafx.fxml.FXML
    private TextField vinFxid;
    @javafx.fxml.FXML
    private TextField typeOfCarFxid;
    @javafx.fxml.FXML
    private TextField priceFxid;
    @javafx.fxml.FXML
    private TextField milieageFxid;
    @javafx.fxml.FXML
    private TextField typeOfCarFxid1;
    @javafx.fxml.FXML
    private TextField engineCcFxid;
    @javafx.fxml.FXML
    private TextField quantityFxid;
    @javafx.fxml.FXML
    private ComboBox<String> steeringTypeComboBoxFXid;
    @javafx.fxml.FXML
    private TextField stockNumberFxid;

    @javafx.fxml.FXML
    public void initialize() {
        transmissiontypeComboBoxFXid.getItems().addAll("Manual","Automatic");
        steeringTypeComboBoxFXid.getItems().addAll("Right Hand Drive","Left Hand Drive");


    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        //
    }

    @javafx.fxml.FXML
    public void addProductstoInventoryOnAction(ActionEvent actionEvent) {
        //
    }
}