/**
 * Created by blockost on 20/03/17.
 */
public class LinkedList {
    int data;
    LinkedList next;

    public LinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedList(int data, LinkedList next) {
        this.data = data;
        this.next = next;
    }

    public boolean hasNext(){
        return this.next != null;
    }

    public LinkedList add(int data){
        if(this.hasNext())
            return this.next.add(data);

        this.next = new LinkedList(data);
        return this.next;
    }

    public void redirectTail(LinkedList node){
        this.t_redirectTail(this, node);
    }

    private void t_redirectTail(LinkedList linkedList, LinkedList node){
        if(linkedList.hasNext()) t_redirectTail(linkedList.next, node);
        linkedList.next = node;
    }

    public int length(){
        return this.t_length(this.next, 1);
    }

    private int t_length(LinkedList linkedList, int acc){
        if(!linkedList.hasNext()) return acc + 1;
        return t_length(linkedList.next, acc + 1);
    }

    public LinkedList getNodeAt(int index){
        if(index == 0) return this;
        if(!this.hasNext()) return null;
        return this.t_getNodeAt(this.next, index - 1);
    }

    private LinkedList t_getNodeAt(LinkedList linkedList, int index){
        if(index == 0) return linkedList;
        if(!linkedList.hasNext()) return null;
        return t_getNodeAt(linkedList.next, index - 1);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        if (!this.hasNext()) return "(" + data + ")";

        s.append("(" + data + ") --> ");
        s.append(this.next.toString());

        return s.toString();
    }
}
