
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Container firstContainer = new Container();
            Container secondContainer = new Container();

            while (true) {
                System.out.println("First container: " + firstContainer.toString());
                System.out.println("Second container: " + secondContainer.toString());

                String input = scanner.nextLine();
                if (input.equals("quit")) {
                    break;
                }

                String[] parts = input.split(" ");
                String command = parts[0];
                int amount = Integer.valueOf(parts[1]);

                switch (command) {
                    case "add":
                        firstContainer.add(amount);
                        break;
                    case "move":
                        int moveAmt = Math.min(amount, firstContainer.contains());
                        firstContainer.remove(moveAmt);
                        secondContainer.add(moveAmt);
                        break;
                    case "remove":
                        secondContainer.remove(amount);
                        break;

                    default:
                        System.out.println("Unknown command");
                }
            }
        } catch (Exception e) {
            System.out.println("There was an error: " + e.getMessage());
        }
    }

}
