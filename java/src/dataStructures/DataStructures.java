package dataStructures;

public class DataStructures {

    public static void test() {
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(3);
        TreeNode n1 = new TreeNode(2, null, n8);

        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(7);
        TreeNode n2 = new TreeNode(6, n3, n4);

        TreeNode root = new TreeNode(4, n1, n2);

        System.out.println(root);
        boolean bool = BinarySearchTree.checkBST(root);
        System.out.println(bool);

        LinkedList linkedList = new LinkedList(1);
        linkedList.add(2).add(3).add(4);
        System.out.println(linkedList);
        System.out.println(linkedList.length());

        // Create a cycle by redirecting the last node to the 3rd one
        // This will break every other operations: StackOverflow exception
        LinkedList node3 = linkedList.getNodeAt(3);
        linkedList.redirectTail(node3);
        System.out.println(CycledLinkedList.hasCycle(linkedList));

        // Stack
        System.out.println("Testing Stack implementation");
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.peek();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
