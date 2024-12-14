package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerInquiry implements Serializable {
    private String customerName, orderNumber, inquiryType, inquiryDetails, response, status;
    private LocalDate inquiryDate;

    public CustomerInquiry(String customerName, String orderNumber, String inquiryType, String inquiryDetails, String response, String status, LocalDate inquiryDate) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.inquiryType = inquiryType;
        this.inquiryDetails = inquiryDetails;
        this.response = response;
        this.status = status;
        this.inquiryDate = inquiryDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
    }

    public String getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(String inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDate inquiryDate) {
        this.inquiryDate = inquiryDate;
    }



    @Override
    public String toString() {
        return "CustomerInquiry{" +
                "customerName='" + customerName + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", inquiryType='" + inquiryType + '\'' +
                ", inquiryDetails='" + inquiryDetails + '\'' +
                ", response='" + response + '\'' +
                ", status='" + status + '\'' +
                ", inquiryDate=" + inquiryDate +
                '}';
    }
}
