/**
 * Created by blockost on 20/03/17.
 */
public class BinarySearchTree {

    public static boolean checkBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean check(TreeNode n, int min, int max) {

        if (n == null) return true;

        if (n.data <= min || n.data >= max)
            return false;

        // Recursive call on left and right subtrees
        return check(n.left, min, n.data)
            && check(n.right, n.data, max);
    }
}
