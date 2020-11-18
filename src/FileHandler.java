import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class FileHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void writeToFile(VehicleContainer o) throws IOException {
        objectMapper.writeValue(new File("C:\\Module\\326\\LB1\\code\\src\\files\\vehicles.json"), o);
    }

    public VehicleContainer initializeReadFile() throws IOException {
        return objectMapper.readValue(new File("C:\\Module\\326\\LB1\\code\\src\\files\\vehicles.json"), VehicleContainer.class);
    }
}
