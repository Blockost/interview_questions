package dataStructures.tree;

/**
 * A {@link SelfBalancingBST} is a kind of {@link BinarySearchTree} which maintains its height small in order
 * to speed up operations.
 *
 * <p> Different algorithms are used to balance the tree. See implementations.
 */
public abstract class SelfBalancingBST extends BinarySearchTree {

    public SelfBalancingBST(TreeNode root) {
        super(root);
    }

    /**
     * Balances the tree in order to reduce its height.
     */
    public abstract void balance();
}
