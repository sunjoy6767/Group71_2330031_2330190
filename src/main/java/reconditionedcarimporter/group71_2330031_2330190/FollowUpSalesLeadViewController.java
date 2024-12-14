package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class FollowUpSalesLeadViewController
{
    @javafx.fxml.FXML
    private TextField leadNameTextField;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, String> leadIdCol;
    @javafx.fxml.FXML
    private TextField contactInfoTextField;
    @javafx.fxml.FXML
    private TextField followUpDetailsTextField;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, String> outcomeCol;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, String> verifiedCol;
    @javafx.fxml.FXML
    private TableView<FollowUpSalesLead> salesLeadTableView;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, String> leadNameCol;
    @javafx.fxml.FXML
    private DatePicker followUpDatePicker;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, String> leadStatusCol;
    @javafx.fxml.FXML
    private ComboBox<String> verifiedComboBox;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, String> contactInfoCol;
    @javafx.fxml.FXML
    private TextField leadStatusTextField;
    @javafx.fxml.FXML
    private TextField followUpOutcome;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, String> followUpDetails;
    @javafx.fxml.FXML
    private TableColumn<FollowUpSalesLead, LocalDate> followUpDateCol;
    @javafx.fxml.FXML
    private TextField leadIDTextField;

    private ObservableList<FollowUpSalesLead> followUpSalesLeadObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        followUpSalesLeadObservableList = FXCollections.observableArrayList();
        salesLeadTableView.setItems(followUpSalesLeadObservableList);

        verifiedComboBox.getItems().addAll("Yes", "No");

        leadIdCol.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, String>("leadId"));
        leadNameCol.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, String>("leadName"));
        leadStatusCol.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, String>("leadStatus"));
        contactInfoCol.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, String>("contactInfo"));
        followUpDetails.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, String>("followUpDetails"));
        followUpDateCol.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, LocalDate>("followUpDate"));
        outcomeCol.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, String>("followUpOutcome"));
        verifiedCol.setCellValueFactory(new PropertyValueFactory<FollowUpSalesLead, String>("ContactInfoVerified"));
    }

    @javafx.fxml.FXML
    public void clearTheTableButtonOnAction(ActionEvent actionEvent) {
        followUpSalesLeadObservableList.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void goBackToSalesRepresentativeButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            if (leadIDTextField.getText().isEmpty() || leadNameTextField.getText().isEmpty() ||
                    leadStatusTextField.getText().isEmpty() || contactInfoTextField.getText().isEmpty() ||
                    followUpDetailsTextField.getText().isEmpty() || followUpDatePicker.getValue() == null ||
                    followUpOutcome.getText().isEmpty() || contactInfoTextField.getText().isEmpty())
            {
                showAlert("All fields must be filled in.");
                return;
            }

            LocalDate followUpDate = followUpDatePicker.getValue();
            if (followUpDate == null) {
                showAlert("Please select a valid Follow Up date.");
                return;
            }
            if (followUpDate.isBefore(LocalDate.now())) {
                showAlert("Follow Up date cannot be in the past.");
                return;
            }

            File f = new File("FollowUpSalesLead.bin");
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



            oos.writeObject(new FollowUpSalesLead(
                    leadIDTextField.getText(),
                    leadNameTextField.getText(),
                    leadStatusTextField.getText(),
                    contactInfoTextField.getText(),
                    followUpDetailsTextField.getText(),
                    followUpDatePicker.getValue(),
                    followUpOutcome.getText(),
                    verifiedComboBox.getValue())
            );
            leadIDTextField.clear();
            leadNameTextField.clear();
            leadStatusTextField.clear();
            contactInfoTextField.clear();
            followUpDetailsTextField.clear();
            followUpOutcome.clear();
            verifiedComboBox.setValue(null);
            followUpDatePicker.setValue(null);

            oos.close();
        }
        catch(Exception e){
            //

        }
    }

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("FollowUpSalesLead.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'FollowUpSalesLead.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                salesLeadTableView.getItems().add(
                        (FollowUpSalesLead) ois.readObject()
                );
                FollowUpSalesLead lead = (FollowUpSalesLead) ois.readObject();
                followUpSalesLeadObservableList.add(lead);
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

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}