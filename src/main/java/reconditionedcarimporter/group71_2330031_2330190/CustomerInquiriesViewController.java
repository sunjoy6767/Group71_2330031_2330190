package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;

public class CustomerInquiriesViewController
{


    @javafx.fxml.FXML
    private TableColumn<CustomerInquiry, String> responseCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerInquiry, LocalDate> inquiryDateCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerInquiry, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerInquiry, String> inquiryTypeCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerInquiry, String> customerNameCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerInquiry, String> orderNumberCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerInquiry, String> inquiryDetailsCol;
    @javafx.fxml.FXML
    private TableView<CustomerInquiry> customerInquiryTableView;

    private ObservableList<CustomerInquiry> customerInquiryObservableList;
    @javafx.fxml.FXML
    private TextField orderNumberTextField;

    @javafx.fxml.FXML
    public void initialize() {
        customerInquiryObservableList = FXCollections.observableArrayList();
        customerInquiryTableView.setItems(customerInquiryObservableList);

        customerNameCol.setCellValueFactory(new PropertyValueFactory<CustomerInquiry, String>("customerName"));
        orderNumberCol.setCellValueFactory(new PropertyValueFactory<CustomerInquiry, String>("orderNumber"));
        inquiryTypeCol.setCellValueFactory(new PropertyValueFactory<CustomerInquiry, String>("inquiryType"));
        inquiryDetailsCol.setCellValueFactory(new PropertyValueFactory<CustomerInquiry, String>("inquiryDetails"));
        responseCol.setCellValueFactory(new PropertyValueFactory<CustomerInquiry, String>("response"));
        statusCol.setCellValueFactory(new PropertyValueFactory<CustomerInquiry, String>("status"));
        inquiryDateCol.setCellValueFactory(new PropertyValueFactory<CustomerInquiry, LocalDate>("inquiryDate"));

    }


    @javafx.fxml.FXML
    public void clearTheTableButtonOnAction(ActionEvent actionEvent) {
        customerInquiryObservableList.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void updateTheStatusButtonOnAction(ActionEvent actionEvent) {
        try {
            String orderNumber = orderNumberTextField.getText();

            boolean productUpdated = false;

            for (CustomerInquiry ci : customerInquiryObservableList) {
                if (Objects.equals(ci.getOrderNumber(), orderNumber))
                {
                    ci.getCustomerName();
                    ci.getOrderNumber();
                    ci.getInquiryType();
                    ci.getInquiryDetails();
                    ci.getResponse();
                    ci.setStatus("Resolved");
                    ci.getInquiryDate();

                    productUpdated = true;
                    break;
                }
            }

            if (!productUpdated) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Product Not Found");
                alert.setHeaderText(null);
                alert.setContentText("No product with Order Number " + orderNumber + " was found.");
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
        File file = new File("CustomerInquiry.bin");
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Failed to delete the old file.");
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (CustomerInquiry ci : customerInquiryObservableList) {
                oos.writeObject(ci);
            }
        }

    }

    @javafx.fxml.FXML
    public void goBackToSalesRepresentativeViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("CustomerInquiry.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'CustomerInquiry.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                customerInquiryTableView.getItems().add(
                        (CustomerInquiry) ois.readObject()
                );
                CustomerInquiry product = (CustomerInquiry) ois.readObject();
                customerInquiryObservableList.add(product);
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
}
