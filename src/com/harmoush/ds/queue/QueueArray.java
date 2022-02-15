package com.harmoush.ds.queue;

public class QueueArray<T> implements Queue<T> {
    private final T[] arr;
    private int size;
    private int front;
    private int rear;

    public QueueArray() {
        front = 0;
        rear = 0;
        size = 0;
        arr = (T[]) new Object[3];
    }

    @Override
    public void enqueue(T element) throws Exception {
        if (!isFull()) {
            arr[rear] = element;
            rear = increment(rear);
            size++;
        } else {
            throw new Exception("Queue is overflow.");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T element = arr[front];
            front = increment(front);
            size--;
            return element;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T top() {
        return isEmpty() ? null : arr[front];
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {
        StringBuilder builder = new StringBuilder("[");
        int idx = front;
        boolean hasNext = !isEmpty();
        while (hasNext) {
            builder.append(arr[idx]);
            idx = increment(idx);
            hasNext = hasNext(idx);

            if (hasNext) {
                builder.append(", ");
            }
        }
        builder.append("]");
        System.out.println("queue = " + builder);
    }

    private boolean hasNext(int idx) {
        return idx != rear;
    }

    private int increment(int index) {
        return ++index % arr.length;
    }
}
