
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
        HashMap<String, Book> hashmap = new HashMap<>();
        hashmap.put("sense", new Book("Sensibility", 1811, "..."));
        hashmap.put("prejudice", new Book("pride", 1813, "...."));
        hashmap.put("happy", new Book("Don't let the pigeon drive the bus", 2003, "...."));

        printValues(hashmap);
        System.out.println("---");
        printValueIfNameContains(hashmap, "ide");
    }

    public static void printValues(HashMap<String, Book> hashmap) {
        for (String alias : hashmap.keySet()) {
            System.out.println(hashmap.get(alias));
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        for (String alias : hashmap.keySet()) {
            String name = hashmap.get(alias).getName();

            if (name.contains(text.trim())) {
                System.out.println(hashmap.get(alias));
            }
        }
    }
}
