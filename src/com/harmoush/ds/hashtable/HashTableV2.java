package com.harmoush.ds.hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class HashTableV2<K, V> implements Map<K, V> {

    private Entry<K, V>[] table;
    private int count;

    public HashTableV2() {
        this(11);
    }

    public HashTableV2(int initialCapacity) {
        initializeHashTable(initialCapacity);
    }

    @Override
    public void clear() {
        initializeHashTable(11);
    }

    @Override
    public void put(K key, V value) {
        int idx = hash(key);
        table[idx] = new Entry<>(key, value);
        count++;
    }

    @Override
    public boolean containsKey(K key) {
        if (isEmpty()) {
            return false;
        }
        int idx = hash(key);
        return table[idx] != null && table[idx].getKey().equals(key);
    }

    @Override
    public boolean containsValue(V value) { // O(n)
        if (isEmpty()) {
            return false;
        }
        int idx;
        for (Entry<K, V> entry : table) {
            idx = hash(entry.getKey());
            if (table[idx] != null && table[idx].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (isEmpty()) {
            return null;
        }
        int idx = hash(key);
        return table[idx].getValue();
    }

    public boolean isFull() {
        return count == table.length;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public List<K> keys() {
        return isEmpty() ? new ArrayList<>() : Arrays.stream(table).filter(Objects::nonNull).map(Entry::getKey).toList();
    }

    @Override
    public List<V> values() {
        return isEmpty()
                ? new ArrayList<>()
                : Arrays.stream(table)
                .filter(Objects::nonNull).map(Entry::getValue)
                .collect(Collectors.toList());
//       or
//        return isEmpty() ? new ArrayList<>() : Arrays.stream(entries).filter(Objects::nonNull).map(Entry::getValue).toList();
    }

    @Override
    public void remove(K key) {
        if (containsKey(key)) {
            int idx = hash(key);
            table[idx] = null;
            count--;
        }
    }

    private void initializeHashTable(int initialCapacity) {
        table = (Entry<K, V>[]) new Entry[initialCapacity];
        count = 0;
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return hashCode % table.length;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    public record Entry<K, V>(K key, V value) {

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
