package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class ShippingCostCalculationViewController
{
    @javafx.fxml.FXML
    private TextField distanceTextField;
    @javafx.fxml.FXML
    private TextField shipmentIdTextField;
    @javafx.fxml.FXML
    private TableColumn<ShippingCalculationDummy, String> transportModeCol;
    @javafx.fxml.FXML
    private TableColumn<ShippingCalculationDummy, String> shipmentIdCol;
    @javafx.fxml.FXML
    private TextField insuranceCostTextField;
    @javafx.fxml.FXML
    private TableView<ShippingCalculationDummy> shippingCostTableView;
    @javafx.fxml.FXML
    private ComboBox<String> transportModeComboBox;
    @javafx.fxml.FXML
    private TableColumn<ShippingCalculationDummy, Double> totalShippingCostCol;
    @javafx.fxml.FXML
    private TextField taxesAndDutiesTextField;
    @javafx.fxml.FXML
    private TextField handleChargesTextField;
    @javafx.fxml.FXML
    private TableColumn<ShippingCalculationDummy, Integer> carIdCol;
    @javafx.fxml.FXML
    private TableColumn<ShippingCalculationDummy, String> calculationIdCol;
    @javafx.fxml.FXML
    private TextField calculationIdTextField;
    @javafx.fxml.FXML
    private TextField carIdTextField;

    private ObservableList<ShippingCalculationDummy> shippingCalculationDummyList;

    @javafx.fxml.FXML
    public void initialize() {
        shippingCalculationDummyList = FXCollections.observableArrayList();
        shippingCostTableView.setItems(shippingCalculationDummyList);

        transportModeComboBox.getItems().addAll("Sea", "Road", "Air");

        calculationIdCol.setCellValueFactory(new PropertyValueFactory<ShippingCalculationDummy, String>("calculationId"));
        shipmentIdCol.setCellValueFactory(new PropertyValueFactory<ShippingCalculationDummy, String>("shipmentId"));
        carIdCol.setCellValueFactory(new PropertyValueFactory<ShippingCalculationDummy, Integer>("carId"));
        transportModeCol.setCellValueFactory(new PropertyValueFactory<ShippingCalculationDummy, String>("transportMode"));
        totalShippingCostCol.setCellValueFactory(new PropertyValueFactory<ShippingCalculationDummy, Double>("totalShippingCost"));
    }


    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            if (shipmentIdTextField.getText().isEmpty() || shipmentIdTextField.getText().isEmpty() ||
                    transportModeComboBox.getValue().isEmpty() || insuranceCostTextField.getText().isEmpty() ||
                    taxesAndDutiesTextField.getText().isEmpty() || handleChargesTextField.getText().isEmpty() ||
                    distanceTextField.getText().isEmpty() || carIdTextField.getText().isEmpty())
            {
                showAlert("All fields must be filled in.");
                return;
            }

            try {
                Integer.parseInt(distanceTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Distance must be a valid number.");
                return;
            }
            try {
                Integer.parseInt(carIdTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Car ID must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(insuranceCostTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Insurance Cost must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(handleChargesTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Handling Charges must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(taxesAndDutiesTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Taxes and Duties must be a valid number.");
                return;
            }


            File f = new File("ShippingCostCalculation.bin");
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

            String calculationId = calculationIdTextField.getText();
            String shipmentId = shipmentIdTextField.getText();
            String transportMode = transportModeComboBox.getValue();
            double insuranceCost = Double.parseDouble(insuranceCostTextField.getText());
            double taxesAndDuties = Double.parseDouble(taxesAndDutiesTextField.getText());
            double handleCharges = Double.parseDouble(handleChargesTextField.getText());
            int distance = Integer.parseInt(distanceTextField.getText());
            double totalShippingCost = calculateTotalCost((int) distance, insuranceCost, taxesAndDuties, handleCharges);
            int carId = Integer.parseInt(carIdTextField.getText());


            oos.writeObject(new ShippingCalculationDummy(
                    calculationId, shipmentId, transportMode,insuranceCost,taxesAndDuties,handleCharges, totalShippingCost, carId, distance
            ));


            oos.close();
        }
        catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid numeric values.");
                alert.showAndWait();
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    private double calculateTotalCost(int distance, double insuranceCost, double taxesAndDuties, double handleCharges) {
        double totalShippingCost = distance * 0.01 + insuranceCost + taxesAndDuties + handleCharges;
        return totalShippingCost;
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        shippingCalculationDummyList.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("ShippingCostCalculation.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'ShippingCostCalculation.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                shippingCostTableView.getItems().add(
                        (ShippingCalculationDummy) ois.readObject()
                );
                ShippingCalculationDummy scd = (ShippingCalculationDummy) ois.readObject();
                shippingCalculationDummyList.add(scd);
            }
//         ois.close();
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

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}