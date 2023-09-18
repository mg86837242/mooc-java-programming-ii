
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int firstAmt = 0;
            int secondAmt = 0;

            while (true) {
                System.out.println("First container: " + firstAmt + "/100");
                System.out.println("Second container: " + secondAmt + "/100");

                String input = scanner.nextLine();
                if (input.equals("quit")) {
                    break;
                }

                String[] parts = input.split(" ");
                String command = parts[0];
                int amount = Integer.valueOf(parts[1]);

                switch (command) {
                    case "add":
                        if (amount > 0) {
                            firstAmt = Math.min(firstAmt + amount, 100);
                            break;
                        }
                    case "move":
                        if (amount > 0) {
                            int moveAmt = Math.min(amount, firstAmt);
                            firstAmt -= moveAmt;
                            secondAmt = Math.min(secondAmt + moveAmt, 100);
                            break;
                        }
                    case "remove":
                        if (amount > 0) {
                            secondAmt = Math.max(secondAmt - amount, 0);
                            break;
                        }
                    default:
                        System.out.println("Unknown command");
                }
            }
        } catch (Exception e) {
            System.out.println("There was an error: " + e.getMessage());
        }
    }

}
