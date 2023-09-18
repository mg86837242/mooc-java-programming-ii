
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        System.out.println("Input numbers, type 'end' to stop.");
        List<Double> inputs = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }
            inputs.add(Double.valueOf(input));
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String sign = scanner.nextLine();

        if (sign.equals("n")) {
            double average = inputs.stream().mapToDouble(input -> input).filter(number -> number < 0).average()
                    .orElse(0);
            System.out.println("average of the negative numbers: " + average);
        } else if (sign.equals("p")) {
            double average = inputs.stream().mapToDouble(input -> input).filter(number -> number > 0).average()
                    .orElse(0);
            System.out.println("average of the positive numbers: " + average);
        } else {
            System.out.println("Unknown command: need to enter 'n' or 'p'");
        }

        scanner.close();
    }
}
