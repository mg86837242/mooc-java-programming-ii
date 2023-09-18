import java.util.Scanner;

public class UserInterface {

  private TodoList todoList;
  private Scanner scanner;

  public UserInterface(TodoList todoList, Scanner scanner) {
    this.todoList = todoList;
    this.scanner = scanner;
  }

  public void start() {
    while (true) {
      System.out.print("Command: ");
      String command = scanner.nextLine();

      if (command.equals("stop")) {
        break;
      }

      switch (command) {
        case "add":
          System.out.print("To add: ");
          String toAdd = scanner.nextLine();
          todoList.add(toAdd);
          break;
        case "list":
          todoList.print();
          break;
        case "remove":
          System.out.print("Which one is removed? ");
          int indexToRemove = Integer.valueOf(scanner.nextLine());
          todoList.remove(indexToRemove);
          break;
        default:
          System.out.println("Unknown command");
      }
    }
  }
}
