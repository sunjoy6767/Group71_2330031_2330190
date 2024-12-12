package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
    private ComboBox<AddProductToInventory> updatedSteeringComboBox;
    @javafx.fxml.FXML
    private TextField updatedMileTextField;
    @javafx.fxml.FXML
    private ComboBox<AddProductToInventory> updatedTransmissionComboBox;
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
                //Alert: file does not exist
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
        
    }
}
