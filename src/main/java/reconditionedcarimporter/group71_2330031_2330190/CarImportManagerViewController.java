package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;

import java.io.IOException;

public class CarImportManagerViewController {

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("Login-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void importOrdersButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("ImportOrders-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void trackShipmentButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("TrackShipment-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void customsClearanceButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CustomsClearance-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void shippingCostCalculationButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("ShippingCostCalculation-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void storageAssignmentButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("StorageAssignment-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void shipmentDelaysButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateCostReportButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("GenerateCostReport-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void vehicleInspectionCoordinationButtonOnAction(ActionEvent actionEvent) {
    }
}
