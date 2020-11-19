import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Vehiclepark().vehicleContainer = new FileHandler().initializeReadFileVehicles();
        new CustomerController().customerContainer = new FileHandler().initializeReadFileCustomers();
        Controller controller = new Controller();
        controller.mainMenu();
    }
}
