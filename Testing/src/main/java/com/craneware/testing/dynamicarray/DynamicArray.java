package com.craneware.testing.dynamicarray;

import java.util.Arrays;

public class DynamicArray<T> {
    Object[] data;
    int endPointer;

    public DynamicArray(){
        endPointer = 0;
        data = new Object[1];
    }

    public void insert(Object element){
        ensureCapacity(endPointer + 1);
        data[endPointer++] = element;
    }

    public void delete(Object element){
        data[--endPointer] = null;
        ensureCapacity(endPointer);
    }

    public void ensureCapacity(int requiredCapacity){
        int currentCapacity = getSize();
        if(requiredCapacity > currentCapacity){
            int newCapacity = currentCapacity * 2;
            data = Arrays.copyOf(data, newCapacity);
        }

        if(requiredCapacity <= currentCapacity / 2){
            int newCapacity = Math.max(currentCapacity/2 , 1) ;
            data = Arrays.copyOf(data, newCapacity);
        }
    }
    public int getSize(){
        return data.length;
    }

    public T get(int index){
        return (T) data[index];
    }


}
