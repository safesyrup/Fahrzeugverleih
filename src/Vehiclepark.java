import de.vandermeer.asciitable.AsciiTable;
import org.antlr.v4.tool.ast.PredAST;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Vehiclepark {
    Controller controller;
    FileHandler fileHandler = new FileHandler();
    static public VehicleContainer vehicleContainer;

    public void addVehicle(String vehicleChoice) throws IOException {
        controller = new Controller();
        Vehicle vehicle = new Vehicle();
        if (vehicleChoice == "car") {
            vehicle.setVehicleType(vehicleChoice);
            Vehicle car = addVehicleDefaultAttributes(vehicle);

            System.out.println("Anzahl Koffer [2,3,4,5]:");
            car.setNumberBags(Integer.parseInt(controller.readLine()));
            System.out.println("Aufbau:");
            car.setType(controller.readLine());
            System.out.println("hat navigation? (Ja/Nein)");
            car.setHasNav(controller.readLine());

            vehicleContainer.addVehicles(car);
            fileHandler.writeToFile(vehicleContainer);
        } else if (vehicleChoice == "motorcycle") {
            vehicle.setVehicleType(vehicleChoice);
            Vehicle motorcycle = addVehicleDefaultAttributes(vehicle);

            System.out.println("Tankvolumen:");
            motorcycle.setTankvolume(Integer.parseInt(controller.readLine()));

            vehicleContainer.addVehicles(motorcycle);
            fileHandler.writeToFile(vehicleContainer);
        } else {
            vehicle.setVehicleType(vehicleChoice);
            Vehicle van = addVehicleDefaultAttributes(vehicle);

            vehicleContainer.addVehicles(van);
            fileHandler.writeToFile(vehicleContainer);
        }
        System.out.println("fahrzeug hinzugefügt");
        controller.vehicleSubMenu();
    }

    public void printVehicles() throws IOException {
        List<Vehicle> vehicles = vehicleContainer.getVehicles();
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.getContext().setWidth(380);
        asciiTable.addRule();
        asciiTable.addRow("id",
                "Fahrzeugtyp",
                "Marke",
                "Modell",
                "Hubraum",
                "Treibstoffart",
                "Aussenfarbe",
                "Aktueller Km-Stand",
                "Kennzeichen",
                "Kategorie",
                "Verfügbar ab Datum",
                "Verfügbar bis Datum",
                "Nicht verfügbar",
                "Anzahl Koffer",
                "Aufbau",
                "Navigationssystem",
                "Tankvolumen",
                "Ladegewicht");
        for (int i = 0; i < vehicles.size(); i++) {
            int index = i+1;
            asciiTable.addRule();
            asciiTable.addRow(index,
                    vehicles.get(i).getVehicleType(),
                    vehicles.get(i).getBrand(),
                    vehicles.get(i).getModel(),
                    vehicles.get(i).getDisplacement(),
                    vehicles.get(i).getFuelType(),
                    vehicles.get(i).getColor(),
                    vehicles.get(i).getMilage(),
                    vehicles.get(i).getLicensePlate(),
                    vehicles.get(i).getCategory(),
                    vehicles.get(i).getAvailableFrom(),
                    vehicles.get(i).getAvailableUntil(),
                    vehicles.get(i).getisAvailable(),
                    vehicles.get(i).getNumberBags(),
                    vehicles.get(i).getType(),
                    vehicles.get(i).getHasNav(),
                    vehicles.get(i).getTankvolume(),
                    vehicles.get(i).getLoadingWeight());
        }
        String string = asciiTable.render();
        System.out.println(string);
    }

    public Vehicle addVehicleDefaultAttributes(Vehicle vehicle) throws IOException {
        System.out.println("Automarke:");
        vehicle.setBrand(controller.readLine());
        System.out.println("Modell:");
        vehicle.setModel(controller.readLine());
        System.out.println("Hubraum:");
        vehicle.setDisplacement(Integer.parseInt(controller.readLine()));
        System.out.println("Treibstoffart:");
        vehicle.setFuelType(controller.readLine());
        System.out.println("Aussenfarbe:");
        vehicle.setColor(controller.readLine());
        System.out.println("Aktualler Km-Stand:");
        vehicle.setMilage(Integer.parseInt(controller.readLine()));
        System.out.println("Kennzeichen:");
        vehicle.setLicensePlate(controller.readLine());
        System.out.println("Kategorie:");
        vehicle.setCategory(controller.readLine());
        System.out.println("Verfügbar ab:");
        vehicle.setAvailableFrom(controller.readLine());
        System.out.println("Verfügbar bis:");
        vehicle.setAvailableUntil(controller.readLine());
        System.out.println("Verfügbar (Ja/Nein):");
        if (controller.readLine() == "Ja") {
            vehicle.setAvailable("Ja");
        } else {
            vehicle.setAvailable("Nein");
        }
        return vehicle;
    }

    public void editVehicle() throws IOException {
        controller = new Controller();
        printVehicles();
        System.out.print("id des zu editierenden Fahrzeuges eingeben:");
        int index = Integer.parseInt(controller.readLine().trim());

        List<Vehicle> vehicles = vehicleContainer.getVehicles();
        Vehicle vehicle = vehicles.get(index-1);

        vehicle = addVehicleDefaultAttributes(vehicle);
        if (vehicle.getVehicleType() == "car") {
            vehicle = addVehicleDefaultAttributes(vehicle);

            System.out.println("Anzahl Koffer [2,3,4,5]:");
            vehicle.setNumberBags(Integer.parseInt(controller.readLine()));
            System.out.println("Aufbau:");
            vehicle.setType(controller.readLine());
            System.out.println("hat navigation? (Ja/Nein)");
            vehicle.setHasNav(controller.readLine());
        } else if (vehicle.getVehicleType() == "motorcycle") {
            vehicle = addVehicleDefaultAttributes(vehicle);

            System.out.println("Tankvolumen:");
            vehicle.setTankvolume(Integer.parseInt(controller.readLine()));
        } else {
            vehicle = addVehicleDefaultAttributes(vehicle);

            System.out.println("Ladegewicht:");
            vehicle.setLoadingWeight(Integer.parseInt(controller.readLine()));
        }
        
    }
}
