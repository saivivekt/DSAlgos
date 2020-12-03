package com.datastructures.practice.problems.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUniqueNumberInArray {
    public static void main(String[] args) {
        int [] array = {1,2,5,5,6,6,7,8,10,10};
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int number:array
             ) {
            if(hashMap.get(number) == null){
                hashMap.put(number, 1);
            }
            else{
                hashMap.put(number, hashMap.get(number)+1);
            }
        }
        for (int value:hashMap.keySet()
             ) {
            if(hashMap.get(value) == 1){
                result.add(value);
            }
        }
        for (int value:result
             ) {
            System.out.println(value);
        }
    }
}
