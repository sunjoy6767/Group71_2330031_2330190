package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;

import java.io.IOException;

public class InventoryManagerViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateProductInformationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateInventoryReportsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void setInventoryThresholdsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void trackInventoryLevelsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutForInventoryManagerOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeProductsfromInventoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void transferStockBetweenWarehousesOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void monitorDocumentExpiryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addProductToInventoryOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("AddProductsToInventory.fxml", actionEvent);
    }
}