import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class FileHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void writeToFileVehicles(VehicleContainer v) throws IOException {
        objectMapper.writeValue(new File("C:\\Module\\326\\LB1\\code\\files\\vehicleData.json"), v);
    }

    public void writeToFileCustomers(CustomerContainer c) throws IOException {
        objectMapper.writeValue(new File("C:\\Module\\326\\LB1\\code\\files\\customerData.json"), c);
    }

    public void writeToFileRents(RentContainer r) throws IOException {
        objectMapper.writeValue(new File("C:\\Module\\326\\LB1\\code\\files\\rentData.json"), r);
    }

    public VehicleContainer initializeReadFileVehicles() throws IOException {
        return objectMapper.readValue(new File("C:\\Module\\326\\LB1\\code\\files\\vehicleData.json"), VehicleContainer.class);
    }

    public CustomerContainer initializeReadFileCustomers() throws IOException {
        return objectMapper.readValue(new File("C:\\Module\\326\\LB1\\code\\files\\customerData.json"), CustomerContainer.class);
    }

    public RentContainer initializeReadFileRents() throws IOException {
        return objectMapper.readValue(new File("C:\\Module\\326\\LB1\\code\\files\\rentData.json"), RentContainer.class);
    }
}
