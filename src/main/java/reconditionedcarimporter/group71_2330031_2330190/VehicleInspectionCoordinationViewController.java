package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class VehicleInspectionCoordinationViewController
{
    @javafx.fxml.FXML
    private TableColumn<VehicleInspection, String> repairDetailsCol;
    @javafx.fxml.FXML
    private TextField repairsDetailsTextField;
    @javafx.fxml.FXML
    private ToggleGroup requiresRepairs;
    @javafx.fxml.FXML
    private TableColumn<VehicleInspection, Boolean> passedInspectionCol;
    @javafx.fxml.FXML
    private TableView<VehicleInspection> vehicleInspectionTableView;
    @javafx.fxml.FXML
    private TableColumn<VehicleInspection, String> statusCol;
    @javafx.fxml.FXML
    private DatePicker inspectionDatePicker;
    @javafx.fxml.FXML
    private TableColumn<VehicleInspection, LocalDate> inspectionDateCol;
    @javafx.fxml.FXML
    private TableColumn<VehicleInspection, Integer> carIdCol;
    @javafx.fxml.FXML
    private ToggleGroup passedInspection;
    @javafx.fxml.FXML
    private TextField carIdTextField;
    @javafx.fxml.FXML
    private TableColumn<VehicleInspection, Boolean> requiresRepairsCol;

    private ObservableList<VehicleInspection> vehicleInspections;
    @javafx.fxml.FXML
    private RadioButton yesRequiresRepairRadioButton;
    @javafx.fxml.FXML
    private RadioButton noRequiresRepairRadioButton;
    @javafx.fxml.FXML
    private RadioButton noPassedRadioButton;
    @javafx.fxml.FXML
    private RadioButton yesPassedRadioButton;
    @javafx.fxml.FXML
    private TextField statusTextField;

    @javafx.fxml.FXML
    public void initialize() {
        vehicleInspections = FXCollections.observableArrayList();
        vehicleInspectionTableView.setItems(vehicleInspections);

        carIdCol.setCellValueFactory(new PropertyValueFactory<VehicleInspection, Integer>("carId"));
        repairDetailsCol.setCellValueFactory(new PropertyValueFactory<VehicleInspection, String>("repairDetails"));
        statusCol.setCellValueFactory(new PropertyValueFactory<VehicleInspection, String>("status"));
        inspectionDateCol.setCellValueFactory(new PropertyValueFactory<VehicleInspection, LocalDate>("inspectionDate"));
        passedInspectionCol.setCellValueFactory(new PropertyValueFactory<VehicleInspection, Boolean>("passedInspection"));
        requiresRepairsCol.setCellValueFactory(new PropertyValueFactory<VehicleInspection, Boolean>("requiresRepairs"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        String requiresRepairsStatus = "";
        if (yesPassedRadioButton.isSelected()) {
            requiresRepairsStatus = "Yes";
        }
        else if (noPassedRadioButton.isSelected()) {
            requiresRepairsStatus = "No";
        }

        String passedInspectionStatus = "";
        if (yesRequiresRepairRadioButton.isSelected()) {
            passedInspectionStatus = "Yes";
        }
        else if (noRequiresRepairRadioButton.isSelected()) {
            passedInspectionStatus = "No";
        }

        try{
            File f = new File("VehicleInspection.bin");
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

            oos.writeObject(new VehicleInspection(
                    Integer.parseInt(carIdTextField.getText()),
                    inspectionDatePicker.getValue(),
                    passedInspectionStatus,
                    requiresRepairsStatus,
                    repairsDetailsTextField.getText(),
                    statusTextField.getText()
            ));

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Vehicle Inspection details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the VehicleInspection.bin file.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsInTheTableButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("VehicleInspection.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'VehicleInspection.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                vehicleInspectionTableView.getItems().add(
                        (VehicleInspection) ois.readObject());
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
                alert.setContentText("The file 'VehicleInspection.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }
}