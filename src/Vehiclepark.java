import de.vandermeer.asciitable.AsciiTable;
import java.io.IOException;
import java.util.List;

public class Vehiclepark {
    Controller controller;
    FileHandler fileHandler = new FileHandler();
    static public VehicleContainer vehicleContainer;

    public void addVehicle(String vehicleChoice) throws IOException {
        controller = new Controller();
        Vehicle vehicle = new Vehicle();
        Vehicle tmpvehicle;

        if (vehicleChoice.equals("car")) {
            vehicle.setVehicleType(vehicleChoice);
            Vehicle car = addVehicleDefaultAttributes(vehicle);

            tmpvehicle = car;

            System.out.println("Anzahl Koffer [2,3,4,5]:");
            //check if input is integer
            tmpvehicle = setNumberBagsTryParse(tmpvehicle);
            while (tmpvehicle == null) {
                System.out.println("Fehler, bitte Zahl eingeben");
                tmpvehicle = setNumberBagsTryParse(car);
            }
            car = tmpvehicle;
            System.out.println("Aufbau:");
            car.setType(controller.readLine());
            System.out.println("hat navigation? (Ja/Nein)");
            car.setHasNav(controller.readLine());

            vehicleContainer.addVehicles(car);
            fileHandler.writeToFileVehicles(vehicleContainer);
        } else if (vehicleChoice.equals("motorcycle")) {
            vehicle.setVehicleType(vehicleChoice);
            Vehicle motorcycle = addVehicleDefaultAttributes(vehicle);

            tmpvehicle = motorcycle;

            System.out.println("Tankvolumen:");
            //check if input is Integer
            tmpvehicle = setTankvolumeTryParse(tmpvehicle);
            while (tmpvehicle == null) {
                System.out.println("Fehler, bitte Zahl eingeben");
                tmpvehicle = setTankvolumeTryParse(motorcycle);
            }
            motorcycle = tmpvehicle;

            vehicleContainer.addVehicles(motorcycle);
            fileHandler.writeToFileVehicles(vehicleContainer);
        } else if (vehicleChoice.equals("van")) {
            vehicle.setVehicleType(vehicleChoice);
            Vehicle van = addVehicleDefaultAttributes(vehicle);

            tmpvehicle = van;

            System.out.println("Ladegewicht:");
            //check if input is Integer
            tmpvehicle = setLoadingWeightTryParse(tmpvehicle);
            while (tmpvehicle == null) {
                System.out.println("Fehler, bitte Zahl eingeben");
                tmpvehicle = setLoadingWeightTryParse(van);
            }
            van = tmpvehicle;

            vehicleContainer.addVehicles(van);
            fileHandler.writeToFileVehicles(vehicleContainer);
        } else {
            System.out.println("fehler");
        }
        System.out.println("fahrzeug hinzugefügt");
        controller.vehicleSubMenu();
    }

    public void printVehicles() {
        controller = new Controller();
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
            int index = i + 1;
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
        //check if input is Integer
        Vehicle tmpvehicle = vehicle;
        tmpvehicle = setDisplacementTryParse(tmpvehicle);
        while (tmpvehicle == null) {
            System.out.println("Fehler, bitte Zahl eingeben");
            tmpvehicle = setDisplacementTryParse(vehicle);
        }
        vehicle = tmpvehicle;
        System.out.println("Treibstoffart:");
        vehicle.setFuelType(controller.readLine());
        System.out.println("Aussenfarbe:");
        vehicle.setColor(controller.readLine());
        System.out.println("Aktualler Km-Stand:");
        //check if input is integer
        tmpvehicle = vehicle;
        tmpvehicle = setMilageTryParse(tmpvehicle);
        while (tmpvehicle == null) {
            System.out.println("Fehler, bitte Zahl eingeben");
            tmpvehicle = setMilageTryParse(vehicle);
        }
        vehicle = tmpvehicle;
        System.out.println("Kennzeichen:");
        vehicle.setLicensePlate(controller.readLine());
        System.out.println("Kategorie:");
        vehicle.setCategory(controller.readLine());
        System.out.println("Verfügbar ab:");
        vehicle.setAvailableFrom(controller.readLine());
        System.out.println("Verfügbar bis:");
        vehicle.setAvailableUntil(controller.readLine());
        System.out.println("Verfügbar (Ja/Nein):");
        vehicle.setAvailable(controller.readLine());
        return vehicle;
    }

