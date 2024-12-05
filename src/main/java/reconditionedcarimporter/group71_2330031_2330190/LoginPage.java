package reconditionedcarimporter.group71_2330031_2330190;

import javafx.scene.control.Alert;

public class LoginPage {
    private String username, password;

    public LoginPage() {
    }

    public LoginPage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginPage{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void handleLogin(String username, String password) {
        // Example login validation: hardcoded username/password
        if (username.equals("user") && password.equals("password123")) {
            showAlert("Login Successful", "You have successfully logged in!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Login Failed", "Invalid username or password.", Alert.AlertType.ERROR);
        }
    }
}
