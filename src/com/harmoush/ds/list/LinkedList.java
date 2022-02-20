package com.harmoush.ds.list;

import java.util.Iterator;
import java.util.Optional;

public class LinkedList<T> implements List<T> {

    private ListNode<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        ListNode<T> newNode = new ListNode<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            ListNode<T> ptr = head;
            while (ptr.next().isPresent()) {
                ptr = ptr.next;
            }

            ptr.next = newNode;
        }
        size++;
    }

    @Override
    public void insert(int position, T element) {
        if (!isValidPosition(position)) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> newNode = new ListNode<>(element);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode<T> ptr = getNode(position - 1);
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
        size++;
    }

    @Override
    public void set(int position, T element) {
        if (!isValidPosition(position)) {
            throw new IndexOutOfBoundsException(position);
        }
        ListNode<T> currNode = getNode(position);
        currNode.data = element;
    }

    @Override
    public T remove(int position) {
        if (!isValidPosition(position)) {
            return null;
        }
        ListNode<T> removedNode;
        if (position == 0) {
            removedNode = head;
            head = head.next;
        } else {
            ListNode<T> prevNode = getNode(position - 1);
            removedNode = prevNode.next;
            prevNode.next = removedNode.next;
        }
        size--;
        return removedNode.data;
    }

    @Override
    public T remove(T element) {
        ListNode<T> ptr = head;
        ListNode<T> prevPtr = null;
        while (ptr != null && !ptr.data.equals(element)) {
            prevPtr = ptr;
            ptr = ptr.next;
        }
        if (ptr == null) {
            return null;
        } else if (prevPtr != null) {
            prevPtr.next = ptr.next;
        } else {
            head = ptr.next;
        }
        size--;
        return ptr.data;
    }

    @Override
    public T get(int position) {
        return isValidPosition(position) ? getNode(position).data : null;
    }

    @Override
    public int indexOf(T element) {
        ListNode<T> ptr = head;
        int idx = 0;
        while (ptr != null && !ptr.data.equals(element)) {
            ptr = ptr.next;
            idx++;
        }
        return ptr == null ? -1 : idx;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < size;
    }

    private ListNode<T> getNode(int position) {
        int idx = 0;
        ListNode<T> ptr = head;
        while (idx < position) {
            ptr = ptr.next;
            idx++;
        }
        return ptr;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private ListNode<T> nextNode = head;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public T next() {
                ListNode<T> currNode = nextNode;
                nextNode = currNode.next;
                return currNode.data;
            }
        };
    }

    public static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }

        public Optional<ListNode<T>> next() {
            return Optional.ofNullable(next);
        }
    }
}
