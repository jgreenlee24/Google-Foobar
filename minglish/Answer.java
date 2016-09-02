// package com.google.challenges;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;

public class Answer {
    public static void main(String[] args){
        String[] example = {"z", "yx", "yz"};
        String a = answer(example);
        System.out.println(a);
    }

    public static String answer(String[] words) {
        // input: words - list of ordered words using Minglish ordering
        String output = "";
        // using LinkedHashSet to remove duplicates & preserve insert order
        LinkedHashSet<Character> hset = new LinkedHashSet<Character>();
        // add all first letters to hashset
        hset.addAll(Arrays.stream(words).map(s -> s.charAt(0)).collect(Collectors.toList()));
        if (hset.size() == 26) return hset.toString();





        // rules version: loop
        // same loop idea, but add unsorted characters and their relationships
        // to the storage hashmaps & arrays.
        // Basically check to see if we can add each character on encounter to output
        // if not, add to the other stuff. 
        Hashmap gt = new Hashmap(); // <char, ArrayList> - greater than storage
        Hashmap lt = new Hashmap(); // <char, ArrayList> - less than storage
        ArrayList us = new ArrayList(); // <char> - unsorted storage
        String word1 = "";
        String word2 = "";

        // loop version (without rules system): loop
        // 2 words at a time; compare characters at same index; when one's length is reached, move on
        // taking second word and comparing with the next word in the array
        // in the comparison, five possibilities:
            // a.) characters are the same, ignore; increment index; repeat
            // b.) else if first char only is in array: insert 2nd char in front of first in array
            // c.) else if second char only is in array: insert 1st char before 2nd in array
            // d.) else if both are in array: check order;
                    // moving the characters could cause a problem with previous ordering.. (exception!!)
            // e.) else (neither character in array): do something, maybe just append both? ....... (exception!!)

        // lesson learned: only add letters to the array when we know their relationship
        //                 with 2 absolute, adjacent characters in the array

        // output: ordered list of distinct letters as a single string
        return output;
    }
}
