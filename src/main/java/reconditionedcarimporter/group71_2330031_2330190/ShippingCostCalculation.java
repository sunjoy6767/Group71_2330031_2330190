package reconditionedcarimporter.group71_2330031_2330190;

public class ShippingCostCalculation {
    private String calculationId, shipmentId, transportMode;
    private int carId;
    private double distance, insuranceCost, taxesAndDuties, handlingCharges, totalShippingCost;

    public ShippingCostCalculation() {
    }

    public ShippingCostCalculation(String calculationId, String shipmentId, String transportMode, int carId, double distance, double insuranceCost, double taxesAndDuties, double handlingCharges ,double totalShippingCost) {
        this.calculationId = calculationId;
        this.shipmentId = shipmentId;
        this.transportMode = transportMode;
        this.carId = carId;
        this.distance = distance;
        this.insuranceCost = insuranceCost;
        this.taxesAndDuties = taxesAndDuties;
        this.totalShippingCost = totalShippingCost;
        this.handlingCharges = handlingCharges;
    }

    public ShippingCostCalculation(String text, String text1, String value, int i, double v, double v1, double v2, double v3) {
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

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public double getTaxesAndDuties() {
        return taxesAndDuties;
    }

    public void setTaxesAndDuties(double taxesAndDuties) {
        this.taxesAndDuties = taxesAndDuties;
    }

    public double getHandlingCharges() {
        return handlingCharges;
    }

    public void setHandlingCharges(double handlingCharges) {
        this.handlingCharges = handlingCharges;
    }

    public double getTotalShippingCost() {
        return totalShippingCost;
    }

    public void setTotalShippingCost(double totalShippingCost) {
        this.totalShippingCost = totalShippingCost;
    }

    @Override
    public String toString() {
        return "ShippingCostCalculation{" +
                "calculationId='" + calculationId + '\'' +
                ", shipmentId='" + shipmentId + '\'' +
                ", transportMode='" + transportMode + '\'' +
                ", carId=" + carId +
                ", distance=" + distance +
                ", insuranceCost=" + insuranceCost +
                ", taxesAndDuties=" + taxesAndDuties +
                ", handlingCharges=" + handlingCharges +
                ", totalShippingCost=" + totalShippingCost +
                '}';
    }

    public double totalShippingCost(double insuranceCost, double taxesAndDuties, double handlingCharges) {
        double totalShippingCost = 0;
        totalShippingCost = insuranceCost + taxesAndDuties + handlingCharges;
        return totalShippingCost;
    }
}
