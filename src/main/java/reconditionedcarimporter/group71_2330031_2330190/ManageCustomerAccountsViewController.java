package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class ManageCustomerAccountsViewController
{
    @javafx.fxml.FXML
    private TextField password;
    @javafx.fxml.FXML
    private TextField phoneNumber;
    @javafx.fxml.FXML
    private TextField customerID;
    @javafx.fxml.FXML
    private TextField userName;
    @javafx.fxml.FXML
    private TableColumn<ManageCustomerAccounts, String> usernameCol;
    @javafx.fxml.FXML
    private TableColumn<ManageCustomerAccounts, Integer> phoneNumberCol;
    @javafx.fxml.FXML
    private TableColumn<ManageCustomerAccounts, String> customerIdCol;
    @javafx.fxml.FXML
    private TableColumn<ManageCustomerAccounts, String> passwordCol;
    @javafx.fxml.FXML
    private TableView<ManageCustomerAccounts> manageTableView;

    private ObservableList<ManageCustomerAccounts> manageCustomerAccountsObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        manageCustomerAccountsObservableList = FXCollections.observableArrayList();
        manageTableView.setItems(manageCustomerAccountsObservableList);

        customerIdCol.setCellValueFactory(new PropertyValueFactory<ManageCustomerAccounts, String>("customerId"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<ManageCustomerAccounts,String>("userName"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<ManageCustomerAccounts,String>("password"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<ManageCustomerAccounts, Integer>("phoneNumber"));
    }

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {
        try {
            String cusID = customerID.getText();

            boolean productUpdated = false;

            for (ManageCustomerAccounts mca : manageCustomerAccountsObservableList) {
                if (mca.getCustomerId().equals(cusID)) {
                    mca.setUserName(userName.getText());
                    mca.setPassword(password.getText());
                    mca.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));

                    productUpdated = true;
                    break;
                }
            }

            if (!productUpdated) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Product Not Found");
                alert.setHeaderText(null);
                alert.setContentText("No product with Stock Number " + cusID + " was found.");
                alert.showAndWait();
                return;
            }

            rewriteProductFile();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText(null);
            alert.setContentText("The product has been updated successfully.");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numeric values for Stock Number, Quantity, and Price.");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to update the product file: " + e.getMessage());
            alert.showAndWait();
        }
    }

    private void rewriteProductFile() throws IOException {
        File file = new File("ManageCustomerAccounts.bin");
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Failed to delete the old file.");
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (ManageCustomerAccounts product : manageCustomerAccountsObservableList) {
                oos.writeObject(product);
            }
        }
    }

    @javafx.fxml.FXML
    public void showDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("ManageCustomerAccounts.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'ManageCustomerAccounts.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                manageTableView.getItems().add(
                        (ManageCustomerAccounts) ois.readObject()
                );
                ManageCustomerAccounts product = (ManageCustomerAccounts) ois.readObject();
                manageCustomerAccountsObservableList.add(product);
            }
//         ois.close();
        }
        catch(Exception e){
            try {
                if (ois != null) ois.close();
            }
            catch(Exception e2){
                //
            }
        }
    }

    @javafx.fxml.FXML
    public void clearButtonOnAction(ActionEvent actionEvent) {
        manageCustomerAccountsObservableList.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }
}