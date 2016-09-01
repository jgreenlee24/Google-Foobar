package​ ​com.google.challenges;​ ​
import java.util.*;

public​ ​class​ ​Answer​ ​{​ ​​ ​​ ​
​ ​​ ​​ ​​ ​public​ ​static​ ​String​ ​answer(String[]​ words)​ ​{​ ​
​ ​​ ​​ ​​ ​​ ​​ ​​ ​​ ​//​ input: words - list of ordered words using Minglish ordering
        String output = "";
        // using LinkedHashSet to remove duplicates & preserve insert order
        LinkedHashSet<char> hset = new LinkedHashSet<char>();
        // add all first letters to hashset
        hset.addAll(words.stream().map(s -> s[0]).collect(Collectors.toList());

        // output: ordered list of distinct letters as a single string
        return output;
​ ​​ ​​ ​​ ​}​ ​
}
