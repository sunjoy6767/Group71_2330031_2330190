package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class ShowAddedProductAndUpdateController
{
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>furlTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> vinTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> milieTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,Double> priceTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> stringTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,Integer> SNTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>brandTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>enginTableCol;
    @javafx.fxml.FXML
    private TableView<AddProductToInventory> showAddedProductfxid;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>quantityTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> transmiTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>typeTableCol;

    ObservableList<AddProductToInventory> addedProduct;
    @javafx.fxml.FXML
    private TextField updatedQuantity;
    @javafx.fxml.FXML
    private TextField updatedBrandTextField;
    @javafx.fxml.FXML
    private TextField updatedTypeOfCarTextField;
    @javafx.fxml.FXML
    private TextField updatedVinTextField;
    @javafx.fxml.FXML
    private ComboBox<String> updatedSteeringComboBox;
    @javafx.fxml.FXML
    private TextField updatedMileTextField;
    @javafx.fxml.FXML
    private ComboBox<String> updatedTransmissionComboBox;
    @javafx.fxml.FXML
    private TextField updatedPrice;
    @javafx.fxml.FXML
    private TextField updatedFuelTypeTextField;
    @javafx.fxml.FXML
    private TextField updatedEngineCCTextField;
    @javafx.fxml.FXML
    private TextField updatedSNTextField;

    @javafx.fxml.FXML
    public void initialize() {
        updatedTransmissionComboBox.getItems().addAll("Manual","Automatic");
        updatedSteeringComboBox.getItems().addAll("Right Hand Drive","Left Hand Drive");


        addedProduct = FXCollections.observableArrayList();
        showAddedProductfxid.setItems(addedProduct);

        SNTableCol.setCellValueFactory(new PropertyValueFactory<>("StockNumber"));
        vinTableCol.setCellValueFactory(new PropertyValueFactory<>("Vin"));
        brandTableCol.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        milieTableCol.setCellValueFactory(new PropertyValueFactory<>("Milieage"));
        enginTableCol.setCellValueFactory(new PropertyValueFactory<>("Enginecc"));
        quantityTableCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        transmiTableCol.setCellValueFactory(new PropertyValueFactory<>("Transmission"));
        typeTableCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        furlTableCol.setCellValueFactory(new PropertyValueFactory<>("FuelType"));
        stringTableCol.setCellValueFactory(new PropertyValueFactory<>("Steering"));

    }

    @javafx.fxml.FXML
    public void showProductOnTableOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("AddedProductToInventory.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'AddedProductToInventory.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                showAddedProductfxid.getItems().add(
                        (AddProductToInventory) ois.readObject()
                );
                AddProductToInventory product = (AddProductToInventory) ois.readObject();
                addedProduct.add(product);
            }
//         ois.close();
        }
        catch(Exception e){
            try {
                if (ois != null) ois.close();
            }
            catch(Exception e2){
                //
            }
        }
    }

    @javafx.fxml.FXML
    public void goBackToCarInventoryManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void updateProductButtonOnAction(ActionEvent actionEvent) {
        try {
            int stockNumberToUpdate = Integer.parseInt(updatedSNTextField.getText());

            boolean productUpdated = false;

            for (AddProductToInventory product : addedProduct) {
                if (product.getStockNumber() == stockNumberToUpdate) {
                    product.setVin(updatedVinTextField.getText());
                    product.setBrand(updatedBrandTextField.getText());
                    product.setMilieage(updatedMileTextField.getText());
                    product.setEnginecc(updatedEngineCCTextField.getText());
                    product.setQuantity(updatedQuantity.getText());
                    product.setTransmission(updatedTransmissionComboBox.getValue());
                    product.setType(updatedTypeOfCarTextField.getText());
                    product.setPrice(Double.parseDouble(updatedPrice.getText()));
                    product.setFuelType(updatedFuelTypeTextField.getText());
                    product.setSteering(updatedSteeringComboBox.getValue());

                    productUpdated = true;
                    break;
                }
            }

            if (!productUpdated) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Product Not Found");
                alert.setHeaderText(null);
                alert.setContentText("No product with Stock Number " + stockNumberToUpdate + " was found.");
                alert.showAndWait();
                return;
            }

            rewriteProductFile();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText(null);
            alert.setContentText("The product has been updated successfully.");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numeric values for Stock Number, Quantity, and Price.");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to update the product file: " + e.getMessage());
            alert.showAndWait();
        }
    }

    private void rewriteProductFile() throws IOException {
        File file = new File("AddedProductToInventory.bin");
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Failed to delete the old file.");
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (AddProductToInventory product : addedProduct) {
                oos.writeObject(product);
            }
        }
    }

    @javafx.fxml.FXML
    public void clearTableOnActionButton(ActionEvent actionEvent) {

        addedProduct.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All products have been cleared from the table.");
        alert.showAndWait();

    }
}
