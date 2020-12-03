package com.datastructures.practice.problems;

import java.util.Stack;

public class Paranthesis {
    public static void main(String[] args) {
        String [] parenthesis = {"{", "{", "}", "}", "{"};

        boolean result = evaluateParanthesis(parenthesis);

        System.out.println(result);

    }

    private static boolean evaluateParanthesis(String[] parenthesis) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < parenthesis.length; i++) {
            if(parenthesis[i] == "{"){
                stack.push(parenthesis[i]);
            }
            else{
                stack.pop();
            }

        }
        if(stack.size() == 0){
            return true;
        }
        else{
            System.out.println(stack);
        }
        return false;
    }
}
