package com.harmoush;

import com.harmoush.ds.stack.Stack;
import com.harmoush.ds.stack.StackArray;
import com.harmoush.ds.stack.StackLinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
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

    }
}
