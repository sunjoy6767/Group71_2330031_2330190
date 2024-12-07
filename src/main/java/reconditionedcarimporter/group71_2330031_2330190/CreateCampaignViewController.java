package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private TableColumn<Campaign, Double> campaignBudgetCol;

    @javafx.fxml.FXML
    private TextField campaignIdTextField;
    @javafx.fxml.FXML
    private TextField targetAudienceTextField;

    private ArrayList<Campaign> campaignsList;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showCampaignInTheTableButtonOnAction(ActionEvent actionEvent) {
        StringBuilder c = new StringBuilder();
        for (Campaign campaign : campaignsList) {
            c.append("%s\n".formatted(campaign.toString()));
        }
    }

    @javafx.fxml.FXML
    public void saveCampaignButtonOnAction(ActionEvent actionEvent) {
        Campaign campaign = new Campaign(
                campaignNameTextField.getText(),
                campaignIdTextField.getText(),
                targetAudienceTextField.getText(),
                Integer.parseInt(campaignBudgetTextField.getText()),
                startingDatePicker.getValue(),
                endingDatePicker.getValue()
        );
        campaignsList.add(campaign);
    }

    @javafx.fxml.FXML
    public void goBackToMarketingManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
    }


    }
