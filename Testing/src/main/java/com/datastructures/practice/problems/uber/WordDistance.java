package com.datastructures.practice.problems.uber;

import java.util.Stack;

public class WordDistance {
    public static void main(String[] args) {
        String inputArray[] = {"hot", "dot", "dog","lot","log","cog"};
        String startWord = "hit";
        String endWord = "com";
        boolean isFound = findPath(inputArray, startWord, endWord);
        System.out.println(isFound);
    }

    private static boolean findPath(String[] inputArray, String startWord, String endWord) {
        boolean isFound = false;
        boolean isVisited[] = new boolean[inputArray.length];
        Stack<String> stack = new Stack<>();
        stack.push(startWord);

        while (!stack.isEmpty()){
            String stackTop = stack.pop();
            if(distance(stackTop, endWord) == 0){
                isFound = true;
                stack.push(endWord);
                System.out.println(stack);
                break;
            }
            boolean isStackTopPushed = false;
            for (int i=0; i< inputArray.length; i++){
                if(isVisited[i] == true){
                    continue;
                }

                if(distance(stackTop,inputArray[i]) == 1){
                    if(!isStackTopPushed){
                        stack.push(stackTop);
                        isStackTopPushed = true;
                    }
                    stack.push(inputArray[i]);
                    isVisited[i] = true;

                }

            }
        }
        return isFound;
    }

    private static int distance(String startWord, String endWord) {
        int distance = 3;
        for (int i=0; i<startWord.length(); i++){
            if(startWord.charAt(i) == endWord.charAt(i)){
                distance--;
            }
        }
        return distance;
    }
}
