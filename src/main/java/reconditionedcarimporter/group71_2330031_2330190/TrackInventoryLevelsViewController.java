package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class TrackInventoryLevelsViewController
{
    @javafx.fxml.FXML
    private TableColumn minimumThresholdCol;
    @javafx.fxml.FXML
    private TableColumn quantityCol;
    @javafx.fxml.FXML
    private TableView tableViewTrackInventoryLevel;
    @javafx.fxml.FXML
    private TableColumn typeOCarCol;
    @javafx.fxml.FXML
    private TableColumn maximumThresholdCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBackButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showInventoryLevelsButtonOnAction(ActionEvent actionEvent) {
    }
}