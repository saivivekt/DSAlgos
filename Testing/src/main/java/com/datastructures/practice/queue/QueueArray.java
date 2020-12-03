package com.datastructures.practice.queue;

public class QueueArray<T> {
    int front ;
    int rear ;
    int size;
    Object QueueArray[];
    public QueueArray(int size){
        this.size = size;
        this.QueueArray = new Object[this.size];
        this.front = -1;
        this.rear = -1;
    }

    public void add(Object value){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        QueueArray[++rear] = value;
        if(front == -1){
            front ++;
        }
    }

    public boolean isFull(){
        return rear == size-1;
    }
    public boolean isEmpty(){
        return front == -1 || front > rear;
    }
    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T objectOut = (T) QueueArray[front++];
        return objectOut;
    }
}
