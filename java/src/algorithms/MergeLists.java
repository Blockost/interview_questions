package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Merges two sorted lists into a single list which is also sorted
 */
public class MergeLists implements Algorithm {
    // Arrays.asList return an immutable list so need to wrap it into a LinkedList to perform add/remove operations
    private List<Integer> list1 = new LinkedList<>(Arrays.asList(1, 3, 5));
    private List<Integer> list2 = new LinkedList<>(Arrays.asList(2, 4, 6));
    private List<Integer> result = new ArrayList<>();

    @Override
    public void execute() {
        System.out.println("Executing MergeLists algorithm");
        System.out.println(String.format("Merging list %s with list %s", list1, list2));

        // Add element one by one until one of the lists is empty
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.get(0) <= list2.get(0)) {
                result.add(list1.get(0));
                list1.remove(0);
            } else {
                result.add(list2.get(0));
                list2.remove(0);
            }
        }

        // Now that one of the list is empty, add all elements from the non-empty list
        // This is possible because base lists are already sorted
        if (list1.isEmpty()) {
            result.addAll(list2);
        } else {
            result.addAll(list1);
        }

        System.out.println(String.format("Results of merge: %s", result));
    }
}
