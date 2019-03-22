package dataStructures;

/**
 * Implementation of Stack data structure with static array.
 */
public class Stack {
    private int[] stack;
    private int maxCapacity;
    private int top;

    public Stack(int maxCapacity) {
        this.stack = new int[maxCapacity];
        this.maxCapacity = maxCapacity;
        this.top = -1;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.err.println("Cannot pop from an empty stack --> StackUnderflow");
            System.exit(1);
        }

        return this.stack[top--];
    }

    public int peek() {
        if (this.isEmpty()) {
            System.err.println("Cannot peek from an empty stack --> StackUnderflow");
            System.exit(1);
        }

        return this.stack[top];
    }

    public void push(int x) {
        if (this.isFull()) {
            System.err.println("Cannot push to a full stack --> StackOverflow");
            System.exit(1);
        }

        this.stack[++top] = x;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == maxCapacity - 1;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Empty stack";
        }

        StringBuilder ss = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            ss.append(this.stack[i]).append(" | ");
        }

        return ss.toString();
    }
}
