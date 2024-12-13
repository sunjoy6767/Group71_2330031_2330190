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
        loginAsComboBox.setPromptText("Select Role");
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid username/password.");
            return;
        }

        if (loginAsComboBox.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please select a role from the dropdown.");
            return;
        }

        if (validateLogin(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome!");

            // Switch scenes based on the role selected
            switch (loginAsComboBox.getValue()) {
                case "CarImportManager":
                    SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
                    break;
                case "MarketingManager":
                    SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
                    break;
                case "SalesRepresentative":
                    SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
                    break;
                case "InventoryManager":
                    SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
                    break;
                default:
                    showAlert(Alert.AlertType.ERROR, "Role Error", "Invalid role selected.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Username and password cannot be empty.");
            return;
        }

        if (doesUsernameExist(username)) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Username already exists. Please choose a different username.");
            return;
        }

        saveCredentials(username, password);
        showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "User registered successfully.");
    }

    private boolean validateLogin(String username, String password) {
        File file = new File(credentialsFile);

        if (!file.exists() || file.length() == 0) {
            showAlert(Alert.AlertType.ERROR, "File Error", "The credentials file is empty or missing.");
            return false;
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    LoginPage user = (LoginPage) ois.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        return true;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            showAlert(Alert.AlertType.ERROR, "File Error", "No credentials file found.");
        } catch (StreamCorruptedException e) {
            showAlert(Alert.AlertType.ERROR, "File Error", "The credentials file is corrupted.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "File Error", "Failed to load credentials.");
        }
        return false;
    }

    private boolean doesUsernameExist(String username) {
        try (FileInputStream fis = new FileInputStream(credentialsFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    LoginPage user = (LoginPage) ois.readObject();
                    if (user.getUsername().equals(username)) {
                        return true;
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            // If the file doesn't exist, the username doesn't exist
            return false;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveCredentials(String username, String password) {
        File file = new File(credentialsFile);
        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = file.exists() && file.length() > 0
                     ? new AppendableObjectOutputStream(fos)
                     : new ObjectOutputStream(fos)) {

            LoginPage user = new LoginPage(username, password);
            oos.writeObject(user);

        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "File Error", "Failed to save credentials.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
