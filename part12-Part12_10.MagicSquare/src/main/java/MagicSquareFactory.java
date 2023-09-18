import java.util.stream.IntStream;

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm
        // here
        IntStream
                .range(0, size * size)
                .forEach(i -> {
                    int y = (size * size - i) % size;
                    int x = ((int) Math.floor(size / 2) + i) % size;

                    int dy = (i / size) * 2;
                    int dx = (i / size) * 1;

                    y = y + dy >= size ? (y + dy) % size : y + dy;
                    x = x - dx < 0 ? x - dx + size : x - dx;

                    square.placeValue(x, y, i + 1);
                    // System.out.println("number " + (i + 1) + ": y is " + y + " x is " + x);
                });

        return square;
    }

}
