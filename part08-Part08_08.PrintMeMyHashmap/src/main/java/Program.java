
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("f.e", "for example");
        hashmap.put("etc.", "and so on");
        hashmap.put("i.e", "more precisely");

        printKeys(hashmap);
        System.out.println("---");
        printKeysWhere(hashmap, "i");
        System.out.println("---");
        printValuesOfKeysWhere(hashmap, ".e");
    }

    public static void printKeys(HashMap<String, String> hashmap) {
        List<String> abbreviations = new ArrayList<String>(hashmap.keySet());

        Collections.reverse(abbreviations);

        for (String abbreviation : abbreviations) {
            System.out.println(abbreviation);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        List<String> abbreviations = new ArrayList<String>(hashmap.keySet());

        Collections.reverse(abbreviations);

        for (String abbreviation : abbreviations) {
            if (abbreviation.contains(text.trim())) {
                System.out.println(abbreviation);
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        List<String> abbreviations = new ArrayList<String>(hashmap.keySet());

        Collections.reverse(abbreviations);

        for (String abbreviation : abbreviations) {
            if (abbreviation.contains(text.trim())) {
                System.out.println(hashmap.get(abbreviation));
            }
        }
    }

}
