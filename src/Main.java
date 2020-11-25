import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Vehiclepark().vehicleContainer = new FileHandler().initializeReadFileVehicles();
        new CustomerController().customerContainer = new FileHandler().initializeReadFileCustomers();
        new RentController().rentContainer = new FileHandler().initializeReadFileRents();
        Controller controller = new Controller();
        controller.mainMenu();
    }
}
