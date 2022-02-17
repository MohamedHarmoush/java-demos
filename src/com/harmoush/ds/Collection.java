package com.harmoush.ds;

public interface Collection<T> extends Iterable<T> {

    boolean isFull();

    boolean isEmpty();

    int size();
}
