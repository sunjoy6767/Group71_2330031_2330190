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

public class SetInventoryThresholdsController
{
    @javafx.fxml.FXML
    private TableColumn <DummySetInventoryThresholds,String>minimumThresholdCol;
    @javafx.fxml.FXML
    private TableColumn <DummySetInventoryThresholds,String>typeOfProductCol;
    @javafx.fxml.FXML
    private TextField minimumThresholdTextField;
    @javafx.fxml.FXML
    private TableView <DummySetInventoryThresholds>tableViewThreshold;
    @javafx.fxml.FXML
    private TextField maximumThresholdTextField;
    @javafx.fxml.FXML
    private TableColumn maximumThresholdCol;

    private ObservableList<DummySetInventoryThresholds> thresholdsList;
    private ObservableList<AddProductToInventory> addedProducts;

    @javafx.fxml.FXML
    public void initialize() {
        thresholdsList = FXCollections.observableArrayList();
        tableViewThreshold.setItems(thresholdsList);

        // Bind table columns to the DummySetInventoryThresholds fields
        typeOfProductCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        minimumThresholdCol.setCellValueFactory(new PropertyValueFactory<>("minimumThreshold"));
        maximumThresholdCol.setCellValueFactory(new PropertyValueFactory<>("maximumThreshold"));
    }

    @javafx.fxml.FXML
    public void goBackToInvenoryManagerButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void setInventoryThresholdButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File file = new File("AddedProductToInventory.bin");
            if (!file.exists()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'AddedProductToInventory.bin' does not exist.");
                alert.showAndWait();
                return;
            }

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            // Populate thresholds based on product type
            while (true) {
                AddProductToInventory product = (AddProductToInventory) ois.readObject();

                // Read minimum and maximum thresholds from text fields
                int minThreshold = Integer.parseInt(minimumThresholdTextField.getText());
                int maxThreshold = Integer.parseInt(maximumThresholdTextField.getText());

                // Add to thresholdsList
                DummySetInventoryThresholds threshold = new DummySetInventoryThresholds(
                        product.getType(), minThreshold, maxThreshold
                );
                thresholdsList.add(threshold);
            }

        } catch (EOFException e) {
            // End of file reached
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid numeric values for thresholds.");
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
}