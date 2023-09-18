
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // NB The following method is created only for testing purposes
    public void morphIntoSampleSquare() {
        // "array constants can only be used in initializers"
        // https://stackoverflow.com/questions/6348479/arrays-constants-can-only-be-used-in-initializers-error
        this.square = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        return IntStream
                .range(0, getWidth())
                .map(i -> {
                    return IntStream
                            .range(0, getHeight())
                            .reduce(0, (sum, j) -> sum + square[i][j]);
                })
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> sumsOfColumns() {
        return IntStream
                .range(0, getHeight())
                .map(j -> {
                    return IntStream
                            .range(0, getWidth())
                            .reduce(0, (sum, i) -> sum + square[i][j]);
                })
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        int nwToSESum = 0;
        for (int i = 0; i < getWidth(); i++) {
            nwToSESum += square[i][i];
        }

        int neToSWSum = 0;
        for (int i = 0; i < getWidth(); i++) {
            neToSWSum += square[i][getWidth() - i - 1];
        }

        // "java how to initialize an arraylist with values":
        // https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
        return new ArrayList<>(Arrays.asList(nwToSESum, neToSWSum));
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return -1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
