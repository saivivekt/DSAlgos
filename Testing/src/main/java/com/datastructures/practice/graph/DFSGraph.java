package com.datastructures.practice.graph;

import com.datastructures.practice.queue.QueueArray;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSGraph {
    int size;
    AdjList[] adjListArray;
    public DFSGraph(int size){
        this.size = size;
        adjListArray = new AdjList[this.size];
        for (int i=0; i<size; i++){
            adjListArray[i] = new AdjList();
            adjListArray[i].head = null;
        }
    }

    public void add(int src, int dest){
        Node n = new Node(dest, null);
        n.next = adjListArray[src].head;
        adjListArray[src].head = n;
    }

    public void DFSExplore(int startVertex){
        Boolean[] visited = new Boolean[size];
        for(int i=0; i<size; i++){
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        while(!stack.isEmpty()){
            int stackTop = stack.peek();
            visited[stackTop] = true;
            Node head = adjListArray[stackTop].head;
            Boolean isDone = true;
            while(head != null){
                 if(visited[head.value] == false){
                     stack.push(head.value);
                     visited[head.value] = true;
                     isDone = false;
                     break;
                 }
                 else{
                     head = head.next;
                 }
            }
            if(isDone){
                int pop = stack.pop();
                System.out.println(pop);
            }
        }
    }

    public void BFSExplore(int startVertex){
        Boolean[] visited = new Boolean[size];
        for(int i=0; i<size; i++){
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        while(!queue.isEmpty()){
            int queueFront = queue.poll();
            System.out.println(queueFront);
            visited[queueFront] = true;
            Node head = adjListArray[queueFront].head;
            while(head != null ){
                if(visited[head.value] == false){
                    queue.add(head.value);
                    visited[head.value] = true;
                }
                else{
                    head = head.next;
                }
            }
        }
    }
}
