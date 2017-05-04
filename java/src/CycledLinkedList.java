import java.util.ArrayList;
import java.util.List;

/**
 * Created by blockost on 20/03/17.
 */
public class CycledLinkedList {

    public static boolean hasCycle(LinkedList head){
        List<Integer> arr = new ArrayList<>();

        if(head == null || head.next == null)
            return false;

        return check(head.next, arr);
    }

    private static boolean check(LinkedList head, List arr){
        if(head == null) return false;

        int hashCode = head.hashCode();
        if(arr.contains(hashCode))
            return true;

        arr.add(hashCode);
        return check(head.next, arr);
    }
}
