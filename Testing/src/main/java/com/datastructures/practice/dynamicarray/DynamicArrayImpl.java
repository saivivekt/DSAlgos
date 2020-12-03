package com.datastructures.practice.dynamicarray;

public class DynamicArrayImpl {
    public static void main(String[] args) {
        DynamicArray<Integer> da = new DynamicArray<Integer>() ;

        da.insert(1);
        System.out.println("Size" + da.getSize());

        da.insert(2);
        System.out.println("Size" + da.getSize());
        da.insert(3);
        System.out.println("Size" + da.getSize());
        da.insert(4);
        System.out.println("Size" + da.getSize());
        da.insert(5);
        System.out.println("Size" + da.getSize());

    }
}
