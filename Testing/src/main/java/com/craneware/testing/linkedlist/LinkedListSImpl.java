package com.craneware.testing.linkedlist;

public class LinkedListSImpl {
    public static void main(String[] args) {
        LinkedListS<Integer> ls = new LinkedListS<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(6);
        System.out.println("before deletion");
        ls.display();

        deleteNthNode(ls.head, 1, ls);
        System.out.println("after deletion");
        ls.display();
    }

    static void deleteNthNode(SLNode root, int n, LinkedListS ls){
        SLNode slowptr = root;
        SLNode fastptr = root;
        while(n > 0){
            fastptr = fastptr.next;
            n--;
        }

        if(fastptr != null) {

                while (fastptr.next != null) {
                    slowptr = slowptr.next;
                    fastptr = fastptr.next;
                }
            slowptr.next = slowptr.next.next;
        }
else{
    ls.head = ls.head.next;
        }

    }
}
