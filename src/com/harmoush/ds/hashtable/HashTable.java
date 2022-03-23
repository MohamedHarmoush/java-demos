package com.harmoush.ds.hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class HashTable<K, V> implements Map<K, V> {

    private K[] keys;
    private V[] values;
    private int count;

    public HashTable() {
        this(11);
    }

    public HashTable(int initialCapacity) {
        initializeHashTable(initialCapacity);
    }

    @Override
    public void clear() {
        initializeHashTable(11);
    }

    @Override
    public void put(K key, V value) {
        int idx = hash(key);
        keys[idx] = key;
        values[idx] = value;
        count++;
    }

    @Override
    public boolean containsKey(K key) {
        if (isEmpty()) {
            return false;
        }
        int idx = hash(key);
        return keys[idx] != null && keys[idx].equals(key);
    }

    @Override
    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        int idx;
        for (K key : keys) {
            idx = hash(key);
            if (values[idx] != null && values[idx].equals(value)) {
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
        return values[idx];
    }

    public boolean isFull() {
        return count == keys.length;
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
        return isEmpty() ? new ArrayList<>() : Arrays.stream(keys).filter(Objects::nonNull).toList();
    }

    @Override
    public List<V> values() {
        return isEmpty() ? new ArrayList<>() : Arrays.stream(values).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public void remove(K key) {
        if (containsKey(key)) {
            int idx = hash(key);
            keys[idx] = null;
            values[idx] = null;
            count--;
        }
    }

    private void initializeHashTable(int initialCapacity) {
        keys = (K[]) new Object[initialCapacity];
        values = (V[]) new Object[initialCapacity];
        count = 0;
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return hashCode % keys.length;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
