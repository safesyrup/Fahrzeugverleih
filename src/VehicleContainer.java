import java.util.ArrayList;
import java.util.List;

public class VehicleContainer {
    private static List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        VehicleContainer.vehicles = vehicles;
    }

    public void addVehicles(Vehicle v) {
        vehicles.add(v);
    }
}
