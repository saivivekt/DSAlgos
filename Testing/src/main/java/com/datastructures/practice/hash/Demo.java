package com.datastructures.practice.hash;

public class Demo {
    public static void main(String[] args) {
        HashTableArray<String> hashTableArray = new HashTableArray<>(10);
        hashTableArray.put(11, "Sai");
        hashTableArray.put(12, "Vivek");
        hashTableArray.put(13, "Therala");
        System.out.println(hashTableArray.get(11));
    }
}
