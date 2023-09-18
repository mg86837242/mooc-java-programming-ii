import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> productsAndPrices;
    private Map<String, Integer> productsAndStock;

    public Warehouse() {
        this.productsAndPrices = new HashMap<>();
        this.productsAndStock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        productsAndPrices.put(product, price);
        productsAndStock.put(product, stock);
    }

    public int price(String product) {
        if (productsAndPrices.containsKey(product)) {
            return productsAndPrices.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (productsAndStock.containsKey(product)) {
            return productsAndStock.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {
        if (productsAndStock.containsKey(product) && productsAndStock.get(product) >= 1) {
            productsAndStock.put(product, productsAndStock.get(product) - 1);
            return true;
        } else {
            return false;
        }
    }

    public Set<String> products() {
        return productsAndPrices.keySet();
    }
}
