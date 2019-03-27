package dataStructures.tree;

/**
 * An AVL tree is an implementation of a self-balancing {@link BinarySearchTree}.
 */
public class AVLTree extends SelfBalancingBST {

    public AVLTree(TreeNode root) {
        super(root);
    }

    public void balance() {
        System.out.println("Do balance AVLTree");
    }
}
