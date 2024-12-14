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
    private TextField minimumThresholdTextField;
    @javafx.fxml.FXML
    private TableView <DummySetInventoryThresholds>tableViewThreshold;
    @javafx.fxml.FXML
    private TextField maximumThresholdTextField;
    @javafx.fxml.FXML
    private TableColumn<DummySetInventoryThresholds,String> maximumThresholdCol;

    private ObservableList<DummySetInventoryThresholds> thresholdsList;

    @javafx.fxml.FXML
    private TableColumn <DummySetInventoryThresholds,String> typeOfCarCol;

    @javafx.fxml.FXML
    public void initialize() {
        thresholdsList = FXCollections.observableArrayList();
        tableViewThreshold.setItems(thresholdsList);

        typeOfCarCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
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


            while (true) {
                AddProductToInventory product = (AddProductToInventory) ois.readObject();


                int minThreshold = Integer.parseInt(minimumThresholdTextField.getText());
                int maxThreshold = Integer.parseInt(maximumThresholdTextField.getText());


                DummySetInventoryThresholds threshold = new DummySetInventoryThresholds(
                        product.getType(), minThreshold, maxThreshold, product.getQuantity()
                );
                thresholdsList.add(threshold);

            }

        } catch (EOFException e) {
           //
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


    @javafx.fxml.FXML
    public void saveButtonOnAction(ActionEvent actionEvent) {
        File file = new File("DummyInventory.bin");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (DummySetInventoryThresholds threshold : thresholdsList) {
                oos.writeObject(threshold);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Thresholds saved successfully to 'DummyInventory.bin'.");
            alert.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save thresholds: " + e.getMessage());
            alert.showAndWait();
        }
    }
}