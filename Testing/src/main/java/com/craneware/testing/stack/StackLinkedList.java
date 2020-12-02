package com.craneware.testing.stack;

import com.craneware.testing.linkedlist.SLNode;

public class StackLinkedList<T> {

    SLNode top;
    public StackLinkedList(){
        top = null;
    }

    public void push(Object value){

        SLNode newNode = new SLNode(value, null);
        if(top == null){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
     }

    public T pop(){
        if(top == null){
            System.out.println("Stack is Empty");
            return null;
        }
        SLNode temp = top;
        top = top.next;
        return (T) temp.value;

    }

    public void display(){
        SLNode temp = top;
        while(temp!=null ){
            System.out.println((T) temp.value);
            temp = temp.next;
        }
    }
}
