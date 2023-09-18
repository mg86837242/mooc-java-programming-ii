import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {

    private List<Movable> movables;

    public Herd() {
        this.movables = new ArrayList<>();
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < movables.size(); i++) {
            if (i == movables.size() - 1) {
                str = str + movables.get(i).toString();
            } else {
                str = str + movables.get(i).toString() + "\n";
            }
        }

        return str;
    }

    public void addToHerd(Movable movable) {
        movables.add(movable);
    }

    public void move(int dx, int dy) {
        movables.stream().forEach(movable -> movable.move(dx, dy));
    }
}
