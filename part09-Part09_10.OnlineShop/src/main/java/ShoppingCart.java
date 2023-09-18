import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> productsAndItems;

    public ShoppingCart() {
        this.productsAndItems = new HashMap<>();
    }

    public void add(String product, int price) {
        productsAndItems.putIfAbsent(product, new Item(product, 0, price));
        productsAndItems.get(product).increaseQuantity();
    }

    public int price() {
        return productsAndItems.values().stream().mapToInt(item -> item.price()).sum();
    }

    public void print() {
        productsAndItems.values().stream().forEach(item -> System.out.println(item));
    }
}
