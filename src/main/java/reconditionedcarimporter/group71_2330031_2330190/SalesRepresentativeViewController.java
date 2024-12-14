package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SalesRepresentativeViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void processCustomerOrdersOnActon(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("ProcessCustomerOrder-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void followUpOnSalesLeadsOnActon(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("FollowUpSalesLead-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void generateSalesReportsOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("GenerateSalesReport-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void customerInquiriesOnActon(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CustomerInquiries-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void manageCustomerAccountsOnActon(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("ManageCustomerAccounts-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void provideProductInformationOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("ProductInformation-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logOutForSalesRepresentativeOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("Login-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void trackSalesPerformanceOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("SalesPerformance-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void closeSalesDealsOnActon(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CloseSalesDeals-view.fxml", actionEvent);
    }
}