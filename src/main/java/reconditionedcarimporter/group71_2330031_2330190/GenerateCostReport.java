package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class GenerateCostReport implements Serializable {
    private String reportId;
    private double purchaseCost, customsDutyAmount, shippingCost,
            inspectionCost, additionalFees;
    private LocalDate reportDate;

    public GenerateCostReport() {
    }

    public GenerateCostReport(String reportId, double purchaseCost, double customsDutyAmount, double shippingCost, double inspectionCost, double additionalFees, LocalDate reportDate) {
        this.reportId = reportId;
        this.purchaseCost = purchaseCost;
        this.customsDutyAmount = customsDutyAmount;
        this.shippingCost = shippingCost;
        this.inspectionCost = inspectionCost;
        this.additionalFees = additionalFees;
        this.reportDate = reportDate;
    }



    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public double getCustomsDutyAmount() {
        return customsDutyAmount;
    }

    public void setCustomsDutyAmount(double customsDutyAmount) {
        this.customsDutyAmount = customsDutyAmount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getInspectionCost() {
        return inspectionCost;
    }

    public void setInspectionCost(double inspectionCost) {
        this.inspectionCost = inspectionCost;
    }

    public double getAdditionalFees() {
        return additionalFees;
    }

    public void setAdditionalFees(double additionalFees) {
        this.additionalFees = additionalFees;
    }


    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "GenerateCostReport{" +
                "reportId='" + reportId + '\'' +
                ", purchaseCost=" + purchaseCost +
                ", customsDutyAmount=" + customsDutyAmount +
                ", shippingCost=" + shippingCost +
                ", inspectionCost=" + inspectionCost +
                ", additionalFees=" + additionalFees +
                ", reportDate=" + reportDate +
                '}';
    }
}
