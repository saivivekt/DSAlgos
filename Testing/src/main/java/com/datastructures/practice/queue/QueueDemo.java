package com.datastructures.practice.queue;

public class QueueDemo {
    public static void main(String[] args) {
    QueueArray<String> queueArray= new QueueArray<>(5);
    queueArray.add("first");
    queueArray.add("second");
    queueArray.add("third");
    queueArray.add("four");
    queueArray.add("five");
    queueArray.add("six");
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
    }
}
