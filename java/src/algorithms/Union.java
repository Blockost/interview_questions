package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * From Square Enix Montréal coding test:
 * <p>
 * Implement the union method. When passed two arrays of names, it will
 * return an array containing the names that appear in either or both arrays.
 * <p>
 * The returned array should have no duplicates.
 * <p>
 * For example, calling
 * <p>
 * union(new string[]{'Ava', 'Emma', 'Olivia'}, new string[]{'Olivia',
 * 'Sophia', 'Emma'})
 * should return an array containing Ava, Emma, Olivia, and Sophia in any order.
 */

public class Union implements Algorithm {
    private String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
    private String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};


    @Override
    public void execute() {
        System.out.println("Executing Union algorithm");
        String[] union = this.union(names1, names2);
        System.out.println(Arrays.toString(union));
    }

    private String[] union(String[] array1, String[] array2) {
        // Using a HashSet so that duplicate detection is handled for us
        HashSet<String> tmp = new HashSet<>(Arrays.asList(array1));
        // Now, tmp contains all distinct elements in array1
        Collections.addAll(tmp, array2);
        // Now, tmp contains all distinct elements of both arrays. Returning as Array:
        return tmp.toArray(new String[0]);
    }
}
