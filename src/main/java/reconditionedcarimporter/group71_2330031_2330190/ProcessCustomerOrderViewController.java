package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ProcessCustomerOrderViewController
{
    @javafx.fxml.FXML
    private TextField vinTextField;
    @javafx.fxml.FXML
    private TextField typeOfCarTextField;
    @javafx.fxml.FXML
    private TextField customerNumberTextField;
    @javafx.fxml.FXML
    private TextField customerAddressTextField;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> paymentComboBox;
    @javafx.fxml.FXML
    private TextField quantityTextField;



    @javafx.fxml.FXML
    public void initialize() {
        paymentComboBox.getItems().addAll("Cash","Card");
    }

    @javafx.fxml.FXML
    public void goBackToSalesRepresentativeButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void addNewOrderButtonOnAction(ActionEvent actionEvent) {
        if (customerNameTextField.getText().isEmpty() || customerNumberTextField.getText().isEmpty() ||
                customerAddressTextField.getText().isEmpty() || vinTextField.getText().isEmpty() ||
                typeOfCarTextField.getText().isEmpty() || priceTextField.getText().isEmpty() ||
                quantityTextField.getText().isEmpty() || paymentComboBox.getValue() == null) {

            showAlert("Validation Error", "All fields must be filled in.");
            return;

        }

        try {
            Integer.parseInt(quantityTextField.getText());
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Quantity must be a valid number.");
            return;
        }

        try {
            Double.parseDouble(priceTextField.getText());
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Price must be a valid number.");
            return;
        }


        try{
            File f = new File("ProcessCustomerOrder.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);;
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(new NewOrder(customerNameTextField.getText(),customerNumberTextField.getText(),
                    customerAddressTextField.getText(),vinTextField.getText(),
                    typeOfCarTextField.getText(), paymentComboBox.getValue(),
                    Integer.parseInt(quantityTextField.getText()),
                    Double.parseDouble(priceTextField.getText()))
            );
            customerNameTextField.clear();
            customerNumberTextField.clear();
            customerAddressTextField.clear();
            vinTextField.clear();
            typeOfCarTextField.clear();
            priceTextField.clear();
            quantityTextField.clear();
            paymentComboBox.setValue(null);

            oos.close();
        }
        catch(Exception e){
            showAlert("Error", "Failed to save the order. Please try again.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}