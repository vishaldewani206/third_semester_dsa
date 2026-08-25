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

    public String toStringReverse(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");

        StringBuilder sb = new StringBuilder();
        Node temp = head;

        while(temp.prev != head){
            sb.append(temp.prev.data).append(" ");
            temp = temp.prev;
        }

        return sb.toString();
    }

    public int[] toArray(int n){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");

        int[] arr = new int[n];

        Node temp = head.next;
        int i = 0;
        while(temp != head){
            if(i == n){
                break;
            }
            arr[i] = (int) temp.data;
            i++;
            temp = temp.next;
        }

        return arr;

    }

    public int[] toArray(int start, int end){
        if (start < 0 || end >= size || start > end) {
            throw new IndexOutOfBoundsException("Incorrect indices");
        }

        int[] arr = new int[end-start + 1];
        Node temp = head.next;

        for(int i = 0; i < start; i++){
            temp = temp.next;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) temp.data;
            temp = temp.next;
        }

        return arr;

    }

    public boolean equals(LinkedQueue other){
        if(getSize() != other.getSize()){
            return false;
        }

        Node temp = head;
        Node temp2 = other.head;

        while(temp.next != head && temp2.next != head){

            if(temp.data != temp2.data){
                return false;
            }

            temp = temp.next;
            temp2 = temp2.next;
        }

        return true;


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
//        System.out.println(linkedQueue.toStringReverse());


        int[] arr = linkedQueue.toArray(2); // only ending: from 0 to n
        int[] arr2 = linkedQueue.toArray(1, 3); // starting and ending


        for (int j : arr2){
            System.out.println("elem: " + j);
        }


        LinkedQueue linkedQueue1 = new LinkedQueue();
        linkedQueue1.add(8);
        linkedQueue1.add(10);
        linkedQueue1.add(0);
        linkedQueue1.add(5);

        System.out.println("first queue = second queue: " +linkedQueue.equals(linkedQueue1));

    }


}
