import java.util.ArrayList;

public class OneItemBox extends Box {

    private int capacity;
    private ArrayList<Item> items;

    public OneItemBox() {
        this.capacity = 1;
        this.items = new ArrayList<Item>();
    }

    @Override
    public void add(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
