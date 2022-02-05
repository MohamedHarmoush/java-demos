package com.harmoush.ds.stack;

public interface Stack<T> extends Iterable<T> {

    void push(T element) throws Exception;

    T pop() throws Exception;

    T top() throws Exception;

    boolean isEmpty();

    boolean isFull();

    int size();
}
