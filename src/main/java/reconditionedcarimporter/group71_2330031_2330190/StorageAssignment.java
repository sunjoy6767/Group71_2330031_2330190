package reconditionedcarimporter.group71_2330031_2330190;

import java.time.LocalDate;

public class StorageAssignment {
    private String storageAssignmentId, storageLocation, storageUnitNumber;
    private LocalDate assignedDate, releaseDate;
    private Double storageCost, overDueCharger;
    private int carId;

    public StorageAssignment() {
    }

    public StorageAssignment(String storageAssignmentId, String storageLocation, String storageUnitNumber, LocalDate assignedDate, LocalDate releaseDate, Double storageCost, Double overDueCharger, int carId) {
        this.storageAssignmentId = storageAssignmentId;
        this.storageLocation = storageLocation;
        this.storageUnitNumber = storageUnitNumber;
        this.assignedDate = assignedDate;
        this.releaseDate = releaseDate;
        this.storageCost = storageCost;
        this.overDueCharger = overDueCharger;
        this.carId = carId;
    }

    public String getStorageAssignmentId() {
        return storageAssignmentId;
    }

    public void setStorageAssignmentId(String storageAssignmentId) {
        this.storageAssignmentId = storageAssignmentId;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getStorageUnitNumber() {
        return storageUnitNumber;
    }

    public void setStorageUnitNumber(String storageUnitNumber) {
        this.storageUnitNumber = storageUnitNumber;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(Double storageCost) {
        this.storageCost = storageCost;
    }

    public Double getOverDueCharger() {
        return overDueCharger;
    }

    public void setOverDueCharger(Double overDueCharger) {
        this.overDueCharger = overDueCharger;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "StorageAssignment{" +
                "storageAssignmentId='" + storageAssignmentId + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                ", storageUnitNumber='" + storageUnitNumber + '\'' +
                ", assignedDate=" + assignedDate +
                ", releaseDate=" + releaseDate +
                ", storageCost=" + storageCost +
                ", overDueCharger=" + overDueCharger +
                ", carId=" + carId +
                '}';
    }
}
