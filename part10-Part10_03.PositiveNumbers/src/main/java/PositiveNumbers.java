
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<Integer> numbers = Stream.of(1, 2, 3, 4, -1, -2, -3).collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(positive(numbers));
    }

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream().filter(number -> number > 0).collect(Collectors.toCollection(ArrayList::new));
    }
}
