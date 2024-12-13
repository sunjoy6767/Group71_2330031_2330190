package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class StorageDummy implements Serializable {
    private String storageAssignmentId, storageUnitNumber;
    private int carId;
    private LocalDate assignedDate, releasedDate;

    public StorageDummy() {
    }

    public StorageDummy(String storageAssignmentId, String storageUnitNumber, int carId, LocalDate assignedDate, LocalDate releasedDate) {
        this.storageAssignmentId = storageAssignmentId;
        this.storageUnitNumber = storageUnitNumber;
        this.carId = carId;
        this.assignedDate = assignedDate;
        this.releasedDate = releasedDate;
    }

    public StorageDummy(String text, String text1, String text2, LocalDate value, LocalDate value1, double v, double v1, int i) {
    }

    public String getStorageAssignmentId() {
        return storageAssignmentId;
    }

    public void setStorageAssignmentId(String storageAssignmentId) {
        this.storageAssignmentId = storageAssignmentId;
    }

    public String getStorageUnitNumber() {
        return storageUnitNumber;
    }

    public void setStorageUnitNumber(String storageUnitNumber) {
        this.storageUnitNumber = storageUnitNumber;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    @Override
    public String toString() {
        return "StorageDummy{" +
                "storageAssignmentId='" + storageAssignmentId + '\'' +
                ", storageUnitNumber='" + storageUnitNumber + '\'' +
                ", carId=" + carId +
                ", assignedDate=" + assignedDate +
                ", releasedDate=" + releasedDate +
                '}';
    }
}
