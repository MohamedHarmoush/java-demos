package com.harmoush.ds.list;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {
    private final T[] arr;
    private int size;

    public ArrayList() {
        this(4);
    }

    public ArrayList(int capacity) {
        arr = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (isFull()) {
            throw new RuntimeException("ArrayList is full.");
        } else {
            arr[size++] = element;
        }
    }

    @Override
    public void insert(int position, T element) {
        if (!isValidPosition(size)) {
            throw new RuntimeException("ArrayList is full.");
        }

        System.arraycopy(arr, position, arr, position + 1, size - position);
        arr[position] = element;
        size++;
    }

    @Override
    public void set(int position, T element) {
        if (isValidPosition(position)) {
            arr[position] = element;
        } else {
            throw new IndexOutOfBoundsException(position);
        }
    }


    @Override
    public T remove(int position) {
        T removedElement = arr[position];
        System.arraycopy(arr, position + 1, arr, position, --size - position);
        return removedElement;
    }

    @Override
    public T remove(T element) {
        int index = indexOf(element);
        return isValidPosition(index) ? remove(index) : null;
    }

    @Override
    public T get(int position) {
        if (isValidPosition(position)) {
            return arr[position];
        }
        throw new IndexOutOfBoundsException(position);
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                return isValidPosition(idx) && idx < size;
            }

            @Override
            public T next() {
                return arr[idx++];
            }
        };
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < arr.length;
    }
}
