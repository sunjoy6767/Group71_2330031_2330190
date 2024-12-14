package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    private ComboBox<String> warehouseInfoComboBox;
    @javafx.fxml.FXML
    private DatePicker manufacuredDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
        transmissiontypeComboBoxfxid.getItems().addAll("Manual","Automatic");
        steeringTypeComboBoxfxid.getItems().addAll("Right Hand Drive","Left Hand Drive");
        warehouseInfoComboBox.getItems().addAll("Dhaka Central Auto Hub", "Chittagong Vehicle Storage Facility", "Khulna Auto Logistics Center", "Rajshahi Motor Warehouse", "Sylhet Import Car Depot", "Gazipur Automobile Stockyard", "Narayanganj Auto Distribution Center", "Barisal Vehicle Holding Facility", "Cumilla Transport Hub", "Bogura Car Storage Depot");


    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
        //
    }

    @javafx.fxml.FXML
    public void addProductstoInventoryOnAction(ActionEvent actionEvent) {
        try{
            if (stockNumberfxid.getText().isEmpty() || vinfxid.getText().isEmpty() ||
                    brandNamefxid.getText().isEmpty() || milieagefxid.getText().isEmpty() ||
                    engineCcfxid.getText().isEmpty() || typeOfCarfxid.getText().isEmpty() ||
                    typeOfFuelfxid.getText().isEmpty() || quantityfxid.getText().isEmpty() ||
                    pricefxid.getText().isEmpty())
            {
                showAlert("Validation Error", "All fields must be filled in.");
                return;
            }

            try {
                Integer.parseInt(stockNumberfxid.getText());
            } catch (NumberFormatException e) {
                showAlert("Validation Error", "Stock Number must be a valid number.");
                return;
            }

            try {
                Double.parseDouble(pricefxid.getText());
            } catch (NumberFormatException e) {
                showAlert("Validation Error", "Price must be a valid number.");
                return;
            }

            File f = new File("AddedProductToInventory.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);;
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }



            oos.writeObject(new AddProductToInventory(Integer.parseInt(stockNumberfxid.getText()),vinfxid.getText(),brandNamefxid.getText(),milieagefxid.getText(),engineCcfxid.getText(),typeOfCarfxid.getText(),typeOfFuelfxid.getText(),quantityfxid.getText(),Double.parseDouble(pricefxid.getText()),transmissiontypeComboBoxfxid.getValue(),steeringTypeComboBoxfxid.getValue(),warehouseInfoComboBox.getValue(), manufacuredDatePicker.getValue()));
            stockNumberfxid.clear();
            vinfxid.clear();
            brandNamefxid.clear();
            milieagefxid.clear();
            engineCcfxid.clear();
            typeOfCarfxid.clear();
            typeOfFuelfxid.clear();
            quantityfxid.clear();
            pricefxid.clear();
            transmissiontypeComboBoxfxid.setValue(null);
            steeringTypeComboBoxfxid.setValue(null);
            warehouseInfoComboBox.setValue(null);
            manufacuredDatePicker.setValue(null);


            oos.close();
        }
        catch(Exception e){
            //

        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}