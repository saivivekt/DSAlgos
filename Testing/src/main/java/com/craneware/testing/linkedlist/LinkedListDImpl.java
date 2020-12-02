package com.craneware.testing.linkedlist;

public class LinkedListDImpl {
    public static void main(String[] args) {
        LinkedListD<String> ls = new LinkedListD<String>();
        ls.add("Hussien");
        ls.add("Sai");
        ls.add("Vivek");
        System.out.println("before remove");
        ls.display();

        ls.remove();
        System.out.println("after remove");
        ls.display();
    }
}
