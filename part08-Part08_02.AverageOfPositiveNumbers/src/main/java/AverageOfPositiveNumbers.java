
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int sum = 0;
            int count = 0;

            while (true) {
                int num = Integer.valueOf(scanner.nextLine());

                if (num > 0) {
                    sum += num;
                    count++;
                } else if (num == 0) {
                    if (count == 0) {
                        System.out.println("Cannot calculate the average");
                        break;
                    } else {
                        System.out.println((double) (1.0 * sum / count));
                        break;
                    }
                } else {
                    continue;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input cannot be parsed as a number");
        } catch (Exception e) {
            System.out.println("An unknown exception occurred");
        }

    }
}
