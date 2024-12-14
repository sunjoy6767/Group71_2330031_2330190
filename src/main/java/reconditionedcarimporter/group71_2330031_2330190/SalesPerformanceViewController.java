package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SalesPerformanceViewController
{
    @javafx.fxml.FXML
    private TableColumn<NewOrder, String> phoneCol;
    @javafx.fxml.FXML
    private TableColumn<NewOrder, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<NewOrder, String> addressCol;
    @javafx.fxml.FXML
    private TableColumn<NewOrder, String> vinCol;
    @javafx.fxml.FXML
    private TableView<NewOrder> salesReportTableView;
    @javafx.fxml.FXML
    private TableColumn<NewOrder, String> customerNameCol;
    @javafx.fxml.FXML
    private TableColumn<NewOrder, String> paymentCol;
    @javafx.fxml.FXML
    private TableColumn<NewOrder, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<NewOrder, Double> priceCol;

    private ObservableList<NewOrder> orders;

    private int varQuantity;
    private double varPrice;
    @javafx.fxml.FXML
    private Label totalQuantityLabel;
    @javafx.fxml.FXML
    private Label totalPriceLabel;

    @javafx.fxml.FXML
    public void initialize() {
        orders = FXCollections.observableArrayList();
        salesReportTableView.setItems(orders);

        customerNameCol.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("customerName"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("customerPhone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("customerAddress"));
        vinCol.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("vin"));
        typeCol.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("carType"));
        paymentCol.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("payment"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<NewOrder, Integer>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<NewOrder, Double>("price"));
    }

    @javafx.fxml.FXML
    public void clearTheTableButtonOnAction(ActionEvent actionEvent) {
        orders.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void showDataButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            File f = new File("ProcessCustomerOrder.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'ProcessCustomerOrder.bin' does not exist.");
                alert.showAndWait();
            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                salesReportTableView.getItems().add(
                        (NewOrder) ois.readObject()
                );
                NewOrder product = (NewOrder) ois.readObject();
                orders.add(product);
                varQuantity += product.getQuantity();
                varPrice += product.getPrice();
            }


        }

        catch(Exception e){
            try {
                if (ois != null) ois.close();
            }
            catch(Exception e2){
                //
            }
        }
        totalQuantityLabel.setText(String.valueOf(varQuantity));
        totalPriceLabel.setText(Double.toString(varPrice));
    }

    @javafx.fxml.FXML
    public void goBackToSalesRepresentativeViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("SalesRepresentative-view.fxml", actionEvent);
    }


}