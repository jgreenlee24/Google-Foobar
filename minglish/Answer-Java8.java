// package com.google.challenges;
import java.lang.*;
import java.util.*;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Map;
import java.util.stream.Collectors;

public class Answer {
    public static void main(String[] args){
        String[] example = {"z", "yx", "yz"};
        String a = answer(example);
        System.out.println(a);
    }

    public static String answer(String[] words) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        // get length of longest string
        String longest = Arrays.stream(words)
            .sorted((w1, w2) -> w1.length() > w2.length() ? -1 : 1)
            .findFirst().orElse("");
        int max = longest.length();

        // select all unique characters from words to array
        String chars = Arrays.stream(words)
            .flatMap(ws -> ws.chars().mapToObj(i -> (char)i))
            .distinct().collect(Collectors.toList()).toString();

        // create map for characters to index
        for (char c : chars.toCharArray()) { map.put(c, 0); };

        // create hashsets
        String firstRow = Arrays.stream(words)
            .map(s -> s.charAt(0))
            .distinct().collect(Collectors.toList()).toString();
        if (firstRow.length() == chars.length()) return firstRow;

        // select
        ArrayList<String> hsets = new ArrayList<String>();
        // for (int i = 0; i < max; i++ ) {
        //     Arrays.stream(words)
        //         .map(s -> new HashMap<String, Character>() {
        //                 {
        //                     put("firstChar", s.charAt(i) );
        //                     put("secondChar", s.charAt(i + 1));
        //                 }
        //             })
        //         .collect( Collectors
        //             .groupingBy(s -> s.get("firstChar")));
        // }

        // for (int i = 0; i < max; i++ ) {
        //     Arrays.stream(words)
        //         .map(s -> )
        // }



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
        // return hsets.get(0).toString();
        return "";
    }
}
