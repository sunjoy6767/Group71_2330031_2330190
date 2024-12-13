package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomsClearanceViewController
{
    @javafx.fxml.FXML
    private DatePicker clearanceDatePicker;
    @javafx.fxml.FXML
    private TextField clearanceIdTextField;
    @javafx.fxml.FXML
    private TextField customsAgentNameTextField;
    @javafx.fxml.FXML
    private TableColumn<CustomsClearance, Double> customsDutyAmountCol;
    @javafx.fxml.FXML
    private TableColumn<CustomsClearance, LocalDate> clearanceDateCol;
    @javafx.fxml.FXML
    private TableColumn<CustomsClearance, String> customsAgentNameCol;
    @javafx.fxml.FXML
    private TableColumn<CustomsClearance, String> clearanceIdCol;
    @javafx.fxml.FXML
    private TableColumn<CustomsClearance, String> clearanceStatusCol;
    @javafx.fxml.FXML
    private TableColumn<CustomsClearance, String> dutyPaidStatusCol;

    @javafx.fxml.FXML
    private ToggleGroup clearanceStatusRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup dutyPaidStatusRadioButton;

    @FXML
    private RadioButton dutyStatusUnpaidRadioButton;
    @FXML
    private RadioButton pendingStatusRadioButton;
    @FXML
    private RadioButton clearedStatusRadioButton;
    @FXML
    private RadioButton dutyStatusPaidRadioButton;
    @FXML
    private TextField customsDutyAmountTextField;
    @FXML
    private TableView<CustomsClearance> customsClearanceTableView;

    private ObservableList<CustomsClearance> customsClearanceObservableList;

    @FXML
    public void initialize() {
        customsClearanceObservableList = FXCollections.observableArrayList();
        customsClearanceTableView.setItems(customsClearanceObservableList);

        clearanceIdCol.setCellValueFactory(new PropertyValueFactory<CustomsClearance, String>("clearanceId"));
        customsAgentNameCol.setCellValueFactory(new PropertyValueFactory<CustomsClearance, String>("customsAgentName"));
        customsDutyAmountCol.setCellValueFactory(new PropertyValueFactory<CustomsClearance, Double>("customsDutyAmount"));
        clearanceStatusCol.setCellValueFactory(new PropertyValueFactory<CustomsClearance, String>("clearanceStatus"));
        dutyPaidStatusCol.setCellValueFactory(new PropertyValueFactory<CustomsClearance, String>("customsDutyPaidStatus"));
        clearanceDateCol.setCellValueFactory(new PropertyValueFactory<CustomsClearance, LocalDate>("clearanceDate"));
    }

    @javafx.fxml.FXML
    public void ShowDetailsInTheTableButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
           File f = new File("CustomsClearance.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'CustomsClearance.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                customsClearanceTableView.getItems().add(
                        (CustomsClearance) ois.readObject());
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
                alert.setContentText("The file 'CustomsClearance.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void saveDetailsButtonOnAction(ActionEvent actionEvent) {
        String paidStatus = "";
        if (dutyStatusPaidRadioButton.isSelected()) {
            paidStatus = "Paid";
        }
        else if (dutyStatusUnpaidRadioButton.isSelected()) {
            paidStatus = "Unpaid";
        }

        String clearanceStatus = "";
        if (clearedStatusRadioButton.isSelected()) {
            clearanceStatus = "Clearance";
        }
        else if (pendingStatusRadioButton.isSelected()) {
            clearanceStatus = "Pending";
        }

        try{
            File f = new File("CustomsClearance.bin");
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

            oos.writeObject(new CustomsClearance(clearanceIdTextField.getText(), customsAgentNameTextField.getText(),
                    Double.parseDouble(customsDutyAmountTextField.getText()), clearanceStatus,
                    paidStatus, clearanceDatePicker.getValue()));

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Customs Clearance details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the CustomsClearance.bin file.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

}