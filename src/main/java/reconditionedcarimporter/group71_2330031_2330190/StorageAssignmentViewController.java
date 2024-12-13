package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class StorageAssignmentViewController
{
    @javafx.fxml.FXML
    private TableColumn<StorageDummy, LocalDate> assignedDateCol;
    @javafx.fxml.FXML
    private TextField storageCostTextField;
    @javafx.fxml.FXML
    private TableColumn<StorageDummy, String> assignmentIdCol;
    @javafx.fxml.FXML
    private TextField assignmentIdTextField;
    @javafx.fxml.FXML
    private TextField storageUnitNumberTextField;
    @javafx.fxml.FXML
    private TextField storageLocationTextField;
    @javafx.fxml.FXML
    private DatePicker releaseDatePicker;
    @javafx.fxml.FXML
    private TableColumn<StorageDummy, String> storageUnitNumberCol;
    @javafx.fxml.FXML
    private TableColumn<StorageDummy, LocalDate> releasedDateCol;
    @javafx.fxml.FXML
    private DatePicker assignedDatePicker;
    @javafx.fxml.FXML
    private TableColumn<StorageDummy, Integer> carIdCol;
    @javafx.fxml.FXML
    private TextField carIdTextField;

    @javafx.fxml.FXML
    private TextField overDueChargesTextField;
    @javafx.fxml.FXML
    private TableView<StorageDummy> storageAssignmentTableView;

    private ObservableList<StorageDummy> storageDummyObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        storageDummyObservableList = FXCollections.observableArrayList();
        storageAssignmentTableView.setItems(storageDummyObservableList);

        assignmentIdCol.setCellValueFactory(new PropertyValueFactory<StorageDummy, String>("storageAssignmentId"));
        carIdCol.setCellValueFactory(new PropertyValueFactory<StorageDummy, Integer>("carId"));
        storageUnitNumberCol.setCellValueFactory(new PropertyValueFactory<StorageDummy, String>("storageUnitNumber"));
        assignedDateCol.setCellValueFactory(new PropertyValueFactory<StorageDummy, LocalDate>("assignedDate"));
        releasedDateCol.setCellValueFactory(new PropertyValueFactory<StorageDummy, LocalDate>("releasedDate"));
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

            storageDummyObservableList.clear();

            while(true) {
                storageAssignmentTableView.getItems().add(
                        (StorageDummy) ois.readObject()
                );
                StorageDummy sd = (StorageDummy) ois.readObject();
                storageDummyObservableList.add(sd);
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
                alert.setContentText("The file 'StorageAssignment.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
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

            oos.writeObject(new StorageDummy(assignmentIdTextField.getText(), storageLocationTextField.getText(),
                    storageUnitNumberTextField.getText(), assignedDatePicker.getValue(),
                    releaseDatePicker.getValue(), Double.parseDouble(storageCostTextField.getText()),
                    Double.parseDouble(overDueChargesTextField.getText()),
                    Integer.parseInt(carIdTextField.getText())));

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
}