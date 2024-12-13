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

public class RemoveProductsfromInventoryViewController {

    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> furlTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> vinTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> milieTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, Double> priceTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, Integer> SNTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> brandTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> transmiTableCol;
    @javafx.fxml.FXML
    private TextField snToRemoveProductfxid;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> stringTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> enginTableCol;
    @javafx.fxml.FXML
    private TableView<AddProductToInventory> showAddedProductfxid;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> quantityTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory, String> typeTableCol;

    ObservableList<AddProductToInventory> addedProduct;

    @javafx.fxml.FXML
    public void initialize() {
        addedProduct = FXCollections.observableArrayList();
        showAddedProductfxid.setItems(addedProduct);

        // Set up table column bindings
        SNTableCol.setCellValueFactory(new PropertyValueFactory<>("stockNumber"));
        vinTableCol.setCellValueFactory(new PropertyValueFactory<>("vin"));
        brandTableCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        milieTableCol.setCellValueFactory(new PropertyValueFactory<>("milieage"));
        enginTableCol.setCellValueFactory(new PropertyValueFactory<>("enginecc"));
        quantityTableCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        transmiTableCol.setCellValueFactory(new PropertyValueFactory<>("transmission"));
        typeTableCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        furlTableCol.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        stringTableCol.setCellValueFactory(new PropertyValueFactory<>("steering"));
    }

    @javafx.fxml.FXML
    public void clearTableOnActionButton(ActionEvent actionEvent) {
        addedProduct.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All products have been cleared from the table.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void removeProductButtonOnAction(ActionEvent actionEvent) {
        try {
            int stockNumberToRemove = Integer.parseInt(snToRemoveProductfxid.getText());

            boolean productRemoved = addedProduct.removeIf(product -> product.getStockNumber() == stockNumberToRemove);

            if (!productRemoved) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Product Not Found");
                alert.setHeaderText(null);
                alert.setContentText("No product with Stock Number " + stockNumberToRemove + " was found.");
                alert.showAndWait();
                return;
            }

            rewriteProductFile();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Removal Successful");
            alert.setHeaderText(null);
            alert.setContentText("The product has been removed successfully.");
            alert.showAndWait();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid numeric value for the Stock Number.");
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
        File file = new File("AddedProductToInventory.bin");
        if (file.exists() && !file.delete()) {
            throw new IOException("Failed to delete the old file.");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (AddProductToInventory product : addedProduct) {
                oos.writeObject(product);
            }
        }
    }

    @javafx.fxml.FXML
    public void showProductOnTableOnAction(ActionEvent actionEvent) {
        File file = new File("AddedProductToInventory.bin");

        if (!file.exists()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("The file 'AddedProductToInventory.bin' does not exist.");
            alert.showAndWait();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                AddProductToInventory product = (AddProductToInventory) ois.readObject();
                addedProduct.add(product);
            }
        } catch (EOFException e) {
            //
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void goBackToCarInventoryManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
    }
}
