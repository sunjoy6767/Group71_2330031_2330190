package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class VehicleInspection implements Serializable {
    private int carId;
    private LocalDate inspectionDate;
    private boolean passedInspection, requiresRepairs;
    private String repairDetails, status;

    public VehicleInspection() {
    }

    public VehicleInspection(int carId, LocalDate inspectionDate, boolean passedInspection, boolean requiresRepairs, String repairDetails, String status) {
        this.carId = carId;
        this.inspectionDate = inspectionDate;
        this.passedInspection = passedInspection;
        this.requiresRepairs = requiresRepairs;
        this.repairDetails = repairDetails;
        this.status = status;
    }

    public VehicleInspection(int carId, LocalDate value, String passedInspectionStatus, String requiresRepairsStatus, String text, String text1) {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public boolean isPassedInspection() {
        return passedInspection;
    }

    public void setPassedInspection(boolean passedInspection) {
        this.passedInspection = passedInspection;
    }

    public boolean isRequiresRepairs() {
        return requiresRepairs;
    }

    public void setRequiresRepairs(boolean requiresRepairs) {
        this.requiresRepairs = requiresRepairs;
    }

    public String getRepairDetails() {
        return repairDetails;
    }

    public void setRepairDetails(String repairDetails) {
        this.repairDetails = repairDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VehicleInspection{" +
                "carId=" + carId +
                ", inspectionDate=" + inspectionDate +
                ", passedInspection=" + passedInspection +
                ", requiresRepairs=" + requiresRepairs +
                ", repairDetails='" + repairDetails + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
