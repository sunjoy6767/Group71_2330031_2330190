package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddProductsToInventoryController
{

    @javafx.fxml.FXML
    private ComboBox<String> transmissiontypeComboBoxfxid;
    @javafx.fxml.FXML
    private TextField typeOfFuelfxid;
    @javafx.fxml.FXML
    private TextField vinfxid;
    @javafx.fxml.FXML
    private TextField brandNamefxid;
    @javafx.fxml.FXML
    private TextField typeOfCarfxid;
    @javafx.fxml.FXML
    private TextField pricefxid;
    @javafx.fxml.FXML
    private TextField milieagefxid;
    @javafx.fxml.FXML
    private ComboBox<String> steeringTypeComboBoxfxid;
    @javafx.fxml.FXML
    private TextField quantityfxid;
    @javafx.fxml.FXML
    private TextField engineCcfxid;
    @javafx.fxml.FXML
    private TextField stockNumberfxid;

    @javafx.fxml.FXML
    public void initialize() {
        transmissiontypeComboBoxfxid.getItems().addAll("Manual","Automatic");
        steeringTypeComboBoxfxid.getItems().addAll("Right Hand Drive","Left Hand Drive");


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