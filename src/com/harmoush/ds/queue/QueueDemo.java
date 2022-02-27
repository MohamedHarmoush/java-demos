package com.harmoush.ds.queue;

import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueDemo {

    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(12);
        queue.enqueue(10);
        queue.enqueue(6);
        queue.enqueue(1);
        queue.enqueue(181);
        printQueue(queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        printQueue(queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        queue.enqueue(75);
        queue.enqueue(30);
        printQueue(queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        printQueue(queue);

        ConcurrentLinkedDeque<Integer> linkedDeque = new ConcurrentLinkedDeque<>();
        linkedDeque.push(3);
        linkedDeque.push(5);
        linkedDeque.push(57);
        linkedDeque.push(9);
        System.out.println("linkedDeque.stream().toArray() = " + Arrays.toString(linkedDeque.stream().toArray()));
        linkedDeque.clear();
        System.out.println("linkedDeque.stream().toArray() = " + Arrays.toString(linkedDeque.stream().toArray()));
    }

    private static void printQueue(Queue<Integer> queue) {
        StringBuilder builder = new StringBuilder("[");
        for (Integer element : queue) {
            builder.append(element).append(", ");
        }
        if (queue.isEmpty()) {
            builder.append("]");
        } else {
            int lastCommaIdx = builder.lastIndexOf(",");
            builder.replace(lastCommaIdx, lastCommaIdx + 1, "]");
        }
        System.out.println("Queue = " + builder);

    }
}
