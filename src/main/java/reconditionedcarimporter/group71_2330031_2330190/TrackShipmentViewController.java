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
    private TableColumn<TrackShipment, String> supplierIdCol;

    private ObservableList<TrackShipment> trackShipments;
    @javafx.fxml.FXML
    private TableView<TrackShipment> trackShipmentTableView;

    @javafx.fxml.FXML
    public void initialize() {
        trackShipments = FXCollections.observableArrayList();
        trackShipmentTableView.setItems(trackShipments);

        shipmentIdCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, String>("shipmentId"));
        supplierIdCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, String>("supplierId"));
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
                showErrorAlert("Error reading the shipment track details from the file.");
            }
        }
    }

    @javafx.fxml.FXML
    public void saveTheShipmentDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            if (shipmentIdTextField.getText().isEmpty() || shippingCompanyTextField.getText().isEmpty() ||
                    destinationTextField.getText().isEmpty() || supplierIdTextField.getText().isEmpty() ||
                    departureDatePicker.getValue() == null || deliveryDatePicker.getValue() == null)
            {
                showErrorAlert("All fields must be filled in.");
                return;
            }

            LocalDate departureDate = departureDatePicker.getValue();
            if (departureDate == null) {
                showErrorAlert("Please select a valid departure date.");
                return;
            }
            if (departureDate.isBefore(LocalDate.now())) {
                showErrorAlert("Departure date cannot be in the past.");
                return;
            }

            LocalDate deliveryDate = deliveryDatePicker.getValue();
            if (deliveryDate == null) {
                showErrorAlert("Please select a valid delivery date.");
                return;
            }
            if (deliveryDate.isBefore(departureDate)) {
                showErrorAlert("Delivery date cannot be earlier than departure date.");
                return;
            }

            File f = new File("TrackShipment.bin");
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

            oos.writeObject(new TrackShipment(
                    shipmentIdTextField.getText(),
                    shippingCompanyTextField.getText(),
                    destinationTextField.getText(),
                    supplierIdTextField.getText(),
                    departureDatePicker.getValue(),
                    deliveryDatePicker.getValue()
            ));
            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Shipment track details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            showErrorAlert("Failed to save the shipment track details.");
        }
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        trackShipments.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}