package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrackShipmentViewController
{
    @javafx.fxml.FXML
    private TextField destinationTextField;
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private TextField shipmentIdTextField;
    @javafx.fxml.FXML
    private TableColumn<TrackShipment, LocalDate> departureDateCol;
    @javafx.fxml.FXML
    private TableColumn<TrackShipment, String> shipmentIdCol;
    @javafx.fxml.FXML
    private TextField supplierIdTextField;
    @javafx.fxml.FXML
    private TableColumn<TrackShipment, String> shippingCompanyCol;
    @javafx.fxml.FXML
    private DatePicker departureDatePicker;
    @javafx.fxml.FXML
    private TableColumn<TrackShipment, String> destinationCol;
    @javafx.fxml.FXML
    private TextField shippingCompanyTextField;
    @javafx.fxml.FXML
    private TableColumn<TrackShipment, LocalDate> deliveryDateCol;
    @javafx.fxml.FXML
    private TableColumn<Supplier, String> supplierIdCol;

    private ObservableList<TrackShipment> trackShipments;
    @javafx.fxml.FXML
    private TableView<TrackShipment> trackShipmentTableView;

    @javafx.fxml.FXML
    public void initialize() {
        trackShipments = FXCollections.observableArrayList();
        trackShipmentTableView.setItems(trackShipments);

        shipmentIdCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, String>("shipmentId"));
        supplierIdCol.setCellValueFactory(new PropertyValueFactory<Supplier, String>("supplierId"));
        shippingCompanyCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, String>("shippingCompany"));
        destinationCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, String>("destination"));
        departureDateCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, LocalDate>("departureDate"));
        deliveryDateCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, LocalDate>("deliveryDate"));
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsInTableButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("TrackShipment.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'TrackShipment.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            trackShipments.clear();

            while(true) {
                trackShipmentTableView.getItems().add(
                        (TrackShipment) ois.readObject()
                );
                TrackShipment ts = (TrackShipment) ois.readObject();
                trackShipments.add(ts);
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
                alert.setContentText("The file 'TrackShipment.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void saveTheShipmentDetailsButtonOnAction(ActionEvent actionEvent) {
        try {
            File f = new File("StorageAssignment.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                ;
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            TrackShipment ts = new TrackShipment(
                    shipmentIdTextField.getText(),
                    shippingCompanyTextField.getText(),
                    destinationTextField.getText(),
                    supplierIdTextField.getText(),
                    deliveryDatePicker.getValue(),
                    departureDatePicker.getValue()
            );
            trackShipments.add(ts);
            oos.writeObject(ts);
            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Track Shipment details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the TrackShipment.bin file.");
            alert.showAndWait();
        }
    }
}