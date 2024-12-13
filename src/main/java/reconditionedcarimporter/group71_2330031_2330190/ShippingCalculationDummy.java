package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;

public class ShippingCalculationDummy implements Serializable {
    private String calculationId, shipmentId, transportMode;
    private Double insuranceCost, taxesAndDuties, handleCharges, totalShippingCost;
    private int carId, distance;

    public ShippingCalculationDummy(String calculationId, String shipmentId, String transportMode, Double insuranceCost, Double taxesAndDuties, Double handleCharges, Double totalShippingCost, int carId, int distance) {
        this.calculationId = calculationId;
        this.shipmentId = shipmentId;
        this.transportMode = transportMode;
        this.insuranceCost = insuranceCost;
        this.taxesAndDuties = taxesAndDuties;
        this.handleCharges = handleCharges;
        this.totalShippingCost = totalShippingCost;
        this.carId = carId;
        this.distance = distance;
    }

    public ShippingCalculationDummy(String shipmentId, String transportMode, String calculationId, int carId, Double totalShippingCost) {
        this.shipmentId = shipmentId;
        this.transportMode = transportMode;
        this.calculationId = calculationId;
        this.carId = carId;
        this.totalShippingCost = totalShippingCost;
    }

    public ShippingCalculationDummy(String shipmentId, String transportMode, int carId, double totalShippingCost, String calculationId) {
    }

    public String getCalculationId() {
        return calculationId;
    }

    public void setCalculationId(String calculationId) {
        this.calculationId = calculationId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public Double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(Double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public Double getTaxesAndDuties() {
        return taxesAndDuties;
    }

    public void setTaxesAndDuties(Double taxesAndDuties) {
        this.taxesAndDuties = taxesAndDuties;
    }

    public Double getHandleCharges() {
        return handleCharges;
    }

    public void setHandleCharges(Double handleCharges) {
        this.handleCharges = handleCharges;
    }

    public Double getTotalShippingCost() {
        return totalShippingCost;
    }

    public void setTotalShippingCost(Double totalShippingCost) {
        this.totalShippingCost = totalShippingCost;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ShippingCalculationDummy{" +
                "calculationId='" + calculationId + '\'' +
                ", shipmentId='" + shipmentId + '\'' +
                ", transportMode='" + transportMode + '\'' +
                ", insuranceCost=" + insuranceCost +
                ", taxesAndDuties=" + taxesAndDuties +
                ", handleCharges=" + handleCharges +
                ", totalShippingCost=" + totalShippingCost +
                ", carId=" + carId +
                ", distance=" + distance +
                '}';
    }
}
