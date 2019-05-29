package algorithms;

import java.util.Arrays;
import java.util.List;

public class Algorithms {

    public static void test() {
        System.out.println("*** Testing algorithms problems ***");
        List<Algorithm> algorithms = Arrays.asList(new MergeLists(), new Fibonacci(), new Union(), new Playlist());

        String s1 = "cde";
        String s2 = "abc";
        int n = MakingAnagrams.numberNeeded(s1, s2);
        System.out.println(n);

        HashTableRansomNote hashTableRansomNote = new HashTableRansomNote(
                "give me one grand today night",
                "give one grand today");

        System.out.println(hashTableRansomNote.solve());

        int i = DavisStaircase.climb(7);
        System.out.println(i);

        algorithms.forEach(Algorithm::execute);
    }
}
