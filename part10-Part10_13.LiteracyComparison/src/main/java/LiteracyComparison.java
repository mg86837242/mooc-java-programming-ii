
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {

    public static void main(String[] args) {
        try {
            Files
                    .lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .map(parts -> new Stats(parts[0].trim(), parts[1].trim(), parts[2].trim().split(" ")[0].trim(),
                            parts[3].trim(),
                            Integer.valueOf(parts[4].trim()),
                            Double.valueOf(parts[5].trim())))
                    .sorted((s1, s2) -> s1.getLiteracyPercent() - s2.getLiteracyPercent() == 0 ? 0
                            : s1.getLiteracyPercent() - s2.getLiteracyPercent() > 0 ? 1 : -1)
                    .forEach(stats -> System.out.println(stats));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
