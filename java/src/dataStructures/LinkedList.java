package dataStructures;

/**
 * Created by blockost on 20/03/17.
 */
@SuppressWarnings("WeakerAccess")
public class LinkedList<T> {
    private T data;
    private LinkedList<T> next;

    public LinkedList(T data) {
        this.data = data;
        this.next = null;
    }

    public LinkedList(T data, LinkedList<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getHead() {
        return this.data;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public LinkedList<T> getNext() {
        return this.next;
    }

    public LinkedList<T> add(T data) {
        if (this.hasNext()) {
            return this.next.add(data);
        }

        this.next = new LinkedList<>(data);
        return this;
    }

    public int length() {
        if (!this.hasNext()) {
            return 1;
        }

        return this.computeLength(this.next, 2);
    }

    private int computeLength(LinkedList linkedList, int acc) {
        if (linkedList.hasNext()) {
            return this.computeLength(linkedList.getNext(), ++acc);
        }
        return acc;
    }


    public LinkedList<T> getNodeAt(int index) {
        if (this.length() <= index) {
            System.err.println(String.format("LinkedList index ouf of bound. Index: %s, size: %s", index, this.length()));
            return null;
        }

        if (index == 0) {
            return this;
        }
        return this.next.getNodeAt(--index);
    }

    public LinkedList<T> getTail() {
        return this.getNodeAt(this.length() - 1);
    }

    public void redirectTail(LinkedList<T> node) {
        this.getTail().next = node;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        if (!this.hasNext()) return "(" + data + ")";

        s.append("(").append(data).append(") --> ");
        s.append(this.next.toString());

        return s.toString();
    }
}
