package com.harmoush;

import com.harmoush.ds.Collection;
import com.harmoush.ds.tree.BinarySearchTree;

public class Utils {

    public static <T> void printCollection(Collection<T> collection) {
        StringBuilder builder = new StringBuilder("[");
        for (T element : collection) {
            builder.append(element).append(", ");
        }
        if (collection.isEmpty()) {
            builder.append("]");
        } else {
            int lastCommaIdx = builder.lastIndexOf(",");
            builder.replace(lastCommaIdx, lastCommaIdx + 1, "]");
        }
        System.out.println(collection.getClass().getSimpleName() + " = " + builder);

    }

    public static BinarySearchTree<String> generateDummyTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        BinarySearchTree.Node<String> nodeA = new BinarySearchTree.Node<>("A");
        BinarySearchTree.Node<String> nodeB = new BinarySearchTree.Node<>("B");
        BinarySearchTree.Node<String> nodeC = new BinarySearchTree.Node<>("C");
        BinarySearchTree.Node<String> nodeD = new BinarySearchTree.Node<>("D");
        BinarySearchTree.Node<String> nodeE = new BinarySearchTree.Node<>("E");
        BinarySearchTree.Node<String> nodeF = new BinarySearchTree.Node<>("F");
        BinarySearchTree.Node<String> nodeG = new BinarySearchTree.Node<>("G");

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;

        nodeD.left = nodeG;

        tree.insertRoot(nodeA);
        return tree;
    }
}
