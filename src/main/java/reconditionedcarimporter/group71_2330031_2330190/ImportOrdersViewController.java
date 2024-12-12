package reconditionedcarimporter.group71_2330031_2330190;

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
    private TableColumn<DummyOrders, LocalDate> expectedShipmentCol;
    @javafx.fxml.FXML
    private TableColumn<DummyOrders, String> brandCol;
    @javafx.fxml.FXML
    private TableColumn<DummyOrders, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<DummyOrders, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<DummyOrders, String> supplierIdCol;
    @javafx.fxml.FXML
    private TextField carQuantityTextField;

    private ArrayList<DummyOrders> carsList;
    @javafx.fxml.FXML
    private TableView<DummyOrders> importOrdersTableView;

    @javafx.fxml.FXML
    public void initialize() {
        carsList = new ArrayList<DummyOrders>();

        modelCol.setCellValueFactory(new PropertyValueFactory<DummyOrders, String>("carModel"));
        supplierIdCol.setCellValueFactory(new PropertyValueFactory<DummyOrders, String>("supplierId"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<DummyOrders, Integer>("carQuantity"));
        brandCol.setCellValueFactory(new PropertyValueFactory<DummyOrders, String>("carBrand"));
        expectedShipmentCol.setCellValueFactory(new PropertyValueFactory<DummyOrders, LocalDate>("expectedShipmentDate"));
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
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                importOrdersTableView.getItems().add(
                        (DummyOrders) ois.readObject());
            }
        }
        catch(Exception e){
            try {
                if (ois != null) ois.close();
            }
            catch(Exception e2){
                //
            }
        }
    }

    @javafx.fxml.FXML
    public void saveAllTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            File f = new File("ImportedCar.bin");
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

            oos.writeObject(new DummyOrders(carModelTextField.getText(), carBrandTextField.getText(),
                    supplierIDTextfield.getText(), Integer.parseInt(carQuantityTextField.getText()),
                    expectedShipmentDatePicker.getValue()));

            oos.close();
        }
        catch(Exception e){
            //
        }
    }
}