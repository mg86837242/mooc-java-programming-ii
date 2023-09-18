
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        Random rand = new Random();

        while (numbers.size() < 7) {
            int num = rand.nextInt(40) + 1;

            if (!containsNumber(num)) {
                this.numbers.add(num);
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return numbers.contains(number);
    }
}
