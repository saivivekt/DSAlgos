package com.datastructures.practice.hash;

public class HashTableArray<T> {
    int size;
    Entry[] hashArray;
public  HashTableArray(int size){
    this.size = size;
    hashArray = new Entry[size];
    for(int i=0; i<size; i++){
        hashArray[i]= new Entry();
    }
}
public int GetHash(int key){
    return key%size;
}
public void put(int key, Object value){
    int hashIndex = GetHash(key);
    Entry hashEntry = hashArray[hashIndex];
    Entry newEntry = new Entry(key, value);
    newEntry.next = hashEntry.next;
    hashEntry.next = newEntry;
}
public T get(int key){
    T value = null;

    int hashIndex = GetHash(key);
    Entry hashArrayEntry = hashArray[hashIndex];

    while(hashArrayEntry != null){
        System.out.println("hello" + "  "+ hashArrayEntry.GetKey());
        if(hashArrayEntry.GetKey() == key){
            value = (T)hashArrayEntry.GetValue();
            break;
        }
        hashArrayEntry = hashArrayEntry.next;

    }

    return value;
}
}
