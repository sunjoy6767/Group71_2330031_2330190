package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MarketingManagerViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void promotionalOffersButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("PromotionalOffer-view.fxml", actionEvent);
    }


    @javafx.fxml.FXML
    public void createCampaignButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CreateCampaign-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("Login-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void campaignPerformanceButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CampaignPerformance-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void competitorAnalysisButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CompetitorAnalysis-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void budgetManagementButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void brandReputationButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("BrandReputation-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void seasonalCampaignButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("SeasonalCampaign-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void loyaltyProgramButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("LoyaltyProgram-view.fxml", actionEvent);
    }
}