package com.datastructures.practice.problems;

import java.util.Hashtable;

public class LRUCache1 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode left;
        DLinkedNode right;

        public DLinkedNode(){}

        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(DLinkedNode node){
        node.right = head.right;
        node.left = head;

        head.right.left = node;
        head.right = node;

    }

    private void removeNode(DLinkedNode node){
        DLinkedNode preNode = node.left;
        DLinkedNode postNode = node.right;

        preNode.right = postNode;
        postNode.left = preNode;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode node = tail.left;
        removeNode(node);
        return node;
    }

    private DLinkedNode head, tail;
    int count;
    int capacity;
    Hashtable<Integer, DLinkedNode> cache  = new Hashtable<>();

    public LRUCache1(int capacity){
        this.count =0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.left = null;

        tail = new DLinkedNode();
        tail.right = null;

        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {

        if(cache.get(key) == null){
            return -1;
        }
        else{
            moveToHead(cache.get(key));
            return cache.get(key).value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = new DLinkedNode(key, value);
        if(cache.get(key) == null){
            cache.put(key,node);
            count++;
            addNode(node);
            if(count>capacity){
                DLinkedNode removedNode = popTail();
                cache.remove(removedNode.key);
                count--;
            }
        }
        else{
            cache.get(key).value = value;
            moveToHead(cache.get(key));
        }
    }
}
