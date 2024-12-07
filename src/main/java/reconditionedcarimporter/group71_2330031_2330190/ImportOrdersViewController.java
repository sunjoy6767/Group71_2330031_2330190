package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ImportOrdersViewController
{
    @javafx.fxml.FXML
    private TextField carBrandTextField;
    @javafx.fxml.FXML
    private DatePicker expectedShipmentDatePicker;
    @javafx.fxml.FXML
    private TextField supplierNameTextField;
    @javafx.fxml.FXML
    private TextField carModelTextField;
    @javafx.fxml.FXML
    private TextField supplierIDTextfield;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TableColumn expectedShipmentCol;
    @javafx.fxml.FXML
    private TableColumn brandCol;
    @javafx.fxml.FXML
    private TableColumn quantityCol;
    @javafx.fxml.FXML
    private TableColumn modelCol;
    @javafx.fxml.FXML
    private TableColumn supplierIdCol;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showDetailsOfCarsImportInTheTableButtonOnAction(ActionEvent actionEvent) {
    }
}