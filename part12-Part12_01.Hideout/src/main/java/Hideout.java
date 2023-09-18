public class Hideout<T> {

    private T element;

    public Hideout() {
        this.element = null;
    }

    public void putIntoHideout(T toHide) {
        this.element = toHide;
    }

    public T takeFromHideout() {
        T toBeTaken = this.element;
        this.element = null;
        return toBeTaken;
    }

    public boolean isInHideout() {
        return this.element != null;
    }
}
