package reconditionedcarimporter.group71_2330031_2330190;

import java.time.LocalDate;

public class ImportedCar {
    private String carModel, carBrand, supplierId;
    private int carYear;
    private int carQuantity;
    private LocalDate expectedShipmentDate;

    public ImportedCar() {
    }

    public ImportedCar(String carModel, String carBrand, String supplierId, int carYear, int carQuantity, LocalDate expectedShipmentDate) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.supplierId = supplierId;
        this.carYear = carYear;
        this.carQuantity = carQuantity;
        this.expectedShipmentDate = expectedShipmentDate;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
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
        return "ImportedCar{" +
                "carModel='" + carModel + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", carYear=" + carYear +
                ", carQuantity=" + carQuantity +
                ", expectedShipmentDate=" + expectedShipmentDate +
                '}';
    }
}
