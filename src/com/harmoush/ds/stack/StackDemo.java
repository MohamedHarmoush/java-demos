package com.harmoush.ds.stack;

import com.harmoush.problems.TowerOfHanoi;

public class StackDemo {

    public static void run() throws Exception {
        System.out.println("----------ArrayBasedStack-----------");

        Stack<Integer> integerStack = new StackArray<>(5);
        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(30);
        integerStack.push(40);
        integerStack.push(50);

        System.out.println("integerStack.top() = " + integerStack.top());
        System.out.println("integerStack.size() = " + integerStack.size());
        System.out.println("integerStack.pop() = " + integerStack.pop());
        System.out.println("integerStack.top() = " + integerStack.top());
        System.out.println("integerStack.size() = " + integerStack.size());

        System.out.println("Display ArrayBasedStack elements.");

        System.out.println();
        System.out.println("integerStack.size() = " + integerStack.size());
        System.out.println("--------1--------");
        integerStack.forEach(integer -> System.out.print(integer + " "));
        System.out.println("\n--------2--------");
        for (Integer integer : integerStack) {
            System.out.print(integer + " - ");
        }
        System.out.println("\n---------LinkedListBasedStack------------");
        Stack<String> strings = new StackLinkedList<>();
        strings.push("Ahmed");
        strings.push("Mohamed");
        strings.push("1234");
        strings.push("Kotb");
        System.out.println("strings.pop() = " + strings.pop());
        System.out.println("strings.top() = " + strings.top());
        System.out.println("\n--------iterate over stack elements--------");
        for (String s : strings) {
            System.out.print(s + " - ");
        }
        System.out.println();

        System.out.println("---------Start of Tower Of Hanoi Game-----");
        int n = 3, src = 1, dest = 3, aux = 2;
        System.out.printf("Move %d disks from source %d to destination %d \n", n, src, dest);
        TowerOfHanoi.solveRecursively(n, src, dest, aux);
        System.out.printf("%d steps to move %d disks from source %d to destination %d \n", TowerOfHanoi.stepsCount, n, src, dest);
        System.out.println("------solveIteratively----");
        TowerOfHanoi.resetStepsCount();
        TowerOfHanoi.solveIteratively(n, src, dest, aux);
        System.out.printf("%d steps to move %d disks from source %d to destination %d \n", TowerOfHanoi.stepsCount, n, src, dest);
        System.out.println("---------End of Tower Of Hanoi Game-------");
    }


}
