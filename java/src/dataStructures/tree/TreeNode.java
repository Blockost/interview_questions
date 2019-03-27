package dataStructures.tree;

/**
 * Created by blockost on 20/03/17.
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getHeight() {
        return this.computeHeight(this);
    }

    private int computeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(computeHeight(node.left), computeHeight(node.right));
    }

    private boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        if (isLeaf()) {
            s.append("(").append(value).append(")");
        } else {
            s.append("(").append(value).append(") --> ");
            if (left != null)
                s.append("left[").append(left.toString()).append("] - ");

            if (right != null)
                s.append("right[").append(right.toString()).append("]");

        }
        return s.toString();
    }
}
