package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class ShipmentDelaysViewController
{
    @javafx.fxml.FXML
    private TextField shipmentIdTextField;
    @javafx.fxml.FXML
    private TableColumn<ShipmentDelays, Integer> estimatedDelayCol;
    @javafx.fxml.FXML
    private TableColumn<ShipmentDelays, String> shipmentIdCol;
    @javafx.fxml.FXML
    private TableColumn<ShipmentDelays, String> currentStatusCol;
    @javafx.fxml.FXML
    private TableColumn<ShipmentDelays, LocalDate> updatedDeliveryCol;
    @javafx.fxml.FXML
    private TextField delayCauseTextField;
    @javafx.fxml.FXML
    private TextField currentStatusTextField;
    @javafx.fxml.FXML
    private DatePicker updatedDeliveryDatePicker;
    @javafx.fxml.FXML
    private TableColumn<ShipmentDelays, String> delayCauseCol;
    @javafx.fxml.FXML
    private TextField estimatedDelayDurationTextField;
    @javafx.fxml.FXML
    private TableView<ShipmentDelays> shipmentDelaysTableView;

    private ObservableList<ShipmentDelays> shipmentDelaysObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        shipmentDelaysObservableList = FXCollections.observableArrayList();
        shipmentDelaysTableView.setItems(shipmentDelaysObservableList);

        shipmentIdCol.setCellValueFactory(new PropertyValueFactory<ShipmentDelays, String>("shipmentId"));
        currentStatusCol.setCellValueFactory(new PropertyValueFactory<ShipmentDelays, String>("currentStatus"));
        delayCauseCol.setCellValueFactory(new PropertyValueFactory<ShipmentDelays, String>("delayCause"));
        estimatedDelayCol.setCellValueFactory(new PropertyValueFactory<ShipmentDelays, Integer>("estimatedDelayDuration"));
        updatedDeliveryCol.setCellValueFactory(new PropertyValueFactory<ShipmentDelays, LocalDate>("updatedDeliveryDate"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            File f = new File("ShipmentDelays.bin");
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

            oos.writeObject(new ShipmentDelays(shipmentIdTextField.getText(), currentStatusTextField.getText(),
                    delayCauseTextField.getText(), Integer.parseInt(estimatedDelayDurationTextField.getText()),
                    updatedDeliveryDatePicker.getValue()));

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Shipment delay details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("ShipmentDelays.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'ShipmentDelays.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                shipmentDelaysTableView.getItems().add(
                        (ShipmentDelays) ois.readObject());
            }
        }
        catch(Exception e){
            try {
                if (ois != null) ois.close();
            }
            catch(Exception e2){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("File Not Found");
                alert.setHeaderText(null);
                alert.setContentText("The file 'ShipmentDelays.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }
}