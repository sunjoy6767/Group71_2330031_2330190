package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class BudgetManagementViewController
{
    @javafx.fxml.FXML
    private TableColumn<BudgetManagement, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TextField emailBudgetTextField;
    @javafx.fxml.FXML
    private TextField campaignIDTextField;
    @javafx.fxml.FXML
    private TextField socialMediaBudgetTextField;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TextField totalSpendingTextField;
    @javafx.fxml.FXML
    private TableColumn<BudgetManagement, Double> totalSpendingCol;
    @javafx.fxml.FXML
    private TableView<BudgetManagement> budgetManagementTableView;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<BudgetManagement, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn<BudgetManagement, String> campaignIDCol;
    @javafx.fxml.FXML
    private TextField semBudgetTextField;
    @javafx.fxml.FXML
    private Label totalBudgetLabel;

    private ObservableList<BudgetManagement> budgetManagementList;
    @javafx.fxml.FXML
    private Label budgetStatusLabel;

    private double totalB;
    private String str;

    @javafx.fxml.FXML
    public void initialize() {
        budgetManagementList = FXCollections.observableArrayList();
        budgetManagementTableView.setItems(budgetManagementList);

        campaignIDCol.setCellValueFactory(new PropertyValueFactory<BudgetManagement, String>("campaignId"));
        totalSpendingCol.setCellValueFactory(new PropertyValueFactory<BudgetManagement, Double>("totalSpending"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<BudgetManagement, LocalDate>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<BudgetManagement, LocalDate>("endDate"));

    }


    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            if (campaignIDTextField.getText().isEmpty() || socialMediaBudgetTextField.getText().isEmpty() ||
                    startDatePicker.getValue() == null || semBudgetTextField.getText().isEmpty() ||
                    emailBudgetTextField.getText().isEmpty() || totalSpendingTextField.getText().isEmpty() ||
                    endDatePicker.getValue() == null)
            {
                showAlert("All fields must be filled in.");
                return;
            }

            try {
                Double.parseDouble(socialMediaBudgetTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Social Media Budget must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(semBudgetTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Search Engine Marketing Budget must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(totalSpendingTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Total Spending Budget must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(emailBudgetTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Email Budget must be a valid number.");
                return;
            }


            File f = new File("BudgetManagement.bin");
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

            String campaignID = campaignIDTextField.getText();
            double socialMedia = Double.parseDouble(socialMediaBudgetTextField.getText());
            double emMarketingBudget = Double.parseDouble(emailBudgetTextField.getText());
            double totalSpent = Double.parseDouble(totalSpendingTextField.getText());
            double sem = Double.parseDouble(semBudgetTextField.getText());
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();
            totalB = totalBudget(socialMedia,emMarketingBudget, sem);

            double var = totalB - totalSpent;
            if (var<0){
                str = "Budget is exceeded!";
            }
            else {
                str = "Budget is valid";
            }


            oos.writeObject(new BudgetManagement(
                    campaignID, totalSpent, startDate, endDate, socialMedia, sem, emMarketingBudget
            ));


            totalBudgetLabel.setText(Double.toString(totalB));
            budgetStatusLabel.setText(str);

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
    public void goBackToMarketingManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("BudgetManagement.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'BudgetManagement.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                budgetManagementTableView.getItems().add(
                        (BudgetManagement) ois.readObject()
                );
                BudgetManagement bm = (BudgetManagement) ois.readObject();
                budgetManagementList.add(bm);
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

    private double totalBudget(double socialMediaBudget, double emailMarketingBudget, double semBudget) {
        double tb = socialMediaBudget + emailMarketingBudget + semBudget;
        return tb;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void clearTheDetailsButtonOnAction(ActionEvent actionEvent) {
        budgetManagementList.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }
}