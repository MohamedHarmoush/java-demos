package com.harmoush.ds.list;

import com.harmoush.ds.Collection;

public interface List<T> extends Collection<T> {

    void add(T element);

    void insert(int position, T element);

    void set(int position, T element);

    T remove(int position);

    T remove(T element);

    T get(int position);

    int indexOf(T element);

    void clear();
}
