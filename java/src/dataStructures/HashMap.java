package dataStructures;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Optional;

public class HashMap<K, V> {
    private ArrayList<HashNode<K, V>> map;
    private int numberOfBuckets;

    public HashMap() {
        this.map = new ArrayList<>();
        this.numberOfBuckets = 10;

        // Create empty buckets
        for (int i = 0; i < this.numberOfBuckets; i++) {
            this.map.add(new HashNode<>());
        }
    }

    public V get(K key) {
        HashNode<K, V> bucket = this.getBucketForKey(key);
        if (bucket == null) {
            return null;
        }

        Optional<Pair<K, V>> pair = bucket.get(key);
        return pair.map(Pair::getValue).orElse(null);
    }

    public void put(K key, V value) {
        HashNode<K, V> bucket = this.getBucketForKey(key);
        bucket.add(key, value);
        System.out.println(String.format("Load factor is %s now", this.getLoadFactor()));
    }

    public void remove(K key) {
        HashNode<K, V> bucket = this.getBucketForKey(key);
        bucket.remove(key);
        System.out.println(String.format("Load factor is %s now", this.getLoadFactor()));
    }

    private HashNode<K, V> getBucketForKey(K key) {
        int hashCode = key.hashCode();
        int bucketIndex = hashCode % this.numberOfBuckets;

        System.out.println(String.format("Hashcode: %s, bucket: %s", hashCode, bucketIndex));
        return this.map.get(bucketIndex);
    }

    /**
     * Returns hash map's load factor, i.e ratio between buckets used and total number of buckets.
     */
    private float getLoadFactor() {
        float numberOfBucketsUsed = this.map.stream().filter(hashNode -> !hashNode.isEmpty()).count();
        return numberOfBucketsUsed / this.numberOfBuckets;
    }

    class HashNode<KeyType, ValueType> {
        private ArrayList<Pair<KeyType, ValueType>> nodes;

        public HashNode() {
            this.nodes = new ArrayList<>();
        }

        public Optional<Pair<KeyType, ValueType>> get(KeyType key) {
            // XXX 24 Mar 2019 blockost Keys are unique so there should be only one match
            return this.nodes.stream().filter(pair -> pair.getKey().equals(key)).findFirst();
        }

        public void add(KeyType key, ValueType value) {
            if (this.contains(key)) {
                System.err.println(String.format("Key %s already exist", key));
            } else {
                this.nodes.add(new Pair<>(key, value));
            }
        }

        public void remove(KeyType key) {
            Optional<Pair<KeyType, ValueType>> pair = this.get(key);
            pair.ifPresent(keyTypeValueTypePair -> this.nodes.remove(keyTypeValueTypePair));
        }

        public boolean contains(KeyType key) {
            return this.get(key).isPresent();
        }

        public boolean isEmpty() {
            return this.nodes.isEmpty();
        }
    }
}
