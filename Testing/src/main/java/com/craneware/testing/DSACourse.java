package com.craneware.testing;

import java.util.ArrayList;

public class DSACourse {
    public static void main(String[] args) {
        System.out.println(flipZero());
    }

    private static int flipZero(){
        int[] arr = {1,1,0,1,1,0};
        ArrayList<Integer> sequenceOnes = new ArrayList<>();
        int count = 0;
        int max = 0;
        int sum = 0;

        for (int i=0; i< arr.length; i++){

            if(arr[i] == 1){
                count++;
                if(count > 0 && i == arr.length-1){
                    sequenceOnes.add(count);
                }
            }
            else {
                if (count > 0) {
                    sequenceOnes.add(count);
                }
                sequenceOnes.add(arr[i]);
                count = 0;
            }
        }
        for (int num: sequenceOnes
             ) {
            System.out.println(num);
        }

        for (int i=0; i< sequenceOnes.size(); i = i+2){

            sum = sequenceOnes.get(i);
            if( i+1 < sequenceOnes.size()){
                sum+=1;
            }
           if( i+2 < sequenceOnes.size()){
               sum+= sequenceOnes.get(i+2);
           }
           if(sum > max){
               max = sum;
           }

        }
        return max;
    }
}
