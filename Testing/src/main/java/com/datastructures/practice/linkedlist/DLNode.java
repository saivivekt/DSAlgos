package com.datastructures.practice.linkedlist;

public class DLNode {
DLNode previous;
Object value;
DLNode next;

public DLNode(DLNode previous, Object value, DLNode next){
    this.previous = previous;
    this.value = value;
    this.next = next;
}

}
