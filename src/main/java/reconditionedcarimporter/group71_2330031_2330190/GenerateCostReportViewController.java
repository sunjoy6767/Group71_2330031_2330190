package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
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

    private ArrayList<GenerateCostReport> generateCostReports;
    @javafx.fxml.FXML
    private TableView<GenerateCostReport> costReportTableView;

    @javafx.fxml.FXML
    public void initialize() {
        generateCostReports = new ArrayList<GenerateCostReport>();

        GenerateCostReport generateCostReport = new GenerateCostReport();
        double var = generateCostReport.totalAmount();

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
        for (GenerateCostReport generateCostReport : generateCostReports) {
            costReportTableView.getItems().add(generateCostReport);
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
        generateCostReports.add(generateCostReport);

    }
}