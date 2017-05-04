import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by blockost on 20/03/17.
 */
public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {

        int[] count = new int[26];

        for (char c : first.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : second.toCharArray()) {
            count[c - 'a']--;
        }

        return Arrays.stream(count)
            .map(n -> Math.abs(n))
            .sum();
    }

    private static String deleteCharAt(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }
}
