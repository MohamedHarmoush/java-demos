package com.harmoush.ds.tree;

public class TreesDemo {

    public static void main(String[] args) {
        BinaryTree<Integer> tree;
//        tree = Utils.generateDummyTree();
        tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);

//        tree.insert(2);
//        tree.insert(3);
//        tree.insert(1);

        System.out.println("traversePreOrder> ");
        tree.traversePreOrder();

        System.out.print("\ntraverseInOrder> ");
        tree.traverseInOrder();

        System.out.print("\ntraversePostOrder> ");
        tree.traversePostOrder();

        System.out.print("\ntraverseLevelOrder> ");
        tree.traverseLevelOrder();
        System.out.println();

        System.out.println("tree.search(3) = " + tree.search(3));
        System.out.println("tree.search(10) = " + tree.search(10));



    }
}
