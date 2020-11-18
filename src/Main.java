import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Vehiclepark().vehicleContainer = new FileHandler().initializeReadFile();
        Controller controller = new Controller();
        controller.mainMenu();
    }
}
