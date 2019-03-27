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

    /**
     * Finds the node corresponding to the given value.
     *
     * <p>It leverages the property of a {@link BinarySearchTree} in order to have logarithmic time complexity.
     */
    public TreeNode find(int value) {
        return this.doFind(root, value);
    }

    public boolean checkBST() {
        return check(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode doFind(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.value == value) {
            return root;
        }

        if (value <= root.value) {
            return this.doFind(root.left, value);
        }

        return this.doFind(root.right, value);
    }

    private static boolean check(TreeNode n, int min, int max) {

        if (n == null) return true;

        if (n.value <= min || n.value >= max)
            return false;

        // Recursive call on left and right subtrees
        return check(n.left, min, n.value)
                && check(n.right, n.value, max);
    }
}