    public void editVehicle() throws IOException {
        controller = new Controller();
        int index;

        printVehicles();
        System.out.print("id des zu editierenden Fahrzeuges eingeben:");
        String input = controller.readLine();
        while (!tryParseInt(input)) {
            input = controller.readLine();
        }
        index = Integer.parseInt(input);
        List<Vehicle> vehicles = vehicleContainer.getVehicles();
        Vehicle vehicle = vehicles.get(index - 1);
        Vehicle tmpvehicle = vehicle;
        vehicle = addVehicleDefaultAttributes(vehicle);
        if (vehicle.getVehicleType().equals("car")) {
            System.out.println("Anzahl Koffer [2,3,4,5]:");
            //check if input is integer
            tmpvehicle = setNumberBagsTryParse(tmpvehicle);
            while (tmpvehicle == null) {
                System.out.println("Fehler, bitte Zahl eingeben");
                tmpvehicle = setNumberBagsTryParse(tmpvehicle);
            }
            vehicle = tmpvehicle;
            System.out.println("Aufbau:");
            vehicle.setType(controller.readLine());
            System.out.println("hat navigation? (Ja/Nein)");
            vehicle.setHasNav(controller.readLine());
        } else if (vehicle.getVehicleType().equals("motorcycle")) {
            System.out.println("Tankvolumen:");
            //check if input is Integer
            tmpvehicle = setTankvolumeTryParse(tmpvehicle);
            while (tmpvehicle == null) {
                System.out.println("Fehler, bitte Zahl eingeben");
                tmpvehicle = setTankvolumeTryParse(tmpvehicle);
            }
            vehicle = tmpvehicle;
        } else if (vehicle.getVehicleType().equals("van")) {
            System.out.println("Ladegewicht:");
            //check if input is Integer
            tmpvehicle = setLoadingWeightTryParse(tmpvehicle);
            while (tmpvehicle == null) {
                System.out.println("Fehler, bitte Zahl eingeben");
                tmpvehicle = setLoadingWeightTryParse(tmpvehicle);
            }
            vehicle = tmpvehicle;
        }
        vehicles.set(index - 1, vehicle);
        vehicleContainer.setVehicles(vehicles);
        new FileHandler().writeToFileVehicles(vehicleContainer);
        System.out.println("Fahrzeug editiert");
        controller.vehicleSubMenu();
    }

    public void searchVehicle() throws IOException {
        controller = new Controller();
        String choice;
        List<Vehicle> vehicles = vehicleContainer.getVehicles();
        AsciiTable asciiTable = new AsciiTable();
        int amountRows = 0;

        System.out.println("Welche art von Fahrzeug?");
        choice = printVehicleTypeChoices();
        while (choice == null) {
            choice = printVehicleTypeChoices();
        }

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
            int index = i + 1;
            if (vehicles.get(i).getVehicleType().equals(choice)) {
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
                amountRows++;
            }
        }
        if (amountRows > 0) {
            String string = asciiTable.render();
            System.out.println(string);
        } else {
            System.out.println("es gibt keine Fahrzeuge dieses Typs");
        }

        controller.vehicleSubMenu();
    }

    public boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Vehicle setDisplacementTryParse(Vehicle v) throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            v.setDisplacement(Integer.parseInt(readline));
            return v;
        }
        return null;
    }

    public Vehicle setMilageTryParse(Vehicle v) throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            v.setMilage(Integer.parseInt(readline));
            return v;
        }
        return null;
    }

    public Vehicle setNumberBagsTryParse(Vehicle v) throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            v.setNumberBags(Integer.parseInt(readline));
            return v;
        }
        return null;
    }

    public Vehicle setTankvolumeTryParse(Vehicle v) throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            v.setTankvolume(Integer.parseInt(readline));
            return v;
        }
        return null;
    }

    public Vehicle setLoadingWeightTryParse(Vehicle v) throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            v.setLoadingWeight(Integer.parseInt(readline));
            return v;
        }
        return null;
    }

    public String printVehicleTypeChoices() throws IOException {
        controller = new Controller();
        System.out.println("1 Auto");
        System.out.println("2 Motorrad");
        System.out.println("3 Transporter");

        switch (controller.readLine()) {
            case "1":
                return "car";
            case "2":
                return "motorcycle";
            case "3":
                return "van";
            default:
                break;
        }
        return null;
    }
}