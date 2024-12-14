package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class PromotionalOfferViewController
{
    @javafx.fxml.FXML
    private TableColumn<PromotionalOffer, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TextField conditionsTextField;
    @javafx.fxml.FXML
    private TextField offerIdTextField;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TextField discountTextField;
    @javafx.fxml.FXML
    private TableView<PromotionalOffer> promotionalOfferTableView;
    @javafx.fxml.FXML
    private TextField offerNameTextField;
    @javafx.fxml.FXML
    private TableColumn<PromotionalOffer, String> offerIdCol;
    @javafx.fxml.FXML
    private TableColumn<PromotionalOffer, String> offerNameCol;
    @javafx.fxml.FXML
    private TableColumn<PromotionalOffer, String> offerConditionsCol;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<PromotionalOffer, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn<PromotionalOffer, String> statusCol;
    @javafx.fxml.FXML
    private TextField statusTextField;
    @javafx.fxml.FXML
    private TableColumn<PromotionalOffer, Double> discountCol;

    private ObservableList<PromotionalOffer> promotionalOfferObservableList;

    @javafx.fxml.FXML
    public void initialize() {
        promotionalOfferObservableList = FXCollections.observableArrayList();
        promotionalOfferTableView.setItems(promotionalOfferObservableList);

        offerIdCol.setCellValueFactory(new PropertyValueFactory<PromotionalOffer,String>("offerId"));
        offerNameCol.setCellValueFactory(new PropertyValueFactory<PromotionalOffer, String>("offerName"));
        offerConditionsCol.setCellValueFactory(new PropertyValueFactory<PromotionalOffer, String>("conditions"));
        statusCol.setCellValueFactory(new PropertyValueFactory<PromotionalOffer, String>("status"));
        discountCol.setCellValueFactory(new PropertyValueFactory<PromotionalOffer, Double>("discountPercentage"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<PromotionalOffer, LocalDate>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<PromotionalOffer, LocalDate>("endDate"));
    }

    @javafx.fxml.FXML
    public void saveTheDetailsButtonOnAction(ActionEvent actionEvent) {
        PromotionalOffer promotionalOffer = new PromotionalOffer(
            offerIdTextField.getText(),
            offerNameTextField.getText(),
            conditionsTextField.getText(),
            statusTextField.getText(),
            Double.parseDouble(discountTextField.getText()),
            startDatePicker.getValue(),
            endDatePicker.getValue()
        );

        try{
            File f = new File("PromotionalOffer.bin");
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

            oos.writeObject(promotionalOffer);

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Promotion Offer details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the PromotionalOffer.bin file.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void goBackToMarketingManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("MarketingManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("PromotionalOffer.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'PromotionalOffer.bin' does not exist.");
                alert.showAndWait();

            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                promotionalOfferTableView.getItems().add(
                        (PromotionalOffer) ois.readObject());
            }
        }
        catch(Exception e){
            try {
                if (ois != null) ois.close();
            }
            catch(Exception e2){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("File Not Found");
                alert.setHeaderText(null);
                alert.setContentText("The file 'PromotionalOffer.bin' does not exist.");
                alert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void clearTableButtonOnAction(ActionEvent actionEvent) {
        promotionalOfferObservableList.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Table Cleared");
        alert.setHeaderText(null);
        alert.setContentText("All Data have been cleared from the table.");
        alert.showAndWait();
    }
}