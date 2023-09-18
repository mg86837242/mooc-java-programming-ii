
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("How many random numbers should be printed?");
            int size = scanner.nextInt();

            Random rand = new Random();
            IntStream
                    .range(0, size)
                    .forEach(idx -> System.out.println(rand.nextInt(11)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
