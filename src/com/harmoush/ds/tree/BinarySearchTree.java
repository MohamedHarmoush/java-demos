package com.harmoush.ds.tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

    private int size;
    private Node<T> root;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void insert(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node<T> ptr = root;

            while (ptr != null) {
                if (element.compareTo(ptr.data) <= 0) {
                    if (ptr.left == null) {
                        ptr.left = newNode;
                        break;
                    } else {
                        ptr = ptr.left;
                    }
                } else {
                    if (ptr.right == null) {
                        ptr.right = newNode;
                        break;
                    } else {
                        ptr = ptr.right;
                    }
                }
            }
        }
        size++;
    }

    public void insertRoot(Node<T> root) {
        this.root = root;
    }

    public T delete(T element) {
        return null;
    }

    public boolean search(T element) {
        if (root == null) return false;
        Node<T> ptr = root;
        boolean found = false;
        int count = 0;
        while (ptr != null) {
            count++;

            if (element.compareTo(ptr.data) == 0) {
                found = true;
                break;
            } else if (element.compareTo(ptr.data) < 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        System.out.println("search steps = " + count);
        return found;
    }

    @Override
    public int treeHeight() {
        if (root == null) return 0;
        return getNodeHeight(root);
    }

    public int getNodeHeight(Node<T> node) {
        AtomicInteger leftHeight = new AtomicInteger(0);
        AtomicInteger rightHeight = new AtomicInteger(0);

        node.left().ifPresentOrElse((leftNode) -> {
            leftHeight.set(getNodeHeight(leftNode) + 1);
        }, () -> leftHeight.set(0));

        node.right().ifPresentOrElse((rightNode) -> {
            rightHeight.set(getNodeHeight(rightNode) + 1);
        }, () -> rightHeight.set(0));

        return Math.max(leftHeight.get(), rightHeight.get());
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

    @Override
    public void clear() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    // preorder: VLR (vertex, left, right)
    @Override
    public void traversePreOrder() {
        System.out.print("Recursively> ");
        traversePreOrderRec(root);
        System.out.print("\nOR \nIteratively> ");
        traversePreOrderIteratively();
    }

    // inorder: LVR (left, vertex, right)
    @Override
    public void traverseInOrder() {
        traverseInOrderRec(root);
    }

    // postorder: LRV (left, right, vertex)
    @Override
    public void traversePostOrder() {
        traversePostOrderRec(root);
    }

    @Override
    public void traverseLevelOrder() {
        if (root == null) return;

        Queue<Node<T>> nodes = new ArrayDeque<>();
        Node<T> ptr;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            ptr = nodes.poll();
            System.out.print(ptr.data + " ");
            ptr.left().ifPresent(nodes::add);
            ptr.right().ifPresent(nodes::add);
        }
    }

    private void traversePreOrderIteratively() {
        if (root == null) return;

        Node<T> ptr;
        Stack<Node<T>> nodes = new Stack<>();
        nodes.add(root);
        int count = 0;
        while (!nodes.isEmpty()) {
            ptr = nodes.pop();
            System.out.print(ptr.data + " ");
            ptr.right().ifPresent(nodes::push);
            ptr.left().ifPresent(nodes::push);
            count++;
        }
        System.out.println("count = " + count);
    }

    private void traversePreOrderRec(Node<T> root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        root.left().ifPresent(this::traversePreOrderRec);
        root.right().ifPresent(this::traversePreOrderRec);
    }

    private void traverseInOrderRec(Node<T> root) {
        if (root == null) return;

        root.left().ifPresent(this::traverseInOrderRec);
        System.out.print(root.data + " ");
        root.right().ifPresent(this::traverseInOrderRec);
    }

    private void traversePostOrderRec(Node<T> root) {
        if (root == null) return;

        root.left().ifPresent(this::traversePostOrderRec);
        root.right().ifPresent(this::traversePostOrderRec);
        System.out.print(root.data + " ");
    }

    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public Optional<Node<T>> left() {
            return Optional.ofNullable(left);
        }

        public Optional<Node<T>> right() {
            return Optional.ofNullable(right);
        }
    }
}
