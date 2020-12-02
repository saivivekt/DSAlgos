package com.craneware.testing.stack;

public class StackDArrayDemo {
    public static void main(String[] args) {
        StackDArray<Integer> stackDArray = new StackDArray<>(2);

        stackDArray.push(1);
        stackDArray.push(2);
        System.out.println(stackDArray.getSize());
        stackDArray.push(3);
        System.out.println(stackDArray.getSize());
    }
}
