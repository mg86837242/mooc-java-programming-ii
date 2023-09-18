import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> hashmap;

    public VehicleRegistry() {
        this.hashmap = new HashMap<LicensePlate, String>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (hashmap.get(licensePlate) == null) {
            hashmap.put(licensePlate, owner);
            return true;
        } else {
            return false;
        }
    }

    public String get(LicensePlate licensePlate) {
        return hashmap.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (hashmap.containsKey(licensePlate)) {
            hashmap.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }

    public void printLicensePlates() {
        for (LicensePlate licensePlate : hashmap.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        List<String> ownersSet = new ArrayList<String>();

        for (String owner : hashmap.values()) {
            if (!ownersSet.contains(owner)) {
                System.out.println(owner);
                ownersSet.add(owner);
            }
        }
    }
}
