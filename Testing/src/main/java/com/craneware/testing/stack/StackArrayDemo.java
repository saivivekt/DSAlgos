package com.craneware.testing.stack;

public class StackArrayDemo {
    public static void main(String[] args) {
        StackArray<Integer> stackArray = new StackArray<>(5);
        stackArray.push(10);
        stackArray.push(11);
        stackArray.push(12);
        stackArray.push(13);
        stackArray.push(14);
        while (!stackArray.isStackEmpty()){
            System.out.println(stackArray.pop());
        }
    }
}
