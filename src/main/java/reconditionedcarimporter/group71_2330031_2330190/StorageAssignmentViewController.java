package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class StorageAssignmentViewController
{
    @javafx.fxml.FXML
    private TableColumn<StorageAssignment, LocalDate> assignedDateCol;
    @javafx.fxml.FXML
    private TextField storageCostTextField;
    @javafx.fxml.FXML
    private TableColumn<StorageAssignment, String> assignmentIdCol;
    @javafx.fxml.FXML
    private TextField assignmentIdTextField;
    @javafx.fxml.FXML
    private TextField storageUnitNumberTextField;
    @javafx.fxml.FXML
    private TextField storageLocationTextField;
    @javafx.fxml.FXML
    private DatePicker releaseDatePicker;
    @javafx.fxml.FXML
    private TableColumn<StorageAssignment, String> storageUnitNumberCol;
    @javafx.fxml.FXML
    private TableColumn<StorageAssignment, LocalDate> releasedDateCol;
    @javafx.fxml.FXML
    private DatePicker assignedDatePicker;
    @javafx.fxml.FXML
    private TableColumn<StorageAssignment, Integer> carIdCol;
    @javafx.fxml.FXML
    private TextField carIdTextField;

    @javafx.fxml.FXML
    private TextField overDueChargesTextField;
    @javafx.fxml.FXML
    private TableView<StorageAssignment> storageAssignmentTableView;

    private ObservableList<StorageAssignment> StorageAssignmentObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        StorageAssignmentObservableList = FXCollections.observableArrayList();
        storageAssignmentTableView.setItems(StorageAssignmentObservableList);

        assignmentIdCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, String>("storageAssignmentId"));
        carIdCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, Integer>("carId"));
        storageUnitNumberCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, String>("storageUnitNumber"));
        assignedDateCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, LocalDate>("assignedDate"));
        releasedDateCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, LocalDate>("releaseDate"));
    }

    @javafx.fxml.FXML
    public void showDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("StorageAssignment.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'StorageAssignment.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                storageAssignmentTableView.getItems().add(
                        (StorageAssignment) ois.readObject()
                );
                StorageAssignment sa = (StorageAssignment) ois.readObject();
                StorageAssignmentObservableList.add(sa);
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

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            if (assignmentIdTextField.getText().isEmpty() || storageLocationTextField.getText().isEmpty() ||
                    storageUnitNumberTextField.getText().isEmpty() || assignedDatePicker.getValue() == null ||
                    releaseDatePicker.getValue() == null || storageCostTextField.getText().isEmpty() ||
                    overDueChargesTextField.getText().isEmpty() || carIdTextField.getText() == null) {

                showAlert("All fields must be filled in.");
                return;

            }

            try {
                Integer.parseInt(carIdTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Car ID must be a valid number.");
                return;
            }

            try {
                Double.parseDouble(storageCostTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Storage Cost must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(overDueChargesTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Over Due Charges must be a valid number.");
                return;
            }

            File f = new File("StorageAssignment.bin");
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

            oos.writeObject(new StorageAssignment(assignmentIdTextField.getText(),
                    storageLocationTextField.getText(),
                    storageUnitNumberTextField.getText(),
                    assignedDatePicker.getValue(),
                    releaseDatePicker.getValue(),
                    Double.parseDouble(storageCostTextField.getText()),
                    Double.parseDouble(overDueChargesTextField.getText()),
                    Integer.parseInt(carIdTextField.getText())
                    )
            );

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Storage Assignment details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the StorageAssignment.bin file.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        StorageAssignmentObservableList.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}