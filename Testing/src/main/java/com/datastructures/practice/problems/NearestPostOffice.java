package com.datastructures.practice.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NearestPostOffice {
    static int[][] array;
    static class Cell{
        coordinate coordinate;
        int distance;
        public Cell(coordinate c, int d){
            this.coordinate = c;
            this.distance = d;
        }
    }
    // define the coordinate for post offices
    static class coordinate
    {
         int i;
         int j;
        public coordinate(int i,int j){
            this.i=i;
            this.j=j;}
    }

    public static void main(String[] args) {
        array = new int[][] {{-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1}};

        // Test case
        coordinate[] PostOfficeLocations={
                new coordinate(3, 1),
                new coordinate(2, 3),
                new coordinate(4, 4)
        };
        FindShortPath(PostOfficeLocations);

    }
    public static void FindShortPath( coordinate[] PostOffice)
    {
        Queue<Cell> queue = new LinkedList<>();
        for (int i=0; i< PostOffice.length; i++){
            array[PostOffice[i].i][PostOffice[i].j] = 0;
            queue.add(new Cell(PostOffice[i],0));
        }
        //print(array);
        while(!queue.isEmpty()){
        Cell c = queue.poll();

            move(array,queue, c.coordinate.i, c.coordinate.j+1,c.distance+1);

            move(array,queue, c.coordinate.i, c.coordinate.j-1,c.distance+1);

            move(array,queue, c.coordinate.i+1, c.coordinate.j,c.distance+1);

            move(array,queue,c.coordinate.i-1, c.coordinate.j,c.distance+1);


        }
        /// TODO: write your code here
        /// TODO:Print 2D array as it show in the images question

        print(array);
    }

    private static void move(int[][] array, Queue queue, int row, int col, int dist) {
        if(row>=0 && row<array.length && col>=0 && col<array[0].length){
/*            if(col == array[0].length-1){
                System.exit(0);
            }
            else */if(array[row][col] == -1){
                array[row][col] = dist;
                    queue.add(new Cell(new coordinate(row,col),dist));
                }
        }
    }

    private static void print(int[][] array){
        for (int i=0; i< array.length; i++){

            for (int j=0; j< array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
