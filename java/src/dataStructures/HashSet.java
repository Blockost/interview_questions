package dataStructures;

/**
 * {@link HashSet} uses a {@link HashMap} internally.
 */
public class HashSet<T> {
    private static final Object PRESENT = new Object();
    private HashMap<T, Object> map = new HashMap<>();

    public void add(T data) {
        this.map.put(data, PRESENT);
    }

    public void remove(T data) {
        this.map.remove(data);
    }

    public int size() {
        return this.map.size();
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}
