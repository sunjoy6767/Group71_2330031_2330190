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
import java.time.LocalDate;

public class MonitorDocumentExpiryViewController
{
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> vinTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> expireTableCol;
    @javafx.fxml.FXML
    private TableView<AddProductToInventory> documentExpiryTableViewfxid;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, Integer> SNTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> brandTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, LocalDate> manufactureYearTableCol;

    private ObservableList<AddProductToInventory> addProductToInventories;

    @javafx.fxml.FXML
    public void initialize() {
        addProductToInventories = FXCollections.observableArrayList();
        documentExpiryTableViewfxid.setItems(addProductToInventories);

        SNTableCol.setCellValueFactory(new PropertyValueFactory<AddProductToInventory, Integer>("StockNumber"));
        vinTableCol.setCellValueFactory(new PropertyValueFactory<AddProductToInventory, String>("Vin"));
        brandTableCol.setCellValueFactory(new PropertyValueFactory<AddProductToInventory, String>("Brand"));
        manufactureYearTableCol.setCellValueFactory(new PropertyValueFactory<AddProductToInventory, LocalDate>("manufactured"));

    }

    @javafx.fxml.FXML
    public void goBackToInventoryManagerButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void clearTableViewButtonOnAction(ActionEvent actionEvent) {
        addProductToInventories.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void monitorDocumentExpiryButtonOnAction(ActionEvent actionEvent) {
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
                documentExpiryTableViewfxid.getItems().add(
                        (AddProductToInventory) ois.readObject()
                );
                AddProductToInventory product = (AddProductToInventory) ois.readObject();
                addProductToInventories.add(product);
            }
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