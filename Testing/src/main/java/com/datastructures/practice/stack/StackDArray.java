package com.datastructures.practice.stack;

import java.util.Arrays;

public class StackDArray<T> {
    Object[] stackArray;
    int top;
    int size;
    public StackDArray(int size){
        this.size = size;
        stackArray = new Object[size];
        top = -1;
    }
    public void push(Object value){
       ensureCapacity(top+2);
            top++;
            stackArray[top] = value;

    }

    public void ensureCapacity(int requiredCapacity){
        int currentCapacity = getSize();
        if(requiredCapacity > currentCapacity){
            int newCapacity = currentCapacity * 2;
            stackArray = Arrays.copyOf(stackArray, newCapacity);
        }

        if(requiredCapacity <= currentCapacity / 2){
            int newCapacity = Math.max(currentCapacity/2 , 1) ;
            stackArray = Arrays.copyOf(stackArray, newCapacity);
        }
    }

    public boolean isStackFull(){
        return top == size-1 ;
    }

    public int getSize(){
        return stackArray.length;
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
