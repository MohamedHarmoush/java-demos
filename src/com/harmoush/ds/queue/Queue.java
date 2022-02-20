package com.harmoush.ds.queue;

import com.harmoush.ds.Collection;

public interface Queue<T> extends Collection<T> {

    void enqueue(T element) throws Exception;

    T dequeue();

    T top();

    void clear();
}
