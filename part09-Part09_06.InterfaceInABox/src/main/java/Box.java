import java.util.ArrayList;

public class Box implements Packable {

    private double capacity;
    private ArrayList<Packable> items;
    private int count;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
        this.count = 0;
    }

    public double weight() {
        return items.stream().mapToDouble(i -> i.weight()).sum();
    }

    public void add(Packable item) {
        if (weight() + item.weight() <= capacity) {
            items.add(item);
            count++;
        }
    }

    @Override
    public String toString() {
        return "Box: " + count + " items, total weight " + weight() + " kg";
    }
}
