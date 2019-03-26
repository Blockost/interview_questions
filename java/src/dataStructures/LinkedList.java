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

    /**
     * Prepends the given to the head of the current list.
     *
     * @return A new {@link LinkedList} with the existing list as next
     */
    public LinkedList<T> prepend(T data) {
        LinkedList<T> newList = new LinkedList<>(data);
        newList.next = this;
        return newList;
    }

    public LinkedList<T> append(T data) {
        this.getTail().next = new LinkedList<>(data);
        return this;
    }

    public LinkedList<T> insert(T data, int index) {
        if (index == 0) {
            return this.prepend(data);
        }

        LinkedList<T> beforeNode = this.getNodeAt(index - 1);
        LinkedList<T> afterNode = beforeNode.next;
        beforeNode.next = new LinkedList<>(data);
        beforeNode.next.next = afterNode;

        return this;
    }

    public LinkedList<T> remove(int index) {
        if (index == 0) {
            this.data = this.next.data;
            this.next = this.next.next;
            return this;
        }

        LinkedList<T> beforeNode = getNodeAt(index - 1);
        beforeNode.next = beforeNode.next.next;
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
            throw new IndexOutOfBoundsException(String.format("LinkedList index ouf of bound. Index: %s, size: %s", index, this.length()));
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
