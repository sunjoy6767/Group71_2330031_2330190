package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ImportOrdersViewController
{
    @javafx.fxml.FXML
    private TextField carBrandTextField;
    @javafx.fxml.FXML
    private DatePicker expectedShipmentDatePicker;
    @javafx.fxml.FXML
    private TextField carModelTextField;
    @javafx.fxml.FXML
    private TextField supplierIDTextfield;
    @javafx.fxml.FXML
    private TableColumn<ImportedCar, LocalDate> expectedShipmentCol;
    @javafx.fxml.FXML
    private TableColumn<ImportedCar, String> brandCol;
    @javafx.fxml.FXML
    private TableColumn<ImportedCar, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<ImportedCar, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<Supplier, String> supplierIdCol;
    @javafx.fxml.FXML
    private TextField carQuantityTextField;

    private ArrayList<ImportedCar> carsList;
    @javafx.fxml.FXML
    private TableView<ImportedCar> importOrdersTableView;

    @javafx.fxml.FXML
    public void initialize() {
        carsList = new ArrayList<ImportedCar>();

        modelCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, String>("carModel"));
        supplierIdCol.setCellValueFactory(new PropertyValueFactory<Supplier, String>("supplierId"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, Integer>("carQuantity"));
        brandCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, String>("carBrand"));
        expectedShipmentCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, LocalDate>("expectedShipmentDate"));
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showDetailsOfCarsImportInTheTableButtonOnAction(ActionEvent actionEvent) {
        for (ImportedCar car : carsList) {
            importOrdersTableView.getItems().add(car);
        }
    }

    @javafx.fxml.FXML
    public void saveAllTheDetailsButtonOnAction(ActionEvent actionEvent) {
        ImportedCar car = new ImportedCar(
                carModelTextField.getText(),
                carBrandTextField.getText(),
                supplierIDTextfield.getText(),
                carQuantityTextField.getText(),
                expectedShipmentDatePicker.getValue()
        );
        carsList.add(car);
    }

}