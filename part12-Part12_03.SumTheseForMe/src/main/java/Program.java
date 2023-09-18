
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here
        int[] numbers = { 3, -1, 8, 4 };

        System.out.println(sum(numbers, 0, 0, 0, 0));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));
    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        int from = fromWhere < 0 ? 0 : fromWhere;
        int to = toWhere > array.length ? array.length : toWhere;
        int sum = 0;

        for (int i = from; i < to; i++) {
            int cv = array[i];

            if (cv >= smallest && cv <= largest) {
                sum += cv;
            }
        }

        return sum;
    }
}
