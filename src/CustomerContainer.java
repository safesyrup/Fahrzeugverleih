import java.util.ArrayList;
import java.util.List;

public class CustomerContainer {

    public CustomerContainer() {
    }

    private static List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        CustomerContainer.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
