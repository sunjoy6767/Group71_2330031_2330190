package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GenerateInventoryReportsViewController
{
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>furlTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>vinTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>milieTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>steeringTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,Double>priceTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,Integer> SNTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>brandTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>transmiTableCol;
    @javafx.fxml.FXML
    private TableView <AddProductToInventory> generateInventoryReportTableView;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String> enginTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String> quantityTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String> typeTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String> warehouseCol;
    ObservableList<AddProductToInventory> addedProduct;

    @javafx.fxml.FXML
    public void initialize() {

        addedProduct = FXCollections.observableArrayList();
        generateInventoryReportTableView.setItems(addedProduct);

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
        steeringTableCol.setCellValueFactory(new PropertyValueFactory<>("Steering"));
        warehouseCol.setCellValueFactory(new PropertyValueFactory<>("Warehouse"));
    }

    @javafx.fxml.FXML
    public void goBackToInventoryManagerButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void generateInventoryReportsButtonOnAction(ActionEvent actionEvent) {
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
                generateInventoryReportTableView.getItems().add(
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
}