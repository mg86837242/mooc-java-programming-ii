package dictionary;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveableDictionary {

    private Map<String, String> dictionary;
    private String fileName;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.fileName = file;
    }

    public void add(String word, String translation) {
        if (!dictionary.containsKey(word) && !dictionary.containsKey(translation)) {
            dictionary.put(word, translation);
            dictionary.put(translation, word);
        }
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public void delete(String word) {
        String translation = dictionary.get(word);

        dictionary.remove(word);
        dictionary.remove(translation);
    }

    public boolean load() {
        try {
            Files
                    .lines(Paths.get(fileName))
                    .forEach(line -> {
                        String[] parts = line.split(":");
                        add(parts[0], parts[1]);
                    });

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean save() {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            List<String> writerPrinted = new ArrayList<>();

            dictionary
                    .keySet()
                    .stream()
                    .forEach(key -> {
                        if (!writerPrinted.contains(key)) {
                            writerPrintln(writer, key);

                            writerPrinted.add(key);
                            writerPrinted.add(dictionary.get(key));
                        }
                    });

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void writerPrintln(PrintWriter writer, String key) {
        StringBuilder line = new StringBuilder(key)
                .append(":")
                .append(dictionary.get(key));
        writer.println(line);
    }
}
