import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {

    private ArrayList<Double> balanceHistories;

    public ChangeHistory() {
        this.balanceHistories = new ArrayList<Double>();
    }

    public void add(double status) {
        balanceHistories.add(status);
    }

    public void clear() {
        balanceHistories.clear();
    }

    public double maxValue() {
        if (balanceHistories.isEmpty()) {
            return 0;
        }

        return Collections.max(balanceHistories);
    }

    public double minValue() {
        if (balanceHistories.isEmpty()) {
            return 0;
        }

        return Collections.min(balanceHistories);
    }

    public double average() {
        if (balanceHistories.isEmpty()) {
            return 0;
        }

        return balanceHistories.stream().mapToDouble(history -> history).average().orElse(0);
    }

    public String toString() {
        return balanceHistories.toString();
    }
}
