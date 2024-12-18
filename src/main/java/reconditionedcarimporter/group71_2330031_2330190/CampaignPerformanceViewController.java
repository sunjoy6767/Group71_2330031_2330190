package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class CampaignPerformanceViewController
{
    @javafx.fxml.FXML
    private TextField conversionsTextField;
    @javafx.fxml.FXML
    private TableView<CampaignPerformance> campaignPerformanceTableView;
    @javafx.fxml.FXML
    private TableColumn<CampaignPerformance, Double> roiCol;
    @javafx.fxml.FXML
    private TextField clicksTextField;
    @javafx.fxml.FXML
    private TableColumn<CampaignPerformance, Integer> conversionsCol;
    @javafx.fxml.FXML
    private TableColumn<CampaignPerformance, String> summaryCol;
    @javafx.fxml.FXML
    private TextField campaignIdTextField;
    @javafx.fxml.FXML
    private TableColumn<CampaignPerformance, String> statusCol;
    @javafx.fxml.FXML
    private TextField campaignNameTextField;
    @javafx.fxml.FXML
    private TextField statusTextField;
    @javafx.fxml.FXML
    private TextField roiTextField;
    @javafx.fxml.FXML
    private TableColumn<CampaignPerformance, Integer> clicksCol;
    @javafx.fxml.FXML
    private TextField summaryTextField;
    @javafx.fxml.FXML
    private TableColumn<CampaignPerformance, String> campaignIdCol;

    private ObservableList<CampaignPerformance> campaignPerformanceList;

    @javafx.fxml.FXML
    public void initialize() {
        campaignPerformanceList = FXCollections.observableArrayList();
        campaignPerformanceTableView.setItems(campaignPerformanceList);

        campaignIdCol.setCellValueFactory(new PropertyValueFactory<CampaignPerformance, String>("campaignId") );
        statusCol.setCellValueFactory(new PropertyValueFactory<CampaignPerformance, String>("status"));
        summaryCol.setCellValueFactory(new PropertyValueFactory<CampaignPerformance, String>("performanceSummary"));
        clicksCol.setCellValueFactory(new PropertyValueFactory<CampaignPerformance, Integer>("clicks"));
        conversionsCol.setCellValueFactory(new PropertyValueFactory<CampaignPerformance, Integer>("conversions"));
        roiCol.setCellValueFactory(new PropertyValueFactory<CampaignPerformance, Double>("returnOnInvestment"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            if (campaignIdTextField.getText().isEmpty() || campaignNameTextField.getText().isEmpty() ||
                    statusTextField.getText().isEmpty() || summaryTextField.getText().isEmpty() ||
                    clicksTextField.getText().isEmpty() || conversionsTextField.getText().isEmpty() ||
                    roiTextField.getText().isEmpty())
            {
                showAlert("All fields must be filled in.");
                return;
            }

            try {
                Integer.parseInt(clicksTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Clicks must be a valid number.");
                return;
            }

            try {
                Integer.parseInt(conversionsTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Conversions must be a valid number.");
                return;
            }
            try {
                Double.parseDouble(roiTextField.getText());
            } catch (NumberFormatException e) {
                showAlert("Return on Investment must be a valid number.");
                return;
            }

            File f = new File("CampaignPerformance.bin");
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

            oos.writeObject(new CampaignPerformance(
                    campaignNameTextField.getText(),
                    campaignIdTextField.getText(),
                    statusTextField.getText(),
                    summaryTextField.getText(),
                    Integer.parseInt(clicksTextField.getText()),
                    Integer.parseInt(conversionsTextField.getText()),
                    Double.parseDouble(roiTextField.getText()))
            );

            oos.close();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numeric values for clicks, conversions, and ROI.");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the campaign performance");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void goBackToMarketingManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
    }


    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        campaignPerformanceList.clear();


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
            File f = new File("CampaignPerformance.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'CampaignPerformance.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                campaignPerformanceTableView.getItems().add(
                        (CampaignPerformance) ois.readObject()
                );
                CampaignPerformance cp = (CampaignPerformance) ois.readObject();
                campaignPerformanceList.add(cp);
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