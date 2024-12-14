package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
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
    private TableColumn<DummyImportOrders, LocalDate> expectedShipmentCol;
    @javafx.fxml.FXML
    private TableColumn<DummyImportOrders, String> brandCol;
    @javafx.fxml.FXML
    private TableColumn<DummyImportOrders, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<DummyImportOrders, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<DummyImportOrders, String> supplierIdCol;
    @javafx.fxml.FXML
    private TextField carQuantityTextField;

    private ObservableList<DummyImportOrders> carsList;
    @javafx.fxml.FXML
    private TableView<DummyImportOrders> importOrdersTableView;

    @javafx.fxml.FXML
    public void initialize() {
        carsList = FXCollections.observableArrayList();
        importOrdersTableView.setItems(carsList);

        modelCol.setCellValueFactory(new PropertyValueFactory<DummyImportOrders, String>("carModel"));
        supplierIdCol.setCellValueFactory(new PropertyValueFactory<DummyImportOrders, String>("supplierId"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<DummyImportOrders, Integer>("carQuantity"));
        brandCol.setCellValueFactory(new PropertyValueFactory<DummyImportOrders, String>("carBrand"));
        expectedShipmentCol.setCellValueFactory(new PropertyValueFactory<DummyImportOrders, LocalDate>("expectedShipmentDate"));
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showDetailsOfCarsImportInTheTableButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("ImportOrders.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'ImportOrders.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                importOrdersTableView.getItems().add(
                        (DummyImportOrders) ois.readObject());
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
                alert.setContentText("The file 'ImportOrders.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void saveAllTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            String carModel = carModelTextField.getText();
            String carBrand = carBrandTextField.getText();
            String supplierId = supplierIDTextfield.getText();
            Integer carQuantity = null;

            if (carModel.isEmpty()) {
                showErrorAlert("Car Model must be non-empty.");
                return;
            }

            if (supplierId.isEmpty()) {
                showErrorAlert("Supplier ID must be non-empty.");
                return;
            }

            LocalDate expectedShipmentDate = expectedShipmentDatePicker.getValue();
            if (expectedShipmentDate == null) {
                showErrorAlert("Please select a valid shipment date.");
                return;
            }
            if (expectedShipmentDate.isBefore(LocalDate.now())) {
                showErrorAlert("Shipment date cannot be in the past.");
                return;
            }

            try {
                carQuantity = Integer.parseInt(carQuantityTextField.getText());
                if (carQuantity <= 0) {
                    showErrorAlert("Car Quantity must be a positive integer.");
                    return;
                }
            } catch (NumberFormatException e) {
                showErrorAlert("Car Quantity must be a valid integer.");
                return;
            }


            File f = new File("ImportOrders.bin");
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

            oos.writeObject(new DummyImportOrders(carModelTextField.getText(), carBrandTextField.getText(),
                    supplierIDTextfield.getText(), Integer.parseInt(carQuantityTextField.getText()),
                    expectedShipmentDatePicker.getValue()));

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Import Orders details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the ImportOrders.bin file.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        carsList.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}