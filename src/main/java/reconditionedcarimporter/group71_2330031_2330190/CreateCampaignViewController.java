package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class CreateCampaignViewController
{
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
    private TextField targetAudienceTextField;
    @javafx.fxml.FXML
    private TableColumn<Campaign, Double> campaignBudgetCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showCampaignInTheTableButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveCampaignButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBackToMarketingManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
    }
}