// package com.google.challenges;
import java.lang.*;
import java.util.*;

public class Answer {
    public static void main(String[] args){
        String[] example = {"z", "yx", "yz"};
        String a = answer(example);
        System.out.println(a);
    }

    public static HashSet<Character> recurseMap(Map<Character, HashSet<Character>> map, Character key) {
        if (map.get(key).size() == 0) return new HashSet<Character>();
        else {
            // initialize new set with old values
            HashSet<Character> retset = new HashSet<Character>();
            retset.addAll(map.get(key));

            // recurse for new values to add to new set
            for (Character val : map.get(key)) {
                retset.addAll(recurseMap(map, val));
            }
            return retset;
        }
    }

    public static String answer(String[] words) {
        // get length of longest string
        int max = 0;

        // create setc - list of all distinct characters &
        // create setf - list of distinct first characters
        HashSet<Character> setc = new HashSet<Character>();
        LinkedHashSet<Character> setf = new LinkedHashSet<Character>();
        for (String w : words) {

            // store longest length
            if (w.length() > max) max = w.length();

            // get all distinct characters for first index
            setf.add(w.charAt(0));

            for (char c : w.toCharArray()) {
                // add each distinct character to character set
                setc.add(c);
            }
        }

        // string of all distinct characters in words array
        String chars = setc.toString()
            .replace(",", "")  //remove the commas
            .replace("[", "")  //remove the right bracket
            .replace("]", "")  //remove the left bracket
            .replace(" ", ""); // remove spaces
        System.out.println(chars);
        System.out.println(chars.length());

        // create initial hashmap
        HashMap<Character, HashSet<Character>> mapc = new HashMap<Character, HashSet<Character>>();
        for (char c : chars.toCharArray()) {
            mapc.put(c, new HashSet<Character>());
        }
        // map<substring, previous characters>
        HashMap<String, String> prevChars = new HashMap<String, String>();

        // loop variables
        String prevWord = "";
        String curSubstring = "";

        // loop and add next characters to after set
        for (String w : words) {
            int i = 0;
            for (Character c : w.toCharArray()) {

                // check substring of previous word with this word
                if (prevWord.length() >= i && curSubstring.equals(prevWord.substring(0,i))){
                    // make sure characters are different
                    if (prevWord == "" || w.charAt(i) != prevWord.charAt(i)) {
                        // add current character to every previous character's hashset
                        if (prevChars.get(curSubstring) != null) {
                            for (Character prevch : prevChars.get(curSubstring).toCharArray()) {
                                if (mapc.get(prevch) != null) {
                                    mapc.get(prevch).add(w.charAt(i));
                                }
                            }
                        }
                    }
                }
                // append current character to map's value for that substring
                prevChars.put(curSubstring, prevChars.get(curSubstring) + c);
                curSubstring += c;
                i++;
            }
            curSubstring = "";
            prevWord = w;
        }

        // create return string from mapc's hashset size (indices for return string)
        ArrayList<Character> arr = new ArrayList<Character>();
        for (int i = 0; i < chars.length(); i++) {
            arr.add('a'); // initial value
        }

        // initialize new HashSet with previous values
        HashMap<Character, HashSet<Character>> mapf =
            new HashMap<Character, HashSet<Character>>(mapc);

        // combine hashsets into a final map
        for (Map.Entry<Character, HashSet<Character>> entry : mapc.entrySet()) {
            // recurse for adding other character's values to the new set
            for (Character val : entry.getValue()) {
                HashSet<Character> retset = new HashSet<Character>();
                retset.add(entry.getKey());
                retset.addAll(recurseMap(mapc, val));
                // System.out.println(entry.getKey() + ": " + retset);
                mapf.put(entry.getKestatuy(), retset);
            }
        }

        System.out.println(mapc);
        System.out.println(mapf);

        // create indexed array from map using set length as index
        for (Map.Entry<Character, HashSet<Character>> entry : mapf.entrySet()) {
            arr.set(entry.getValue().size(), entry.getKey());
        }

        // reverse array
        Collections.reverse(arr);

        return arr.toString()
            .replace(",", "")  //remove the commas
            .replace("[", "")  //remove the right bracket
            .replace("]", "")  //remove the left bracket
            .replace(" ", ""); // remove spaces
    }
}
