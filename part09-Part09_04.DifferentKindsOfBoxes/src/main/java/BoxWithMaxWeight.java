import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<Item>();
    }

    @Override
    public void add(Item item) {
        int currentTotalWeight = items.stream().mapToInt(item -> item.getWeight()).sum();

        if (currentTotalWeight + item.getWeight() <= capacity) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
