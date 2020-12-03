package com.datastructures.practice.stack;

public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackLinkedList<String> stackLinkedList = new StackLinkedList<>();
        stackLinkedList.push("Sai");
        stackLinkedList.push("Vivek");
        stackLinkedList.display();
        stackLinkedList.pop();
        stackLinkedList.display();
    }
}
