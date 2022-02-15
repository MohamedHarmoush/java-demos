package com.harmoush.ds.queue;

public interface Queue<T> {

    void enqueue(T element) throws Exception;

    T dequeue();

    boolean isEmpty();

    T top();

    boolean isFull();

    int size();
}
