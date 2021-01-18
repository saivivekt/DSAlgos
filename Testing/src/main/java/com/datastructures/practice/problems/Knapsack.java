package com.datastructures.practice.problems;

public class Knapsack {
    public static void main(String[] args) {
        int set[] = {1,5,6,9,10};
        int myBasket = 6;

        for (int i=0; i<(1<<set.length);i++){
            System.out.println("----------------");
            for (int j=0; j<set.length; j++){
                System.out.print(Integer.toBinaryString(i));
                System.out.print(" ");
                System.out.print(Integer.toBinaryString(1<<j));
                System.out.print(" = ");
                System.out.print(Integer.toBinaryString(i& (1<<j)));
                System.out.println();
                if((i & (1<<j)) > 0){

                }
            }
        }

    }
}
