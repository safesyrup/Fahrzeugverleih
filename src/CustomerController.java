import de.vandermeer.asciitable.AsciiTable;

import java.io.IOException;
import java.util.List;

public class CustomerController {
    Controller controller;
    Customer customer;
    FileHandler fileHandler;
    static public CustomerContainer customerContainer;

    public void addCustomer() throws IOException {
        controller = new Controller();
        customer = new Customer();
        fileHandler = new FileHandler();
        customerContainer = new CustomerContainer();

        System.out.println("Name:");
        customer.setName(controller.readLine());
        System.out.println("Nachname:");
        customer.setSurname(controller.readLine());
        System.out.println("Strasse:");
        customer.setStreet(controller.readLine());
        System.out.println("Postleitzahl:");
        customer.setPlz(controller.readLine());
        System.out.println("Ortschaft:");
        customer.setCity(controller.readLine());
        System.out.println("Mobilnummer:");
        customer.setPhone(controller.readLine());
        System.out.println("email:");
        customer.setMail(controller.readLine());
        System.out.println("Geburtsdatum");
        customer.setDateOfBirth(controller.readLine());

        new CustomerContainer().addCustomer(customer);
        fileHandler.writeToFileCustomers(customerContainer);
        controller.rentSubMenu();
    }

    public void printCustomers() {
        controller = new Controller();
        List<Customer> customers = customerContainer.getCustomers();
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.getContext().setWidth(200);
        asciiTable.addRule();
        asciiTable.addRow("id",
                "Name",
                "Nachname",
                "Strasse",
                "Postleizahl",
                "Ortschaft",
                "Mobilnummer",
                "email",
                "Geburtsdatum");
        for (int i = 0; i < customers.size(); i++) {
            int index = i + 1;
            asciiTable.addRule();
            asciiTable.addRow(index,
                    customers.get(i).getName(),
                    customers.get(i).getSurname(),
                    customers.get(i).getStreet(),
                    customers.get(i).getPlz(),
                    customers.get(i).getCity(),
                    customers.get(i).getPhone(),
                    customers.get(i).getMail(),
                    customers.get(i).getDateOfBirth());
        }
        String string = asciiTable.render();
        System.out.println(string);
    }
}
