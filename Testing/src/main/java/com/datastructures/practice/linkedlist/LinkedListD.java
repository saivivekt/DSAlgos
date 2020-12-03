package com.datastructures.practice.linkedlist;

public class LinkedListD<T> {
    DLNode head;
    public LinkedListD(){
        head = null;
    }

    public void add(Object value){

        DLNode newNode = new DLNode(null, value, null);
        if(head == null){

            head = newNode;
        }
        else{
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void remove(){
        if(head != null){
            head = head.next;
            head.previous = null;
        }
    }

    public void display(){
        DLNode temp = head;
        while(temp!=null ){
            System.out.println((T) temp.value);
            temp = temp.next;
        }
    }
}
