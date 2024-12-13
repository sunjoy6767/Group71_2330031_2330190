package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> 3bc00b52d34941df03bc650b153d6440f4778ca1
public class SetInventoryThresholdsController
{
    @javafx.fxml.FXML
    private TableColumn minimumThresholdCol;
    @javafx.fxml.FXML
    private TableColumn typeOfProductCol;
    @javafx.fxml.FXML
    private TextField minimumThresholdTextField;
    @javafx.fxml.FXML
    private TableView tableViewThreshold;
    @javafx.fxml.FXML
    private TextField maximumThresholdTextField;
    @javafx.fxml.FXML
    private TableColumn maximumThresholdCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBackToInvenoryManagerButtonOnAction (ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void setInventoryThresholdButtonOnAction(ActionEvent actionEvent) {
    }
}