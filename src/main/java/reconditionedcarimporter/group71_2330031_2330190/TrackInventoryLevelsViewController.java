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

public class TrackInventoryLevelsViewController
{
    @javafx.fxml.FXML
    private TableColumn <DummySetInventoryThresholds,Integer>minimumThresholdCol;
    @javafx.fxml.FXML
    private TableColumn <DummySetInventoryThresholds,String>quantityCol;
    @javafx.fxml.FXML
    private TableView<DummySetInventoryThresholds> tableViewTrackInventoryLevel;
    @javafx.fxml.FXML
    private TableColumn<DummySetInventoryThresholds,Integer> maximumThresholdCol;
    @javafx.fxml.FXML
    private TableColumn<DummySetInventoryThresholds,String> typeOfCarCol;
    ObservableList<DummySetInventoryThresholds> addedProduct;

    @javafx.fxml.FXML
    public void initialize() {
        addedProduct = FXCollections.observableArrayList();
        tableViewTrackInventoryLevel.setItems(addedProduct);
        typeOfCarCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        minimumThresholdCol.setCellValueFactory(new PropertyValueFactory<>("minimumThreshold"));
        maximumThresholdCol.setCellValueFactory(new PropertyValueFactory<>("maximumThreshold"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
    }

    @javafx.fxml.FXML
    public void goBackButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showInventoryLevelsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("DummyInventory.bin");
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
                tableViewTrackInventoryLevel.getItems().add(
                        (DummySetInventoryThresholds) ois.readObject()
                );
                DummySetInventoryThresholds product = (DummySetInventoryThresholds) ois.readObject();
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