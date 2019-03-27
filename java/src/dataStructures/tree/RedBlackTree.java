package dataStructures.tree;

/**
 * A {@link RedBlackTree} is an implementation of a self-balancing {@link BinarySearchTree}.
 */
public class RedBlackTree extends SelfBalancingBST {

    public RedBlackTree(TreeNode root) {
        super(root);
    }

    @Override
    public void balance() {
        System.out.println("Do balance RedBlackTree");
    }
}
