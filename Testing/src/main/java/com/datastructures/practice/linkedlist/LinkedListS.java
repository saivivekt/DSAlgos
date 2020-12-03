package com.datastructures.practice.linkedlist;

public class LinkedListS<T> {
    SLNode head;
    public LinkedListS(){
        head = null;
    }

    public void add(Object value){
        SLNode newNode = new SLNode(value, null);
        if(head == null){
            head = newNode;
        }
        else{
            SLNode temp = head;
            while(temp.next!=null ){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public T pop(){

        T value = null;
        if(head!=null){
            value = (T) head.value;
        }
        head = head.next;
        return value;

    }

    public void remove(){
            head = head.next;
    }

    public void display(){
        SLNode temp = head;
        while(temp!=null ){
            System.out.println((T) temp.value);
            temp = temp.next;
        }
    }
}
