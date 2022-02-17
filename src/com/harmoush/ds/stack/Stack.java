package com.harmoush.ds.stack;

import com.harmoush.ds.Collection;

public interface Stack<T> extends Collection<T> {

    void push(T element) throws Exception;

    T pop() throws Exception;

    T top() throws Exception;
}
