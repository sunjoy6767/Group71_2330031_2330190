package reconditionedcarimporter.group71_2330031_2330190;


import java.io.Serializable;

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


    public AddProductToInventory() {
    }

    public AddProductToInventory(int stockNumber, String vin, String brand, String milieage, String enginecc, String type, String fuelType, String quantity, double price, String transmission, String steering) {
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

    public String getMilieage() {
        return Milieage;
    }

    public void setMilieage(String milieage) {
        Milieage = milieage;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
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

    @Override
    public String toString() {
        return StockNumber + "," + Vin + "," +  Brand +","+ Milieage +","+ Enginecc +","+ Type +","+FuelType +","+ Quantity +","+ Price + ","+ Transmission +","+ Steering + "\n";
    }

    public String toString(String str){
        return StockNumber + "," + Vin + "," +  Brand +","+ Milieage +","+ Enginecc +","+ Type +","+FuelType +","+ Quantity +","+ Price + ","+ Transmission +","+ Steering + "\n";

    }
}
