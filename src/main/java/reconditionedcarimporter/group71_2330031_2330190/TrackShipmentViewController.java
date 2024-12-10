package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
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

    private ArrayList<TrackShipment> trackShipments;
    @javafx.fxml.FXML
    private TableView<TrackShipment> trackShipmentTableView;

    @javafx.fxml.FXML
    public void initialize() {
        trackShipments = new ArrayList<>();

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
        for (TrackShipment trackShipment : trackShipments) {
            trackShipmentTableView.getItems().add(trackShipment);
        }
    }

    @javafx.fxml.FXML
    public void saveTheShipmentDetailsButtonOnAction(ActionEvent actionEvent) {
        TrackShipment ts = new TrackShipment(
                shipmentIdTextField.getText(),
                shippingCompanyTextField.getText(),
                destinationTextField.getText(),
                supplierIdTextField.getText(),
                deliveryDatePicker.getValue(),
                departureDatePicker.getValue()
        );
        trackShipments.add(ts);
    }
}