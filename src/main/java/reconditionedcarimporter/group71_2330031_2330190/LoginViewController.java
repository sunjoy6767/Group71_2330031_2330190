package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.*;

public class LoginViewController {
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> loginAsComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        loginAsComboBox.getItems().addAll("Car Import Manager", "Marketing Manager",
                "Sales Representative", "Inventory Manager");

    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {

        if (loginAsComboBox.getValue().equals("CarImportManager")){
            SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
        }
        else if (loginAsComboBox.getValue().equals("MarketingManager")){
            SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
        }
        else if (loginAsComboBox.getValue().equals("SalesRepresentative")){
            SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
        }
        else if (loginAsComboBox.getValue().equals("InventoryManager")){
            SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
        }

    }
}

