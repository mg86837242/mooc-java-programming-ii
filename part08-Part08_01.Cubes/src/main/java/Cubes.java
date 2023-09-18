
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();

                if (input.equals("end")) {
                    break;
                }

                int num = Integer.valueOf(input);
                int cube = num * num * num;
                System.out.println(cube);
            }
        } catch (Exception e) {
            System.out.println("Input is neither a number nor the string 'end'");
        }

    }
}
