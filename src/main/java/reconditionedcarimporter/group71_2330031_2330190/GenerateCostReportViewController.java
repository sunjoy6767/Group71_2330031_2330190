package reconditionedcarimporter.group71_2330031_2330190;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateCostReportViewController
{
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private TextField purchaseCostTextField;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private TextField customsDutyAmountTextField;
    @javafx.fxml.FXML
    private TextField inspectionCostTextField;
    @javafx.fxml.FXML
    private TextField additionalFeesTextField;
    @javafx.fxml.FXML
    private TextField totalImportCostTextField;
    @javafx.fxml.FXML
    private TextField shippingCostTextField;

    @javafx.fxml.FXML
    private TableColumn<GenerateCostReport, LocalDate> reportDateCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateCostReport, Double> totalCostCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateCostReport, String> reportIdCol;

    private ObservableList<GenerateCostReport> generateCostReports;
    @javafx.fxml.FXML
    private TableView<GenerateCostReport> costReportTableView;

    @javafx.fxml.FXML
    public void initialize() {
        generateCostReports = FXCollections.observableArrayList();
        costReportTableView.setItems(generateCostReports);

        reportIdCol.setCellValueFactory(new PropertyValueFactory<GenerateCostReport, String>("reportId"));
        totalCostCol.setCellValueFactory(new PropertyValueFactory<GenerateCostReport, Double>("totalImportCost"));
        reportDateCol.setCellValueFactory(new PropertyValueFactory<GenerateCostReport, LocalDate>("reportDate"));
    }

    @javafx.fxml.FXML
    public void goBackToCarImportManagerViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("CarImportManager-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void showTheDetailsInTheTableButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File f = new File("GenerateCostReport.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The file 'GenerateCostReport.bin' does not exist.");
                alert.showAndWait();

            }
            if(fis != null) ois = new ObjectInputStream(fis);

            while(true) {
                costReportTableView.getItems().add(
                        (GenerateCostReport) ois.readObject());
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
    }

    @javafx.fxml.FXML
    public void saveDetailsButtonOnAction(ActionEvent actionEvent) {
        GenerateCostReport generateCostReport = new GenerateCostReport(
            reportIdTextField.getText(),
            Double.parseDouble(purchaseCostTextField.getText()),
            Double.parseDouble(customsDutyAmountTextField.getText()),
            Double.parseDouble(shippingCostTextField.getText()),
            Double.parseDouble(inspectionCostTextField.getText()),
            Double.parseDouble(additionalFeesTextField.getText()),
            Double.parseDouble(totalImportCostTextField.getText()),
            reportDatePicker.getValue()
        );
        try{
            File f = new File("GenerateCostReport.bin");
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

            oos.writeObject(generateCostReport);

            oos.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Generate Cost Report details saved successfully.");
            alert.showAndWait();
        }
        catch(Exception e){
            //
        }


    }
}