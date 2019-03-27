package dataStructures.tree;

/**
 * A {@link BinarySearchTree} is a tree which has the following properties:
 *
 * <p> The left subtree of a node only contains values that are lesser than the node's value
 * <p> The right subtree of a node only contains values that are greater than the node's value
 * <p> Left and right subtrees are also a {@link BinarySearchTree}
 */
public abstract class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public boolean checkBST() {
        return check(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
