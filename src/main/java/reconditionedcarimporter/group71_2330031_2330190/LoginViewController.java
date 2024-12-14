package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import java.io.*;

public class LoginViewController {
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> loginAsComboBox;

    private final String credentialsFile = "credentials.bin";

    @javafx.fxml.FXML
    public void initialize() {
        loginAsComboBox.getItems().addAll("CarImportManager", "MarketingManager",
                "SalesRepresentative", "InventoryManager");
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid username/password");
            alert.showAndWait();
        }
        if (validateLogin(username, password)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("Welcome");
            alert.showAndWait();
            if (loginAsComboBox.getValue().equals("CarImportManager")) {
                SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
            } else if (loginAsComboBox.getValue().equals("MarketingManager")) {
                SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
            } else if (loginAsComboBox.getValue().equals("SalesRepresentative")) {
                SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
            } else if (loginAsComboBox.getValue().equals("InventoryManager")) {
                SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setContentText("Username and password cannot be empty.");
            alert.showAndWait();
        }
        saveCredentials(username, password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration Successful");
        alert.setContentText("User registered successfully.");
        alert.showAndWait();
    }

    private boolean validateLogin(String username, String password) {
        try (FileInputStream fis = new FileInputStream(credentialsFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    LoginPage user = (LoginPage) ois.readObject();
                    if (user.getUsername().equals(username) &&
                            user.getPassword().equals(password)) {
                        return true;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setContentText("Failed to load credentials.");
            alert.showAndWait();
        }
        return false;
    }

    private void saveCredentials(String username, String password) {
        try (FileOutputStream fos = new FileOutputStream(credentialsFile, true);
             ObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {

            LoginPage user = new LoginPage(username, password);
            oos.writeObject(user);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setContentText("Failed to save credentials.");
            alert.showAndWait();
        }


    }
}