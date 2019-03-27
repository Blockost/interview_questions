package dataStructures;

public class DataStructures {

    public static void test() {
        System.out.println("*** Testing data structures problems ***");

        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(3);
        TreeNode n1 = new TreeNode(2, n7, n8);

        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(7);
        TreeNode n2 = new TreeNode(6, n3, n4);

        TreeNode root = new TreeNode(4, n1, n2);

        System.out.println(root);
        boolean bool = BinarySearchTree.checkBST(root);
        System.out.println(bool);

        // LinkedList
        System.out.println("Testing LinkedList implementation");
        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList = linkedList.append(5).prepend(0).insert(2, 2).append(3).remove(3);
        System.out.println(linkedList);
        System.out.println(String.format("LinkedList length: %s", linkedList.length()));

        // Create a cycle by redirecting the last node to the 3rd one
        // This will break every other operations: StackOverflow exception
        LinkedList<Integer> tail = linkedList.getTail();
        linkedList.redirectTail(tail);
        System.out.println(CycledLinkedList.hasCycle(linkedList));

        // Stack
        System.out.println("Testing Stack implementation");
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(String.format("Stack is: %s", stack));
        stack.peek();
        stack.pop();
        stack.pop();
        System.out.println(String.format("Stack is: %s", stack));

        // HashMap
        System.out.println("Testing HashMap implementation");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Foo", 1);
        hashMap.put("Bar", 2);
        hashMap.put("Foo", 3);
        hashMap.remove("Foo");
        hashMap.put("Foo", 1000);
        System.out.println(String.format("HashMap is: %s", hashMap));

        // HashSet
        System.out.println("Testing HashSet implementation");
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.remove(3);
        System.out.println(hashSet);
    }
}
