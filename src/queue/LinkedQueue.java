package queue;

/*
BASIC CONCEPT
A doubly linked list stores data in nodes.
Each node has links to both the previous and next node.

A queue follows FIFO (First In, First Out).
The first element added is the first one removed.
*/

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

    Node head = new Node(null);

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

    public String toString(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");

        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while(temp.next != head){
            sb.append(temp.next.data).append(" ");
            temp = temp.next;
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();

        linkedQueue.add(1);
        linkedQueue.add(8);
        linkedQueue.add(10);
        linkedQueue.add(0);
        linkedQueue.add(5);

        System.out.println("Queue: OUT <- " + linkedQueue + "<- IN");
        linkedQueue.remove();
        System.out.println("Queue after remove: " + linkedQueue);
        System.out.println("Queue size: " + linkedQueue.getSize());
        System.out.println("Queue first value: " + linkedQueue.first());

    }


}
