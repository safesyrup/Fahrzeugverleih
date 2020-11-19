import java.util.ArrayList;
import java.util.List;

public class CustomerContainer {
    private static List<Customer> customers = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        CustomerContainer.customers = customers;
    }
}