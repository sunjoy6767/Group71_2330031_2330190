package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ShippingCostCalculationViewController
{
    @javafx.fxml.FXML
    private TextField distanceTextField;
    @javafx.fxml.FXML
    private TextField shipmentIdTextField;
    @javafx.fxml.FXML
    private TableColumn transportModeCol;
    @javafx.fxml.FXML
    private TableColumn shipmentIdCol;
    @javafx.fxml.FXML
    private TextField insuranceCostTextField;
    @javafx.fxml.FXML
    private TableView shippingCostTableView;
    @javafx.fxml.FXML
    private ComboBox transportModeComboBox;
    @javafx.fxml.FXML
    private TableColumn totalShippingCostCol;
    @javafx.fxml.FXML
    private TextField taxesAndDutiesTextField;
    @javafx.fxml.FXML
    private TextField handleChargesTextField;
    @javafx.fxml.FXML
    private TableColumn carIdCol;
    @javafx.fxml.FXML
    private TableColumn calculationIdCol;
    @javafx.fxml.FXML
    private TextField calculationIdTextField;
    @javafx.fxml.FXML
    private TextField carIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showDetailsInTableButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }
}