import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {

    private List<Pair<K, V>>[] arr;
    private int firstFreeIndex;

    public HashMap() {
        this.arr = new List[32];
        this.firstFreeIndex = 0;
    }

    public V get(K key) {
        int hashCode = Math.abs(key.hashCode() % arr.length);
        if (arr[hashCode] == null || arr[hashCode].size() == 0) {
            return null;
        }

        List<Pair<K, V>> targetPairList = arr[hashCode];
        for (int i = 0; i < targetPairList.size(); i++) {
            Pair<K, V> currentPair = targetPairList.get(i);
            if (currentPair.getKey() == key || currentPair.getKey().equals(key)) {
                return currentPair.getValue();
            }
        }

        return null;
    }

    public void put(K key, V value) {
        List<Pair<K, V>> targetPairList = getPairListFromArr(key);
        int indexOfTargetPair = getIndexOfPairFromPairList(key, targetPairList);

        if (indexOfTargetPair < 0) {
            // i.e., no such pair with the same key exists in the pair list
            Pair<K, V> newPair = new Pair<>(key, value);
            targetPairList.add(newPair);
            firstFreeIndex++;

            if (1.0 * firstFreeIndex > 0.75 * arr.length) {
                grow();
            }
        } else {
            // i.e., there's a pair with the same key already exists in the pair list
            targetPairList.get(indexOfTargetPair).setValue(value);
        }
    }

    private List<Pair<K, V>> getPairListFromArr(K key) {
        int hashCode = Math.abs(key.hashCode() % arr.length);
        if (arr[hashCode] == null) {
            arr[hashCode] = new ArrayList<>();
        }

        return arr[hashCode];
    }

    private int getIndexOfPairFromPairList(K key, List<Pair<K, V>> pairList) {
        for (int i = 0; i < pairList.size(); i++) {
            if (pairList.get(i).getKey() == key || pairList.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void grow() {
        List<Pair<K, V>>[] newArr = new List[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            copyPairList(newArr, i);
        }

        this.arr = newArr;
    }

    private void copyPairList(List<Pair<K, V>>[] newArr, int indexOfPairList) {
        if (arr[indexOfPairList] == null) {
            return;
        }

        List<Pair<K, V>> pairList = arr[indexOfPairList];
        for (int i = 0; i < pairList.size(); i++) {
            Pair<K, V> pair = pairList.get(i);

            int newHashValue = Math.abs(pair.getKey().hashCode() % newArr.length);
            if (newArr[newHashValue] == null) {
                newArr[newHashValue] = new ArrayList<>();
            }

            newArr[newHashValue].add(pair);
        }
    }

    public V remove(K key) {
        int hashCode = Math.abs(key.hashCode() % arr.length);
        if (arr[hashCode] == null || arr[hashCode].size() == 0) {
            return null;
        }

        List<Pair<K, V>> targetPairList = arr[hashCode];

        for (int i = 0; i < targetPairList.size(); i++) {
            if (targetPairList.get(i).getKey() == key || targetPairList.get(i).getKey().equals(key)) {
                V value = targetPairList.get(i).getValue();
                targetPairList.remove(i);
                firstFreeIndex--;
                return value;
            }
        }

        return null;
    }

    public int getArrayLength() {
        return arr.length;
    }

    public void printArrayElementLengths() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i].size());
            } else {
                System.out.println("null");
            }
        }
    }

    public int size() {
        return firstFreeIndex;
    }
}
