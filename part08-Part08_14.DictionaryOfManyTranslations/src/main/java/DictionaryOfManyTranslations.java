import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<String, ArrayList<String>>();
    }

    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, new ArrayList<String>());
        ArrayList<String> translations = dictionary.get(word);
        translations.add(translation);
    }

    public ArrayList<String> translate(String word) {
        dictionary.putIfAbsent(word, new ArrayList<String>());
        ArrayList<String> translations = dictionary.get(word);
        return translations;
    }

    public void remove(String word) {
        dictionary.remove(word);
    }

}
