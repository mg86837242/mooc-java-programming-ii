import java.util.stream.IntStream;

public class Program {

    public static void main(String[] args) {
        // You can test the class here
        HashMap<String, String> hashmap = new HashMap<String, String>();
        System.out.println("----------Using `IntStream` to fill sample data----------");
        IntStream
                .range(0, 24)
                .forEach(idx -> hashmap.put(String.valueOf(idx), "foo"));
        System.out.println("Hashmap size is: " + hashmap.size());
        System.out.println("Array length is: " + hashmap.getArrayLength());
        System.out.println("Key '23' holds the value of: " + hashmap.get("23"));

        // System.out.println("----------Testing`printArrayElementLengths()`method----------");
        // System.out.println("Each array element's length is listed as follows:");
        // hashmap.printArrayElementLengths();

        System.out.println("----------Testing `remove()` method----------");
        hashmap.remove("23");
        System.out.println("Hashmap size is: " + hashmap.size());
        System.out.println("Array length is: " + hashmap.getArrayLength());
        System.out.println("Key '23' holds the value of: " + hashmap.get("23"));

        System.out.println("----------Testing `grow()` method----------");
        hashmap.put("23", "bar");
        System.out.println("Hashmap size is: " + hashmap.size());
        System.out.println("Array length is: " + hashmap.getArrayLength());
        System.out.println("Key '23' holds the value of: " + hashmap.get("23"));
        hashmap.put("24", "bar");
        System.out.println("Hashmap size is: " + hashmap.size());
        System.out.println("Array length is: " + hashmap.getArrayLength());
        System.out.println("Key '24' holds the value of: " + hashmap.get("24"));
    }

}
