package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController
{
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> loginAsComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        loginAsComboBox.getItems().addAll("Client", "Showroom Mechanics", "Car Import Manager", "Marketing Manager", "Sales Representative",
                "Inventory Manager", "Financial Manager", "Legal Compliance Manager");

    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        if (loginAsComboBox.getValue().equals("Marketing Manager")) {
            SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
        }
        else if (loginAsComboBox.getValue().equals("Car Import Manager")) {
            SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
        }
        else if (loginAsComboBox.getValue().equals("Sales Representative")) {
            SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
        }
        else if (loginAsComboBox.getValue().equals("Inventory Manager")) {
            SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
        }

    }
}