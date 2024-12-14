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

public class BrandReputationViewController
{
    @javafx.fxml.FXML
    private TextField negativeMentionsTextField;
    @javafx.fxml.FXML
    private TableColumn<BrandReputation, Integer> positiveMentionsCol;
    @javafx.fxml.FXML
    private TableColumn<BrandReputation, String> campaignIdCol;
    @javafx.fxml.FXML
    private TableColumn<BrandReputation, String> summaryCol;
    @javafx.fxml.FXML
    private TableColumn<BrandReputation, String> improvementAreasCol;
    @javafx.fxml.FXML
    private TableView<BrandReputation> brandReputationTableView;
    @javafx.fxml.FXML
    private TableColumn<BrandReputation, Integer> negativeMentionsCol;
    @javafx.fxml.FXML
    private TextField improvementAreasTextField;
    @javafx.fxml.FXML
    private TextField campaignIdTextField;
    @javafx.fxml.FXML
    private TextField platformTextField;
    @javafx.fxml.FXML
    private TableColumn<BrandReputation, String> platformCol;
    @javafx.fxml.FXML
    private TextField positiveMentionsTextField;
    @javafx.fxml.FXML
    private TextField feedbackSummary;

    private ObservableList<BrandReputation> brandReputationObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        brandReputationObservableList = FXCollections.observableArrayList();
        brandReputationTableView.setItems(brandReputationObservableList);

        campaignIdCol.setCellValueFactory(new PropertyValueFactory<BrandReputation, String>("campaignId"));
        platformCol.setCellValueFactory(new PropertyValueFactory<BrandReputation, String>("platform"));
        summaryCol.setCellValueFactory(new PropertyValueFactory<BrandReputation, String>("feedbackSummary"));
        improvementAreasCol.setCellValueFactory(new PropertyValueFactory<BrandReputation, String>("improvementAreas"));
        negativeMentionsCol.setCellValueFactory(new PropertyValueFactory<BrandReputation, Integer>("negativeMentions"));
        positiveMentionsCol.setCellValueFactory(new PropertyValueFactory<BrandReputation, Integer>("positiveMentions"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
            try{
                if (campaignIdTextField.getText().isEmpty() || platformTextField.getText().isEmpty() ||
                        feedbackSummary.getText().isEmpty() || improvementAreasTextField.getText().isEmpty() ||
                        positiveMentionsTextField.getText().isEmpty() || negativeMentionsTextField.getText().isEmpty())
                        {
                    showAlert("All fields must be filled in.");
                    return;
                }

                try {
                    Integer.parseInt(negativeMentionsTextField.getText());
                } catch (NumberFormatException e) {
                    showAlert("Negative Mentions ID must be a valid number.");
                    return;
                }

                try {
                    Integer.parseInt(positiveMentionsTextField.getText());
                } catch (NumberFormatException e) {
                    showAlert("Positive Mentions must be a valid number.");
                    return;
                }

            File f = new File("BrandReputation.bin");
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

            oos.writeObject(new BrandReputation(
                    campaignIdTextField.getText(),
                    platformTextField.getText(),
                    feedbackSummary.getText(),
                    improvementAreasTextField.getText(),
                    totalMentions(Integer.parseInt(positiveMentionsTextField.getText()),
                            Integer.parseInt(negativeMentionsTextField.getText())),
                    Integer.parseInt(negativeMentionsTextField.getText()),
                    Integer.parseInt(positiveMentionsTextField.getText())
            ));

            oos.close();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the BrandReputation.bin file.");
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
            File f = new File("BrandReputation.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'BrandReputation.bin' does not exist.");
                alert.showAndWait();

            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                brandReputationTableView.getItems().add(
                        (BrandReputation) ois.readObject());
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
                alert.setContentText("The file 'BrandReputation.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void showTotalMentionsButtonOnAction(ActionEvent actionEvent) {
        int positiveMentions = Integer.parseInt(positiveMentionsTextField.getText());
        int negativeMentions = Integer.parseInt(negativeMentionsTextField.getText());

        int totalMentions = positiveMentions + negativeMentions;
        String str = Integer.toString(totalMentions);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Total Mentions");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }

    private int totalMentions(int positiveMentions, int negativeMentions) {
        return positiveMentions + negativeMentions;
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        brandReputationObservableList.clear();


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