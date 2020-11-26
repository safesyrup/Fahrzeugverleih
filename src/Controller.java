import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Vehiclepark vehiclepark = new Vehiclepark();
    CustomerController customerController = new CustomerController();
    RentController rentController = new RentController();

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void chooseMainMenu() throws IOException {
        switch (readLine()) {
            case "1":
                vehicleSubMenu();
                break;
            case "2":
                rentSubMenu();
                break;
            default:
                mainMenu();
                break;
        }
    }

    public void chooseVehicleSubMenu() throws IOException {
        switch (readLine()) {
            case "1":
                vehiclepark.printVehicles();
                vehicleSubMenu();
                break;
            case "2":
                addVehicleSubMenu();
                break;
            case "3":
                vehiclepark.editVehicle();
                break;
            case "4":
                vehiclepark.searchVehicle();
                break;
            case "0":
                mainMenu();
                break;
            default:
                vehicleSubMenu();
                break;
        }
    }

    public void chooseAddVehicleSubMenu() throws IOException {
        switch (readLine()) {
            case "1":
                vehiclepark.addVehicle("car");
                break;
            case "2":
                vehiclepark.addVehicle("motorcycle");
                break;
            case "3":
                vehiclepark.addVehicle("van");
                break;
            case "0":
                addVehicleSubMenu();
                break;
            default:
                addVehicleSubMenu();
                break;
        }
    }

    public void chooseRentSubmenu() throws IOException {
        switch (readLine()) {
            case "1":
                customerController.addCustomer();
                break;
            case "2":
                rentController.addRent();
                break;
            case "3":
                rentController.editRent();
                break;
            case "4":
                rentController.changeStatus();
                break;
            case "5":
                rentController.printRents();
                rentSubMenu();
                break;
            case "0":
                mainMenu();
                break;
            default:
                rentSubMenu();
                break;
        }
    }

    public void mainMenu() throws IOException {
        System.out.println("----------------------------------");
        System.out.println("Willkommen zur Fahrzeugverwaltung");
        System.out.println("----------------------------------");
        System.out.println("Wählen Sie eine Option aus:");
        System.out.println("1 Fahrzeugpark");
        System.out.println("2 Vermietung");
        System.out.println("----------------------------------");

        chooseMainMenu();
    }

    public void vehicleSubMenu() throws IOException {
        System.out.println("Fahrzeugpark");
        System.out.println("1 Fahrzeuge ansehen");
        System.out.println("2 Fahrzeuge hinzufügen");
        System.out.println("3 Fahrzeuge editieren");
        System.out.println("4 Fahrzeug suchen");
        System.out.println("0 zurück");

        chooseVehicleSubMenu();
    }

    public void addVehicleSubMenu() throws IOException {
        System.out.println("Welche Art von Fahrzeug hinzufügen");
        System.out.println("1 Auto");
        System.out.println("2 Mottorrad");
        System.out.println("3 Transporter");
        System.out.println("0 zurück");

        chooseAddVehicleSubMenu();
    }

    public void rentSubMenu() throws IOException {
        System.out.println("1 Nutzer hinzufügen");
        System.out.println("2 Vermietung erfassen");
        System.out.println("3 Vermietung ändern");
        System.out.println("4 Status ändern");
        System.out.println("5 Vermietungen ansehen");
        System.out.println("0 zurück");

        chooseRentSubmenu();
    }
}
