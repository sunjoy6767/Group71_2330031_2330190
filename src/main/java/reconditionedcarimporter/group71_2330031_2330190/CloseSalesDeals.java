package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class CloseSalesDeals extends NewOrder implements Serializable{
    private String dealId;
    private String dealTerms;
    private LocalDate dealDate;
    private String paymentVerified;
    private String dealValidated;
    private String invoiceDetails;
    private String deliverySchedule;

    public CloseSalesDeals() {
    }

    public CloseSalesDeals(String dealId, String dealTerms, LocalDate dealDate, String paymentVerified, String dealValidated, String invoiceDetails, String deliverySchedule) {
        this.dealId = dealId;
        this.dealTerms = dealTerms;
        this.dealDate = dealDate;
        this.paymentVerified = paymentVerified;
        this.dealValidated = dealValidated;
        this.invoiceDetails = invoiceDetails;
        this.deliverySchedule = deliverySchedule;
    }

    public CloseSalesDeals(String customerName, String customerPhone, String customerAddress, String vin, String carType, String payment, int quantity, double price, String dealId, String dealTerms, LocalDate dealDate, String paymentVerified, String dealValidated, String invoiceDetails, String deliverySchedule) {
        super(customerName, customerPhone, customerAddress, vin, carType, payment, quantity, price);
        this.dealId = dealId;
        this.dealTerms = dealTerms;
        this.dealDate = dealDate;
        this.paymentVerified = paymentVerified;
        this.dealValidated = dealValidated;
        this.invoiceDetails = invoiceDetails;
        this.deliverySchedule = deliverySchedule;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealTerms() {
        return dealTerms;
    }

    public void setDealTerms(String dealTerms) {
        this.dealTerms = dealTerms;
    }

    public LocalDate getDealDate() {
        return dealDate;
    }

    public void setDealDate(LocalDate dealDate) {
        this.dealDate = dealDate;
    }

    public String getPaymentVerified() {
        return paymentVerified;
    }

    public void setPaymentVerified(String paymentVerified) {
        this.paymentVerified = paymentVerified;
    }

    public String getDealValidated() {
        return dealValidated;
    }

    public void setDealValidated(String dealValidated) {
        this.dealValidated = dealValidated;
    }

    public String getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(String invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public String getDeliverySchedule() {
        return deliverySchedule;
    }

    public void setDeliverySchedule(String deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    @Override
    public String toString() {
        return "CloseSalesDeals{" +
                "dealId='" + dealId + '\'' +
                ", dealTerms='" + dealTerms + '\'' +
                ", dealDate=" + dealDate +
                ", paymentVerified='" + paymentVerified + '\'' +
                ", dealValidated='" + dealValidated + '\'' +
                ", invoiceDetails='" + invoiceDetails + '\'' +
                ", deliverySchedule='" + deliverySchedule + '\'' +
                '}';
    }
}
