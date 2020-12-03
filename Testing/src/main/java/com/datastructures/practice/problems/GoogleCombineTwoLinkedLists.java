package com.datastructures.practice.problems;

import com.datastructures.practice.linkedlist.LinkedListS;
import com.datastructures.practice.stack.StackLinkedList;

public class GoogleCombineTwoLinkedLists {
    public static void main(String[] args) {
        LinkedListS<String> firstLinkedList = new LinkedListS<>();
        firstLinkedList.add("A");
        firstLinkedList.add("B");
        firstLinkedList.add("C");
        StackLinkedList<String> secondLinkedList = new StackLinkedList<>();
        secondLinkedList.push("D");
        secondLinkedList.push("E");
        secondLinkedList.push("F");

        for (int i=0; i<3; i++){
            System.out.println(firstLinkedList.pop());
            System.out.println(secondLinkedList.pop());
        }
        //firstLinkedList.display();
    }
}
