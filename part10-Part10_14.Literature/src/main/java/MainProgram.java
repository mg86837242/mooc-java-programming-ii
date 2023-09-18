
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Book> books = new ArrayList<>();

            while (true) {
                System.out.print("Input the name of the book, empty stops: ");
                String name = scanner.nextLine();

                if (name.equals("")) {
                    break;
                }

                System.out.print("Input the age recommendation: ");
                int age = Integer.valueOf(scanner.nextLine());

                books.add(new Book(name, age));
                System.out.println();
            }

            if (books.size() == 1) {
                System.out.println("\n" + books.size() + " book in total.\n\nBook:");
            } else {
                System.out.println("\n" + books.size() + " books in total.\n\nBooks:");
            }

            Comparator<Book> comparator = Comparator
                    .comparing(Book::getAgeRecommendation)
                    .thenComparing(Book::getName);

            books
                    .stream()
                    .sorted(comparator)
                    .forEach(book -> System.out.println(book));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
