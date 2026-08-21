package queue;

public class LinkedQueue implements Queue{
    private int size;
    static class Node{
        Object data;
        Node prev = this;
        Node next = this;

        Node (Object data){
            this.data = data;
        }
        Node(Object data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public Node head = new Node(null);

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(Object obj) {
        ++size;
        head.prev.next = new Node(obj, head.prev, head);
        head.prev = head.prev.next;
    }

    @Override
    public Object remove() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        --size;
        Object temp = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        return temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object first(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        return head.next.data;
    }


}
