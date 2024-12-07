package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
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
    private TableColumn<ImportedCar, String> supplierIdCol;
    @javafx.fxml.FXML
    private TextField carQuantityTextField;

    private ArrayList<ImportedCar> carsList;

    @javafx.fxml.FXML
    public void initialize() {
        carsList = new ArrayList<ImportedCar>();

        modelCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, String>("model"));
        supplierIdCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, String>("supplierID"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, Integer>("quantity"));
        brandCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, String>("brand"));
        expectedShipmentCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, LocalDate>("expectedShipmentDate"));
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showDetailsOfCarsImportInTheTableButtonOnAction(ActionEvent actionEvent) {
        String str = "";
        for (ImportedCar car : carsList) {
            str += car.toString() + "\n";
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