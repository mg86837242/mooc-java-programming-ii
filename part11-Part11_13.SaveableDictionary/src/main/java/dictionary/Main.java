package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        boolean loadedSuccessfully = dictionary.load();
        if (loadedSuccessfully) {
            System.out.println("Successfully loaded the dictionary from file");
        }

        dictionary.add("ohjelmointi", "programming");
        dictionary.add("tietokone", "computer");

        boolean savedSuccessfully = dictionary.save();
        if (savedSuccessfully) {
            System.out.println("Successfully saved the dictionary to file");
        }
    }
}
