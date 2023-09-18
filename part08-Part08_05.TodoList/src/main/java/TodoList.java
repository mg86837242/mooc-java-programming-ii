import java.util.ArrayList;

public class TodoList {

  private ArrayList<String> todoList;

  public TodoList() {
    this.todoList = new ArrayList<String>();
  }

  public void add(String task) {
    todoList.add(task);
  }

  public void print() {
    int i = 1;

    for (String todo : todoList) {
      System.out.println(i + ": " + todo);
      i++;
    }
  }

  public void remove(int number) {
    todoList.remove(number - 1);
  }
}
