package com.harmoush.ds.hashtable;

import java.util.List;

public interface Map<K, V> extends Iterable<K> {

    void clear();

    void put(K key, V value);

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    boolean isEmpty();

    int size();

    List<K> keys();

    List<V> values();

    void remove(K key);
}
