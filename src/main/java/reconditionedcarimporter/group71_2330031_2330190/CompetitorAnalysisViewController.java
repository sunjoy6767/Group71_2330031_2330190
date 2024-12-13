package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class CompetitorAnalysisViewController
{
    @javafx.fxml.FXML
    private TableColumn<CompetitorAnalysis, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TextField advertisingChannelTextField;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CompetitorAnalysis, String> keyInsightsCol;
    @javafx.fxml.FXML
    private TableColumn<CompetitorAnalysis, String> compNameCol;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CompetitorAnalysis, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn<CompetitorAnalysis, String> campaignNameCol;
    @javafx.fxml.FXML
    private TableColumn<CompetitorAnalysis, String> channelsCol;
    @javafx.fxml.FXML
    private TextField campaignNameTextField;
    @javafx.fxml.FXML
    private TextField competitorNameTextField;
    @javafx.fxml.FXML
    private TableView<CompetitorAnalysis> competitorAnalysisTableView;
    @javafx.fxml.FXML
    private TextField keyInsightsTextField;

    private ObservableList<CompetitorAnalysis> competitorAnalysisList;

    @javafx.fxml.FXML
    public void initialize() {
        competitorAnalysisList = FXCollections.observableArrayList();
        competitorAnalysisTableView.setItems(competitorAnalysisList);

        compNameCol.setCellValueFactory(new PropertyValueFactory<CompetitorAnalysis, String>("competitorName"));
        campaignNameCol.setCellValueFactory(new PropertyValueFactory<CompetitorAnalysis, String>("competitorCampaignName"));
        channelsCol.setCellValueFactory(new PropertyValueFactory<CompetitorAnalysis, String>("competitorAdvertisingChannels"));
        keyInsightsCol.setCellValueFactory(new PropertyValueFactory<CompetitorAnalysis, String>("competitorKeyInsights"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<CompetitorAnalysis, LocalDate>("competitorStartDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<CompetitorAnalysis, LocalDate>("competitorEndDate"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        try {
            File f = new File("ComputerAnalysis.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);;
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

                CompetitorAnalysis competitorAnalysis = new CompetitorAnalysis(
                        competitorNameTextField.getText(),
                        campaignNameTextField.getText(),
                        advertisingChannelTextField.getText(),
                        keyInsightsTextField.getText(),
                        startDatePicker.getValue(),
                        endDatePicker.getValue()
                );
                competitorAnalysisList.add(competitorAnalysis);
            }
            oos.writeObject(competitorAnalysisList);
            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Competitor Analysis details saved successfully.");
            alert.showAndWait();

        }
        catch (Exception e) {
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
            File f = new File("CompetitorAnalysis.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'CompetitorAnalysis.bin' does not exist.");
                alert.showAndWait();

            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                competitorAnalysisTableView.getItems().add(
                        (CompetitorAnalysis) ois.readObject());
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
}