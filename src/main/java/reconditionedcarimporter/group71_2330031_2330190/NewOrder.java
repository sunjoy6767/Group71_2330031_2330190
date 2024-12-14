package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;

public class NewOrder implements Serializable {
    private String customerName, customerPhone, customerAddress, vin,
            carType, payment;
    private int quantity;
    private double price;

    public NewOrder() {
    }

    public NewOrder(String customerName, String customerPhone, String customerAddress, String vin, String carType, String payment, int quantity, double price) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.vin = vin;
        this.carType = carType;
        this.payment = payment;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "NewOrder{" +
                "customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", vin='" + vin + '\'' +
                ", carType='" + carType + '\'' +
                ", payment='" + payment + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
