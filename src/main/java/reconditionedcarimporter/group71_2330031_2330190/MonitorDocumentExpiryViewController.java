package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class MonitorDocumentExpiryViewController
{
    @javafx.fxml.FXML
    private TableColumn vinTableCol;
    @javafx.fxml.FXML
    private TableColumn expireTableCol;
    @javafx.fxml.FXML
    private TableView documentExpiryTableViewfxid;
    @javafx.fxml.FXML
    private TableColumn SNTableCol;
    @javafx.fxml.FXML
    private TableColumn brandTableCol;
    @javafx.fxml.FXML
    private TableColumn manufactureYearTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBackToInventoryManagerButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void clearTableViewButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void monitorDocumentExpiryButtonOnAction(ActionEvent actionEvent) {
    }
}