package com.craneware.testing.problems.amazon;

import java.util.ArrayList;

public class Stair {

    public int number;
    public ArrayList<Integer> visited = new ArrayList<>();
    public Stair(int number, ArrayList<Integer> visited){
        this.number = number;
        this.visited.addAll(visited);
        this.visited.add(this.number);
    }
}
