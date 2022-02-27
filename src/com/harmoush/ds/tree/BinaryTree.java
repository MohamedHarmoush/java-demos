package com.harmoush.ds.tree;

import com.harmoush.ds.Collection;

public interface BinaryTree<T> extends Collection<T> {

    void traverseInOrder();

    void traversePreOrder();

    void traversePostOrder();

    void traverseLevelOrder();

    void insert(T data);

    T delete(T data);

    boolean search(T data);

}
