package com.harmoush.ds.stack;

import java.util.Iterator;

public class StackLinkedList<T> implements Stack<T> {

    private StackNode<T> root;
    private int size;

    public StackLinkedList() {
        root = null;
        size = 0;
    }

    @Override
    public void push(T element) throws Exception {
        StackNode<T> node = new StackNode<>(element);
        node.setNext(root);
        root = node;
        size++;
    }

    @Override
    public T pop() throws Exception {
        StackNode<T> node = root;
        root = node.getNext();
        size--;
        T data = node.getData();
        node.setNext(null);
        return data;
    }

    @Override
    public T top() throws Exception {
        return root.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private StackNode<T> ptr = root;

            @Override
            public boolean hasNext() {
                return ptr != null;
            }

            @Override
            public T next() {
                T data = ptr.getData();
                ptr = ptr.getNext();
                return data;
            }
        };
    }

    public static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        public StackNode(T element, StackNode<T> next) {
            this.data = element;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public StackNode<T> getNext() {
            return next;
        }

        public void setNext(StackNode<T> next) {
            this.next = next;
        }
    }
}
