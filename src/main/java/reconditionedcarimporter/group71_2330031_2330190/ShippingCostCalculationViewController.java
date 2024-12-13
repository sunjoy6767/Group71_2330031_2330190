package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

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
    public void showDetailsInTableButtonOnAction(ActionEvent actionEvent) {
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
                        (ShippingCalculationDummy) ois.readObject());
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
                alert.setContentText("The file 'ShippingCostCalculation.bin' does not exist.");
                alert.showAndWait();
            }
        }

    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try {
            String calculationId = calculationIdTextField.getText();
            String shipmentId = shipmentIdTextField.getText();
            String transportMode = transportModeComboBox.getValue();
            double insuranceCost = Double.parseDouble(insuranceCostTextField.getText());
            double taxesAndDuties = Double.parseDouble(taxesAndDutiesTextField.getText());
            double handleCharges = Double.parseDouble(handleChargesTextField.getText());
            double distance = Integer.parseInt(distanceTextField.getText());
            double totalShippingCost = calculateTotalCost((int) distance, insuranceCost, taxesAndDuties, handleCharges);
            int carId = Integer.parseInt(carIdTextField.getText());

            ShippingCalculationDummy newCalculation = new ShippingCalculationDummy(
                    shipmentId, transportMode, carId, totalShippingCost, calculationId
            );
            shippingCalculationDummyList.add(newCalculation);
            shippingCostTableView.getItems().add(newCalculation);

            try (FileOutputStream fos = new FileOutputStream("ShippingCostCalculation.bin", true);
                 ObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {
                oos.writeObject(newCalculation);
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("File Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to save the ShippingCostCalculation.bin file.");
                alert.showAndWait();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Shipping calculation details saved successfully.");
            alert.showAndWait();
        }
        catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid numeric values.");
                alert.showAndWait();
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
}