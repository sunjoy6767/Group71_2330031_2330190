package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;

import java.io.IOException;

public class InventoryManagerViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateProductInformationOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("ShowAddedProductAndUpdate.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void generateInventoryReportsOnAction(ActionEvent actionEvent)  throws IOException {
        SceneSwitcher.switchScene("GenerateInventoryReports-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void setInventoryThresholdsOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchScene("SetInventoryThresholds.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void trackInventoryLevelsOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("TrackInventoryLevels-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logOutForInventoryManagerOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("Login-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void removeProductsfromInventoryOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("RemoveProductsfromInventory-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void transferStockBetweenWarehousesOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("TransferStockBetweenWarehouses-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void monitorDocumentExpiryOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MonitorDocumentExpiry-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void addProductToInventoryOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("AddProductsToInventory.fxml", actionEvent);
    }
}