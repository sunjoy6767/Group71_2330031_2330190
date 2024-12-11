package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class ShippingCostCalculationViewController
{
    @javafx.fxml.FXML
    private TextField distanceTextField;
    @javafx.fxml.FXML
    private TextField shipmentIdTextField;
    @javafx.fxml.FXML
    private TableColumn<ShippingCostCalculation, String> transportModeCol;
    @javafx.fxml.FXML
    private TableColumn<TrackShipment, String> shipmentIdCol;
    @javafx.fxml.FXML
    private TextField insuranceCostTextField;
    @javafx.fxml.FXML
    private TableView<ShippingCostCalculation> shippingCostTableView;
    @javafx.fxml.FXML
    private ComboBox<String> transportModeComboBox;
    @javafx.fxml.FXML
    private TableColumn<ShippingCostCalculation, Double> totalShippingCostCol;
    @javafx.fxml.FXML
    private TextField taxesAndDutiesTextField;
    @javafx.fxml.FXML
    private TextField handleChargesTextField;
    @javafx.fxml.FXML
    private TableColumn<ImportedCar, Integer> carIdCol;
    @javafx.fxml.FXML
    private TableColumn<ShippingCostCalculation, String> calculationIdCol;
    @javafx.fxml.FXML
    private TextField calculationIdTextField;
    @javafx.fxml.FXML
    private TextField carIdTextField;

    private ArrayList<ShippingCostCalculation> shippingCostCalculations;

    @javafx.fxml.FXML
    public void initialize() {
        transportModeComboBox.getItems().addAll("Sea", "Land", "Air");

        calculationIdCol.setCellValueFactory(new PropertyValueFactory<ShippingCostCalculation, String>("calculationId"));
        shipmentIdCol.setCellValueFactory(new PropertyValueFactory<TrackShipment, String>("shipmentId"));
        carIdCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, Integer>("carId"));
        transportModeCol.setCellValueFactory(new PropertyValueFactory<ShippingCostCalculation, String>("transportMode"));
        totalShippingCostCol.setCellValueFactory(new PropertyValueFactory<ShippingCostCalculation, Double>("totalShippingCost"));
    }

    @javafx.fxml.FXML
    public void showDetailsInTableButtonOnAction(ActionEvent actionEvent) {
        for(ShippingCostCalculation shippingCostCalculation : shippingCostCalculations) {
            shippingCostTableView.getItems().add(shippingCostCalculation);
        }
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        ShippingCostCalculation scc = new ShippingCostCalculation(
                calculationIdTextField.getText(),
                shipmentIdTextField.getText(),
                transportModeComboBox.getValue(),
                Integer.parseInt(carIdTextField.getText()),
                Double.parseDouble(distanceTextField.getText()),
                Double.parseDouble(insuranceCostTextField.getText()),
                Double.parseDouble(taxesAndDutiesTextField.getText()),
                Double.parseDouble(handleChargesTextField.getText())
        );
        shippingCostCalculations.add(scc);
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }
}