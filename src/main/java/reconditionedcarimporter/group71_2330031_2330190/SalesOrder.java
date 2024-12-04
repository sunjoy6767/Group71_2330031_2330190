package reconditionedcarimporter.group71_2330031_2330190;

import java.time.LocalDate;

public class SalesOrder {
    private String orderId, customerId, orderStatus;
    private int quantity;
    private double price;
    private LocalDate orderDate;

    public SalesOrder() {
    }

    public SalesOrder(String orderId, String customerId, String orderStatus, int quantity, double price, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderDate=" + orderDate +
                '}';
    }
}
