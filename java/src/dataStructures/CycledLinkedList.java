package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blockost on 20/03/17.
 */
public class CycledLinkedList {

    public static boolean hasCycle(LinkedList head) {
        if (head == null || !head.hasNext()) {
            return false;
        }

        return check(head, new ArrayList<>());
    }

    private static boolean check(LinkedList head, List<Integer> list) {
        int hashCode = head.hashCode();

        if (list.contains(hashCode) || !head.hasNext()) {
            return false;
        }

        list.add(hashCode);
        return check(head.getNext(), list);
    }

}
