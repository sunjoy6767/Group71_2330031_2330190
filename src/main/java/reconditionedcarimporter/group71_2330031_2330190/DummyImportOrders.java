package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class DummyImportOrders extends ImportedCar implements Serializable {
    private String carModel, supplierId, carBrand;
    private int carQuantity;
    private LocalDate expectedShipmentDate;

    public DummyImportOrders() {
    }

    public DummyImportOrders(String carModel, String supplierId, String carBrand, int carQuantity, LocalDate expectedShipmentDate) {
        this.carModel = carModel;
        this.supplierId = supplierId;
        this.carBrand = carBrand;
        this.carQuantity = carQuantity;
        this.expectedShipmentDate = expectedShipmentDate;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarQuantity() {
        return carQuantity;
    }

    public void setCarQuantity(int carQuantity) {
        this.carQuantity = carQuantity;
    }

    public LocalDate getExpectedShipmentDate() {
        return expectedShipmentDate;
    }

    public void setExpectedShipmentDate(LocalDate expectedShipmentDate) {
        this.expectedShipmentDate = expectedShipmentDate;
    }

    @Override
    public String toString() {
        return "DummyOrders{" +
                "carModel='" + carModel + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carQuantity=" + carQuantity +
                ", expectedShipmentDate=" + expectedShipmentDate +
                '}';
    }
}
