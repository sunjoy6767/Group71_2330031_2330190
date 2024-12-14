package reconditionedcarimporter.group71_2330031_2330190;


import java.io.Serializable;
import java.time.LocalDate;

public class AddProductToInventory implements Serializable {
    private int StockNumber;
    private String Vin;
    private String Brand;
    private String Milieage;
    private String Enginecc;
    private String Type;
    private String FuelType;
    private String Quantity;
    private double Price;
    private String Transmission;
    private String Steering;
    private String Warehouse;
    private LocalDate manufactured;

    public AddProductToInventory() {
    }



    public AddProductToInventory(int stockNumber, String vin, String brand, String milieage, String enginecc, String type, String fuelType, String quantity, double price, String transmission, String steering, String warehouse, LocalDate manufactured) {
        StockNumber = stockNumber;
        Vin = vin;
        Brand = brand;
        Milieage = milieage;
        Enginecc = enginecc;
        Type = type;
        FuelType = fuelType;
        Quantity = quantity;
        Price = price;
        Transmission = transmission;
        Steering = steering;
        Warehouse = warehouse;
        this.manufactured = manufactured;
    }

    public int getStockNumber() {
        return StockNumber;
    }

    public void setStockNumber(int stockNumber) {
        StockNumber = stockNumber;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getMilieage() {
        return Milieage;
    }

    public void setMilieage(String milieage) {
        Milieage = milieage;
    }

    public String getEnginecc() {
        return Enginecc;
    }

    public void setEnginecc(String enginecc) {
        Enginecc = enginecc;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getTransmission() {
        return Transmission;
    }

    public void setTransmission(String transmission) {
        Transmission = transmission;
    }

    public String getSteering() {
        return Steering;
    }

    public void setSteering(String steering) {
        Steering = steering;
    }

    public String getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(String warehouse) {
        Warehouse = warehouse;
    }

    public LocalDate getManufactured() {
        return manufactured;
    }

    public void setManufactured(LocalDate manufactured) {
        this.manufactured = manufactured;
    }

    @Override
    public String toString() {
        return "AddProductToInventory{" +
                "StockNumber=" + StockNumber +
                ", Vin='" + Vin + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Milieage='" + Milieage + '\'' +
                ", Enginecc='" + Enginecc + '\'' +
                ", Type='" + Type + '\'' +
                ", FuelType='" + FuelType + '\'' +
                ", Quantity='" + Quantity + '\'' +
                ", Price=" + Price +
                ", Transmission='" + Transmission + '\'' +
                ", Steering='" + Steering + '\'' +
                ", Warehouse='" + Warehouse + '\'' +
                ", manufactured=" + manufactured +
                '}';
    }
}
