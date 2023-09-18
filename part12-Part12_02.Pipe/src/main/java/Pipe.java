import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {

    private List<T> elements;

    public Pipe() {
        this.elements = new ArrayList<T>();
    }

    public void putIntoPipe(T value) {
        this.elements.add(value);
    }

    public T takeFromPipe() {
        if (elements.isEmpty()) {
            return null;
        }

        T toBeTaken = elements.get(0);
        elements.remove(0);
        return toBeTaken;
    }

    public boolean isInPipe() {
        return elements.isEmpty() ? false : true;
    }
}
