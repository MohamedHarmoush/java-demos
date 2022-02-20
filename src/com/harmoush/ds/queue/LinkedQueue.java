package com.harmoush.ds.queue;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {

    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) throws Exception {
        QueueNode<T> newNode = new QueueNode<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public T dequeue() {
        if (front == null) {
            throw new RuntimeException("List is empty..");
        }
        QueueNode<T> firstNode = front;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return firstNode.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public T top() {
        return front != null ? front.data : null;
    }

    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private QueueNode<T> nextNode = front;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public T next() {
                QueueNode<T> currNode = this.nextNode;
                nextNode = nextNode.next;
                return currNode.data;
            }
        };
    }

    public static class QueueNode<T> {
        public T data;
        public QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }
}
