import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> hashmap;

    public IOU() {
        this.hashmap = new HashMap<String, Double>();
    }

    public void setSum(String toWhom, double amount) {
        hashmap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return hashmap.getOrDefault(toWhom, (double) 0);
    }
}
