package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class TrackShipment implements Serializable {
    private String shipmentId, shippingCompany, destination, supplierId;
    private LocalDate departureDate, deliveryDate;

    public TrackShipment() {
    }

    public TrackShipment(String shipmentId, String shippingCompany, String destination, String supplierId, LocalDate departureDate, LocalDate deliveryDate) {
        this.shipmentId = shipmentId;
        this.shippingCompany = shippingCompany;
        this.destination = destination;
        this.supplierId = supplierId;
        this.departureDate = departureDate;
        this.deliveryDate = deliveryDate;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "TrackShipment{" +
                "shipmentId='" + shipmentId + '\'' +
                ", shippingCompany='" + shippingCompany + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
