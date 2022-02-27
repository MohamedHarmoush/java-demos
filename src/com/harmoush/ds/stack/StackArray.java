package com.harmoush.ds.stack;

import java.util.Iterator;
import java.util.function.Consumer;

public class StackArray<T> implements Stack<T> {

    private final int capacity;
    private T[] arr;
    private int top;

    public StackArray(int size) {
        arr = (T[]) new Object[size];
        capacity = size;
        top = -1;
    }

    public StackArray() {
        this(10);
    }

    @Override
    public void push(T element) throws Exception {
        if (isFull()) {
            throw new Exception("Stack OverFlow");
        } else {
            arr[++top] = element;
        }
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty.");
        } else {
            return arr[top--];
        }
    }

    @Override
    public T top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty.");
        } else {
            return arr[top];
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[capacity];
        top = -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = top;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return arr[index--];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = top; i >= 0; i--) {
            action.accept(arr[i]);
        }
    }
}
