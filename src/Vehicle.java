import java.util.Date;

public class Vehicle {
    protected String vehicleType;
    protected String brand;
    protected String model;
    protected int displacement;
    protected String fuelType;
    protected String color;
    protected int milage;
    protected String licensePlate;
    protected String category;
    protected String availableFrom;
    protected String availableUntil;
    protected String isAvailable;

    //----------------------------------------------------------------------------------------
    //attributes for car
    int numberBags;
    String Type;
    String hasNav;
    public int getNumberBags() {
        return numberBags;
    }
    public void setNumberBags(int numberBags) {
        this.numberBags = numberBags;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public String getHasNav() {
        return hasNav;
    }
    public void setHasNav(String hasNav) {
        this.hasNav = hasNav;
    }
    //attributes for motorcyle
    int Tankvolume;
    public int getTankvolume() {
        return Tankvolume;
    }
    public void setTankvolume(int tankvolume) {
        Tankvolume = tankvolume;
    }
    //attributes for van
    int loadingWeight;
    public int getLoadingWeight() {
        return loadingWeight;
    }
    public void setLoadingWeight(int loadingWeight) {
        this.loadingWeight = loadingWeight;
    }
    //----------------------------------------------------------------------------------------
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {this.vehicleType = vehicleType;}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    public String getAvailableUntil() {
        return availableUntil;
    }

    public void setAvailableUntil(String availableUntil) {
        this.availableUntil = availableUntil;
    }

    public String getisAvailable() {
        return isAvailable;
    }

    public void setAvailable(String available) {
        isAvailable = available;
    }
}
