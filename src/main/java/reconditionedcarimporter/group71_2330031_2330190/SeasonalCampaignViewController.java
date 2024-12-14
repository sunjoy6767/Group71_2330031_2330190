package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class SeasonalCampaignViewController
{
    @javafx.fxml.FXML
    private TableColumn<SeasonalCampaign, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TableColumn<SeasonalCampaign, String> campaignIdCol;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TextField targetAudienceTextField;
    @javafx.fxml.FXML
    private TextField dataSummaryTextField;
    @javafx.fxml.FXML
    private TextField forecastedRevenueTextField;
    @javafx.fxml.FXML
    private TableColumn<SeasonalCampaign, Double> revenueCol;
    @javafx.fxml.FXML
    private TextField campaignIdTextField;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<SeasonalCampaign, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn<SeasonalCampaign, String> campaignThemeCol;
    @javafx.fxml.FXML
    private TableColumn<SeasonalCampaign, String> dataSummaryCol;
    @javafx.fxml.FXML
    private TextField campaignThemeTextField;
    @javafx.fxml.FXML
    private TableView<SeasonalCampaign> seasonalCampaignTableView;

    private ObservableList<SeasonalCampaign> seasonalCampaignObservableList;
    @javafx.fxml.FXML
    private TableColumn<SeasonalCampaign, String> audienceCol;

    @javafx.fxml.FXML
    public void initialize() {
        seasonalCampaignObservableList = FXCollections.observableArrayList();
        seasonalCampaignTableView.setItems(seasonalCampaignObservableList);

        campaignIdCol.setCellValueFactory(new PropertyValueFactory<SeasonalCampaign, String>("campaignId"));
        campaignThemeCol.setCellValueFactory(new PropertyValueFactory<SeasonalCampaign, String>("campaignTheme"));
        audienceCol.setCellValueFactory(new PropertyValueFactory<SeasonalCampaign, String>("TargetAudience"));
        dataSummaryCol.setCellValueFactory(new PropertyValueFactory<SeasonalCampaign, String>("historicalDataSummary"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<SeasonalCampaign, LocalDate>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<SeasonalCampaign, LocalDate>("endDate"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<SeasonalCampaign, Double>("forecastedRevenue"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try{
            File f = new File("SeasonalCampaign.bin");
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

            oos.writeObject(new SeasonalCampaign(
                    campaignIdTextField.getText(),
                    campaignThemeTextField.getText(),
                    targetAudienceTextField.getText(),
                    dataSummaryTextField.getText(),
                    startDatePicker.getValue(),
                    endDatePicker.getValue(),
                    Double.parseDouble(forecastedRevenueTextField.getText()
                    ))
            );

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

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("SeasonalCampaign.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'SeasonalCampaign.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                seasonalCampaignTableView.getItems().add(
                        (SeasonalCampaign) ois.readObject()
                );
                SeasonalCampaign sc = (SeasonalCampaign) ois.readObject();
                seasonalCampaignObservableList.add(sc);
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
}