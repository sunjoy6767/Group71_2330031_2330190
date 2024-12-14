package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class LoyaltyProgramViewController
{
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TextField eligibilotyCriteriaTextField;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, String> programIdCol;
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, String> rewardsCol;
    @javafx.fxml.FXML
    private TextField programNameTextField;
    @javafx.fxml.FXML
    private TextField programIdTextField;
    @javafx.fxml.FXML
    private TextField rewardsTextField;
    @javafx.fxml.FXML
    private TextField minimumSpendTextField;
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, String> criteriaCol;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, Double> spendCol;
    @javafx.fxml.FXML
    private TextField statusTextField;
    @javafx.fxml.FXML
    private TableColumn<LoyaltyProgram, String> programNameCol;

    private ObservableList<LoyaltyProgram> loyaltyProgramsList;
    @javafx.fxml.FXML
    private TableView<LoyaltyProgram> loyaltyProgramTableView;

    @javafx.fxml.FXML
    public void initialize() {
        loyaltyProgramsList = FXCollections.observableArrayList();
        loyaltyProgramTableView.setItems(loyaltyProgramsList);

        programNameCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, String>("programName"));
        programIdCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, String>("programId"));
        rewardsCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, String>("rewards"));
        criteriaCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, String>("eligibilityCriteria"));
        statusCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, String>("programStatus"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, LocalDate>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, LocalDate>("endDate"));
        spendCol.setCellValueFactory(new PropertyValueFactory<LoyaltyProgram, Double>("minimumSpend"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            if (programNameTextField.getText().isEmpty() || programIdTextField.getText().isEmpty() ||
                    rewardsTextField.getText().isEmpty() || eligibilotyCriteriaTextField.getText().isEmpty() ||
                    statusTextField.getText().isEmpty() || startDatePicker.getValue() == null ||
                    endDatePicker.getValue() == null || minimumSpendTextField.getText().isEmpty())
            {
                showAlert("All fields must be filled in.");
                return;
            }

            try {
                Double.parseDouble(minimumSpendTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Minimum Spend must be a valid number.");
                return;
            }

            LocalDate date0 = startDatePicker.getValue();
            if (date0 == null) {
                showAlert("Please select a valid program date.");
                return;
            }
            if (date0.isBefore(LocalDate.now())) {
                showAlert("Program date cannot be in the past.");
                return;
            }


            LocalDate date1 = endDatePicker.getValue();
            if (date1 == null) {
                showAlert("Please select a valid program date.");
                return;
            }
            if (date1.isBefore(LocalDate.now())) {
                showAlert("Program date cannot be in the past.");
                return;
            }

            File f = new File("LoyaltyProgram.bin");
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

            oos.writeObject(new LoyaltyProgram(programNameTextField.getText(), programIdTextField.getText(),
                    rewardsTextField.getText(), eligibilotyCriteriaTextField.getText(),
                    statusTextField.getText(), startDatePicker.getValue(),
                    endDatePicker.getValue(), Double.parseDouble(minimumSpendTextField.getText())));

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Loyalty Program details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the LoyaltyProgram.bin file.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void goBackToMarketingManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("LoyaltyProgram.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'LoyaltyProgram.bin' does not exist.");
                alert.showAndWait();

            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                loyaltyProgramTableView.getItems().add(
                        (LoyaltyProgram) ois.readObject());
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
                alert.setContentText("The file 'LoyaltyProgram.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        loyaltyProgramsList.clear();


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