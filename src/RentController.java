import de.vandermeer.asciitable.AsciiTable;

import javax.annotation.processing.RoundEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RentController {
    static public RentContainer rentContainer;
    Vehiclepark vehiclepark;
    Controller controller;
    CustomerController customerController;
    FileHandler fileHandler = new FileHandler();

    public void addRent() throws IOException {
        Rent rent = new Rent();
        vehiclepark = new Vehiclepark();
        controller = new Controller();
        Vehicle v;
        Integer price;
        customerController = new CustomerController();
        Customer c;

        vehiclepark.printVehicles();
        System.out.println("id des fahrzeuges eingeben");
        //check if id is int
        v = getVehicleTryParse();
        while (v == null) {
            System.out.println("Fehler, bitte Zahl eingeben:");
            v = getVehicleTryParse();
        }
        rent.setVehicle(v);
        System.out.println("Mietdauer:");
        rent.setRentDuration(controller.readLine());
        System.out.println("Preis:");
        //check if price is int
        price = setPriceTryParse();
        while (price == null) {
            System.out.println("Fehler, bitte Zahl eingeben:");
            price = setPriceTryParse();
        }
        rent.setPrice(price);
        System.out.println("Status:");
        rent.setStatus(controller.readLine());
        customerController.printCustomers();
        System.out.println("id des Kunden eingeben:");
        //check if id is int
        c = getCustomerTryParse();
        while (c == null) {
            System.out.println("Fehler, bitte Zahl eingeben:");
            c = getCustomerTryParse();
        }
        rent.setCustomer(c);

        RentContainer.addRent(rent);
        fileHandler.writeToFileRents(rentContainer);
        System.out.println("Vermietung Hinzugefügt");
        controller.rentSubMenu();
    }

    public void editRent() throws IOException {
        controller = new Controller();
        Rent rent;
        List<Rent> rents = rentContainer.getRents();
        Integer price;
        Integer index;

        printRents();
        System.out.println("id der zu änderen Vermietung eingeben:");
        //check if id is int
        index = getIndexTryParse();
        while (index == null) {
            System.out.println("Fehler, bitte Zahl eingeben:");
            index = getIndexTryParse();
        }
        index = index-1;
        rent = rentContainer.getRents().get(index);
        System.out.println("Mietdauer:");
        rent.setRentDuration(controller.readLine());
        System.out.println("Preis:");
        //chech if price is int
        price = setPriceTryParse();
        while (price == null) {
            System.out.println("Fehler, bitte Zahl eingeben:");
            price = setPriceTryParse();
        }
        rent.setPrice(price);
        System.out.println("Status:");
        rent.setStatus(controller.readLine());

        rents.set(index, rent);

        RentContainer.setRents(rents);
        fileHandler.writeToFileRents(rentContainer);
        System.out.println("Vermietung editiert");
        controller.rentSubMenu();
    }

    public void printRents() {
        controller = new Controller();
        List<Rent> rents = rentContainer.getRents();
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.getContext().setWidth(200);
        asciiTable.addRule();
        asciiTable.addRow("id",
                "Fahrzeugmarke",
                "Fahrzeugmodell",
                "Mietdauer",
                "Preis",
                "Status",
                "Kundenname",
                "Kundennachname",
                "Kundenemail");
        for (int i = 0; i < rents.size(); i++) {
            int index = i + 1;
            asciiTable.addRule();
            asciiTable.addRow(index,
                    rents.get(i).getVehicle().getBrand(),
                    rents.get(i).getVehicle().getModel(),
                    rents.get(i).getRentDuration(),
                    rents.get(i).getPrice(),
                    rents.get(i).getStatus(),
                    rents.get(i).getCustomer().getName(),
                    rents.get(i).getCustomer().getSurname(),
                    rents.get(i).getCustomer().getMail());
        }
        String string = asciiTable.render();
        System.out.println(string);
    }

    public void changeStatus() throws IOException {
        controller = new Controller();
        Integer index;
        Rent rent;
        List<Rent> rents = rentContainer.getRents();

        System.out.println("ID des Verleihs wessen Status geändert werden soll:");
        printRents();
        //check if id is int
        index = getIndexTryParse();
        while (index == null) {
            System.out.println("Fehler, bitte Zahl eingeben:");
            index = getIndexTryParse();
        }
        index = index - 1;
        rent = rentContainer.getRents().get(index);
        System.out.println("Status der Vermietung:");
        rent.setStatus(controller.readLine());

        rents.set(index, rent);

        RentContainer.setRents(rents);
        fileHandler.writeToFileRents(rentContainer);
        System.out.println("Status editiert");
        controller.rentSubMenu();
    }

    public boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Vehicle getVehicleTryParse() throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            return Vehiclepark.vehicleContainer.getVehicles().get(Integer.parseInt(readline)-1);
        }
        return null;
    }

    public Integer setPriceTryParse() throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            return Integer.valueOf(readline);
        }
        return null;
    }

    public Customer getCustomerTryParse() throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            return CustomerController.customerContainer.getCustomers().get(Integer.parseInt(readline)-1);
        }
        return null;
    }

    public Integer getIndexTryParse() throws IOException {
        String readline = controller.readLine();
        if (tryParseInt(readline)) {
            return Integer.valueOf(readline);
        }
        return null;
    }
}
