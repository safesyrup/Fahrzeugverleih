import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Vehiclepark.vehicleContainer = new FileHandler().initializeReadFileVehicles();
        CustomerController.customerContainer = new FileHandler().initializeReadFileCustomers();
        RentController.rentContainer = new FileHandler().initializeReadFileRents();
        Controller controller = new Controller();
        controller.mainMenu();
    }
}
