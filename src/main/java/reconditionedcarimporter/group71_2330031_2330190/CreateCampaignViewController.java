package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Campaign> campaignTableView;

    @javafx.fxml.FXML
    public void initialize() {
        campaignsList = new ArrayList<Campaign>();

        startingDateCol.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("startingDate"));
        endingDateCol.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("endingDate"));
        campaignBudgetCol.setCellValueFactory(new PropertyValueFactory<Campaign, Double>("budget"));
        campaignNameCol.setCellValueFactory(new PropertyValueFactory<Campaign, String>("name"));
    }

    @javafx.fxml.FXML
    public void showCampaignInTheTableButtonOnAction(ActionEvent actionEvent) {
        for (Campaign campaign : campaignsList) {
            campaignTableView.getItems().add(campaign);
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
