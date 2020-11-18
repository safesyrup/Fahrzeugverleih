import java.util.ArrayList;
import java.util.List;

public class VehicleContainer {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer o) {
        customers.add(o);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicles(Vehicle o) {
        vehicles.add(o);
    }
}
