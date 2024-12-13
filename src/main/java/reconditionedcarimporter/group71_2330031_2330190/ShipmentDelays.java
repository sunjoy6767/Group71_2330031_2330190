package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class ShipmentDelays implements Serializable{
    private String shipmentId, currentStatus, delayCause;
    private int estimatedDelayDuration;
    private LocalDate updatedDeliveryDate;

    public ShipmentDelays() {
    }

    public ShipmentDelays(String shipmentId, String currentStatus, String delayCause, int estimatedDelayDuration, LocalDate updatedDeliveryDate) {
        this.shipmentId = shipmentId;
        this.currentStatus = currentStatus;
        this.delayCause = delayCause;
        this.estimatedDelayDuration = estimatedDelayDuration;
        this.updatedDeliveryDate = updatedDeliveryDate;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getDelayCause() {
        return delayCause;
    }

    public void setDelayCause(String delayCause) {
        this.delayCause = delayCause;
    }

    public int getEstimatedDelayDuration() {
        return estimatedDelayDuration;
    }

    public void setEstimatedDelayDuration(int estimatedDelayDuration) {
        this.estimatedDelayDuration = estimatedDelayDuration;
    }

    public LocalDate getUpdatedDeliveryDate() {
        return updatedDeliveryDate;
    }

    public void setUpdatedDeliveryDate(LocalDate updatedDeliveryDate) {
        this.updatedDeliveryDate = updatedDeliveryDate;
    }

    @Override
    public String toString() {
        return "ShipmentDelays{" +
                "shipmentId='" + shipmentId + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", delayCause='" + delayCause + '\'' +
                ", estimatedDelayDuration=" + estimatedDelayDuration +
                ", updatedDeliveryDate=" + updatedDeliveryDate +
                '}';
    }
}
