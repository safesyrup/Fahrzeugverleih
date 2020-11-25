import java.util.ArrayList;
import java.util.List;

public class RentContainer {
    private static List<Rent> rents = new ArrayList<>();

    public List<Rent> getRents() {
        return rents;
    }

    public static void setRents(List<Rent> rents) {
        RentContainer.rents = rents;
    }

    public static void addRent(Rent r) {
        rents.add(r);
    }
}
