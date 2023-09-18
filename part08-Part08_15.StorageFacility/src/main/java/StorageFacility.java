import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
        this.storage = new HashMap<String, ArrayList<String>>();
    }

    public void add(String unit, String item) {
        storage.putIfAbsent(unit, new ArrayList<String>());
        storage.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return storage.getOrDefault(storageUnit, new ArrayList<String>());
    }

    public void remove(String storageUnit, String item) {
        if (!storage.containsKey(storageUnit)) {
            return;
        }

        storage.get(storageUnit).remove(item);

        if (storage.get(storageUnit).isEmpty()) {
            storage.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnits = new ArrayList<String>();

        for (String storageUnit : storage.keySet()) {
            if (!storageUnits.contains(storageUnit)) {
                storageUnits.add(storageUnit);
            }
        }

        return storageUnits;
    }

}
