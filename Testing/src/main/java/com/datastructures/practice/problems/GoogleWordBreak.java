package com.datastructures.practice.problems;

import java.util.*;

class Option{
    int nextIndex;
    ArrayList<String> listOfWords = new ArrayList<String>();

    public Option(int nextIndex, ArrayList<String> listOfWords){
        this.nextIndex = nextIndex;
        this.listOfWords.addAll(listOfWords);
    }
}
public class GoogleWordBreak {
    Set<String> dictionary = new HashSet<>();
    public GoogleWordBreak(){
    dictionary.add("sam");
    dictionary.add("sung");
        dictionary.add("samsung");
        dictionary.add("and");
        dictionary.add("man");
        dictionary.add("go");
        dictionary.add("mango");
    }

    public static void main(String[] args) {
        new GoogleWordBreak().breakWord("samsungandmango");
    }

    void breakWord(String word){
        Queue<Option> q = new LinkedList<Option>();
        q.add(new Option(0,new ArrayList<>()));
        while (!q.isEmpty()){
            Option option = q.poll();

            if(option.nextIndex >= word.length()){
                System.out.println(option.listOfWords);
            }

            for(int i=option.nextIndex; i<=word.length(); i++){
                String oneWord = word.substring(option.nextIndex, i);

                if(dictionary.contains(oneWord)){
                    Option newOption = new Option(i, option.listOfWords);
                    newOption.listOfWords.add(oneWord);
                    q.add(newOption);
                }
            }
        }
    }
}
