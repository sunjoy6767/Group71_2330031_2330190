package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class CreateCampaignViewController
{
    @javafx.fxml.FXML
    private TextField campaignIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Campaign, LocalDate> startingDateCol;
    @javafx.fxml.FXML
    private TableColumn<Campaign, String> campaignNameCol;
    @javafx.fxml.FXML
    private TextField campaignNameTextField;
    @javafx.fxml.FXML
    private DatePicker startingDatePicker;
    @javafx.fxml.FXML
    private DatePicker endingDatePicker;
    @javafx.fxml.FXML
    private TextField campaignBudgetTextField;
    @javafx.fxml.FXML
    private TableColumn<Campaign, LocalDate> endingDateCol;
    @javafx.fxml.FXML
    private TableView<Campaign> campaignTableView;
    @javafx.fxml.FXML
    private TextField targetAudienceTextField;
    @javafx.fxml.FXML
    private TableColumn<Campaign, Integer> campaignBudgetCol;

    private ObservableList<Campaign> campaignObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        campaignObservableList = FXCollections.observableArrayList();
        campaignTableView.setItems(campaignObservableList);

        campaignNameCol.setCellValueFactory(new PropertyValueFactory<Campaign, String>("campaignName"));
        campaignBudgetCol.setCellValueFactory(new PropertyValueFactory<Campaign, Integer>("budget"));
        startingDateCol.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("startDate"));
        endingDateCol.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("endDate"));
    }

    @javafx.fxml.FXML
    public void showCampaignInTheTableButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("CreateCampaign.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'CreateCampaign.bin' does not exist.");
                alert.showAndWait();
                //Alert: file does not exist
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                campaignTableView.getItems().add(
                        (Campaign) ois.readObject());
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

    @javafx.fxml.FXML
    public void saveCampaignButtonOnAction(ActionEvent actionEvent) {
        try{
            File f = new File("CreateCampaign.bin");
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

            oos.writeObject(new Campaign(campaignNameTextField.getText(), campaignIdTextField.getText(),
                    targetAudienceTextField.getText(), Integer.parseInt(campaignBudgetTextField.getText()),
                    startingDatePicker.getValue(), endingDatePicker.getValue()));

            oos.close();
        }
        catch(Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void goBackToMarketingManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
    }
}