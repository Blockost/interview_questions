/**
 * Created by blockost on 20/03/17.
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    private boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        if (isLeaf()) {
            s.append("(" + data + ")");
        } else {
            s.append("(" + data + ") --> ");
            if (left != null)
                s.append("left[" + left.toString() + "] - ");

            if (right != null)
                s.append("right[" + right.toString() + "]");

        }
        return s.toString();
    }
}
