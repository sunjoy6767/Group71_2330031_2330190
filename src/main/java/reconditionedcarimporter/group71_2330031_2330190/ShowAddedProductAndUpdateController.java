package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowAddedProductAndUpdateController
{
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>furlTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> vinTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> milieTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,Double> priceTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> stringTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,Integer> SNTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>brandTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>enginTableCol;
    @javafx.fxml.FXML
    private TableView<AddProductToInventory> showAddedProductfxid;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>quantityTableCol;
    @javafx.fxml.FXML
    private TableColumn<AddProductToInventory,String> transmiTableCol;
    @javafx.fxml.FXML
    private TableColumn <AddProductToInventory,String>typeTableCol;

    ObservableList<AddProductToInventory> addedProduct;

    @javafx.fxml.FXML
    public void initialize() {
        SNTableCol.setCellValueFactory(new PropertyValueFactory<>("StockNumber"));
        vinTableCol.setCellValueFactory(new PropertyValueFactory<>("Vin"));
        brandTableCol.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        milieTableCol.setCellValueFactory(new PropertyValueFactory<>("Milieage"));
        enginTableCol.setCellValueFactory(new PropertyValueFactory<>("EngineCC"));
        quantityTableCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        transmiTableCol.setCellValueFactory(new PropertyValueFactory<>("TransmissionType"));
        typeTableCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        furlTableCol.setCellValueFactory(new PropertyValueFactory<>("FuelType"));
        stringTableCol.setCellValueFactory(new PropertyValueFactory<>("Steering"));

    }

    @javafx.fxml.FXML
    public void showProductOnTableOnAction(ActionEvent actionEvent) {
    }
}