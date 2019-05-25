package dataStructures;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", this.key, this.value);
    }
}
