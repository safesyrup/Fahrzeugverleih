import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Vehiclepark vehiclepark = new Vehiclepark();

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void chooseMainMenu() throws IOException {
        switch (readLine()) {
            case "1":
                vehicleSubMenu();
                break;
            case "2":
                System.out.println("nunig fertig bro");
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
                break;
            case "2":
                addVehicleSubMenu();
                break;
            case "3":
                vehiclepark.editVehicle();
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
                //add van
                break;
            case "0":
                addVehicleSubMenu();
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
}
