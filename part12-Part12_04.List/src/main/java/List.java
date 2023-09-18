public class List<T> {

    private T[] arr;
    private int firstFreeIndex;

    public List() {
        this.arr = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T element) {
        if (firstFreeIndex >= arr.length) {
            grow();
        }

        arr[firstFreeIndex] = element;
        firstFreeIndex++;
    }

    private void grow() {
        int newSize = arr.length + arr.length / 2;
        T[] newArr = (T[]) new Object[newSize];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public boolean contains(T element) {
        return indexOfElement(element) >= 0;
    }

    public void remove(T element) {
        int indexOfToBeRemoved = indexOfElement(element);
        if (indexOfToBeRemoved < 0) {
            return;
        }

        shiftElementsLeftFrom(indexOfToBeRemoved);
        firstFreeIndex--;
    }

    public int indexOfElement(T element) {
        for (int i = 0; i < firstFreeIndex; i++) {
            if (arr[i] == element || arr[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    private void shiftElementsLeftFrom(int index) {
        for (int i = index; i < firstFreeIndex; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public T get(int index) {
        if (index < 0 || index > firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index" + index + " out of bounds [0, " + firstFreeIndex + "]");
        }

        return arr[index];
    }

    public int size() {
        return firstFreeIndex;
    }
}
