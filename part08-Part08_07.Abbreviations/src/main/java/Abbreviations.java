import java.util.HashMap;

public class Abbreviations {

    private HashMap<String, String> dictionary;

    public Abbreviations() {
        this.dictionary = new HashMap<String, String>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        dictionary.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return dictionary.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        if (hasAbbreviation(abbreviation)) {
            return dictionary.get(abbreviation);
        } else {
            return null;
        }
    }
}
