package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class CloseSalesDealsViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> paymentVerifiedComboBox;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, String> dealTermsCol;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, String> validateDealCol;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, String> dealIDCol;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, String> paymentTypeCol;
    @javafx.fxml.FXML
    private TextField dealTermsTextField;
    @javafx.fxml.FXML
    private TableView<CloseSalesDeals> salesDealTableView;
    @javafx.fxml.FXML
    private DatePicker dealDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, Double> priceCol;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, String> paymentVerifiedCol;
    @javafx.fxml.FXML
    private TextField invoiceDetailsTextField;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, String> vinCol;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, Integer> quantityCol;
    @javafx.fxml.FXML
    private ComboBox<String> validateDealComboBox;
    @javafx.fxml.FXML
    private TextField deliveryScheduleTextField;
    @javafx.fxml.FXML
    private TextField dealIDTextField;
    @javafx.fxml.FXML
    private TableColumn<CloseSalesDeals, LocalDate> dealDateCol;

    private ObservableList<CloseSalesDeals> closeSalesDealsObservableList;
    private ObservableList<NewOrder> newOrderObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        closeSalesDealsObservableList = FXCollections.observableArrayList();
        salesDealTableView.setItems(closeSalesDealsObservableList);
        //newOrderObservableList = FXCollections.observableArrayList();

        paymentVerifiedComboBox.getItems().addAll("Yes", "No");
        validateDealComboBox.getItems().addAll("Yes", "No");

        vinCol.setCellValueFactory(new PropertyValueFactory<>("vin"));
        dealIDCol.setCellValueFactory(new PropertyValueFactory<>("dealID"));
        dealDateCol.setCellValueFactory(new PropertyValueFactory<>("dealDate"));
        dealTermsCol.setCellValueFactory(new PropertyValueFactory<>("dealTerms"));
        paymentVerifiedCol.setCellValueFactory(new PropertyValueFactory<>("paymentVerified"));
        paymentTypeCol.setCellValueFactory(new PropertyValueFactory<>("payment"));
        validateDealCol.setCellValueFactory(new PropertyValueFactory<>("dealValidated"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @javafx.fxml.FXML
    public void goBackButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        closeSalesDealsObservableList.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void showDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File file = new File("ProcessCustomerOrder.bin");
            if (!file.exists()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'ProcessCustomerOrder.bin' does not exist.");
                alert.showAndWait();
                return;
            }

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);


            while (true) {
                NewOrder order = (NewOrder) ois.readObject();

                CloseSalesDeals deals = new CloseSalesDeals(
                        order.getCustomerName(), order.getCustomerPhone(), order.getCustomerAddress(), order.getVin(),
                        order.getCarType(), order.getPayment(), order.getQuantity(), order.getPrice(),
                        dealIDTextField.getText(), dealTermsTextField.getText(),
                        dealDatePicker.getValue(), paymentVerifiedComboBox.getValue(),
                        validateDealComboBox.getValue(), invoiceDetailsTextField.getText(),
                        deliveryScheduleTextField.getText()
                );
                closeSalesDealsObservableList.add(deals);

                dealIDTextField.clear();
                dealTermsTextField.clear();
                dealDatePicker.setValue(null);
                paymentVerifiedComboBox.setValue(null);
                validateDealComboBox.setValue(null);
                invoiceDetailsTextField.clear();
                deliveryScheduleTextField.clear();
            }

        } catch (EOFException e) {
            //
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid numeric values for Close Sales.");
            alert.showAndWait();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @javafx.fxml.FXML
    public void saveDetailsButtonOnAction(ActionEvent actionEvent) {
        File file = new File("CloseSalesDeals.bin");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (CloseSalesDeals deals : closeSalesDealsObservableList) {
                oos.writeObject(deals);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Deals saved successfully to 'CloseSalesDeals.bin'.");
            alert.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save Deals: " + e.getMessage());
            alert.showAndWait();
        }

    }
}