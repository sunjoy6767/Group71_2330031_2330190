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
    private TableColumn<ImportedCar, Integer> carIdCol;
    @javafx.fxml.FXML
    private TextField carIdTextField;

    private ArrayList<StorageAssignment> storageAssignments;
    @javafx.fxml.FXML
    private TextField overDueChargesTextField;
    @javafx.fxml.FXML
    private TableView<StorageAssignment> storageAssignmentTableView;

    @javafx.fxml.FXML
    public void initialize() {
        storageAssignments = new ArrayList<StorageAssignment>();

        assignmentIdCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, String>("assignmentId"));
        carIdCol.setCellValueFactory(new PropertyValueFactory<ImportedCar, Integer>("carId"));
        storageUnitNumberCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, String>("storageUnitNumber"));
        assignedDateCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, LocalDate>("assignedDate"));
        releasedDateCol.setCellValueFactory(new PropertyValueFactory<StorageAssignment, LocalDate>("releasedDate"));
    }

    @javafx.fxml.FXML
    public void showDetailsButtonOnAction(ActionEvent actionEvent) {
        for (StorageAssignment s : storageAssignments) {
            storageAssignmentTableView.getItems().add(s);
        }
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        StorageAssignment storageAssignment = new StorageAssignment(
                assignmentIdTextField.getText(),
                storageLocationTextField.getText(),
                storageUnitNumberTextField.getText(),
                assignedDatePicker.getValue(),
                releaseDatePicker.getValue(),
                Double.parseDouble(storageCostTextField.getText()),
                Double.parseDouble(overDueChargesTextField.getText()),
                Integer.parseInt(carIdTextField.getText())
        );
        storageAssignments.add(storageAssignment);
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }
}