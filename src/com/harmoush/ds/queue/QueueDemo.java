package com.harmoush.ds.queue;

public class QueueDemo {

    public static void main(String[] args) throws Exception {
        QueueArray<Integer> queue = new QueueArray<>();

        queue.enqueue(12);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.print();
        System.out.println("queue.dequeue() = " + queue.dequeue());
        queue.print();
        System.out.println("queue.dequeue() = " + queue.dequeue());
        queue.enqueue(75);
        queue.enqueue(30);
        queue.print();
        System.out.println("queue.dequeue() = " + queue.dequeue());
        queue.print();

    }
}
