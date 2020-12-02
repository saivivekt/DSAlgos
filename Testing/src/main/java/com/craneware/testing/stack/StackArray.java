package com.craneware.testing.stack;

public class StackArray<T> {
    Object[] stackArray;
    int top;
    int size;
    public StackArray(int size){
        this.size = size;
        stackArray = new Object[size];
        top = -1;
    }
    public void push(Object value){
        if(!isStackFull()){
            top++;
            stackArray[top] = value;
        }
        else{
            System.out.println("stack is full");
        }
    }

    public boolean isStackFull(){
        return top == size-1 ;
    }

    public boolean isStackEmpty(){
        return top == -1 ;
    }
    public T pop(){
        if(isStackEmpty()){
            System.out.println("stack is empty");
            return null;
        }
        T temp = (T) stackArray[top];
        top--;
        return temp;
    }
}
