//package linked_list;
//
//class Node {
//
//    String data;
//    Node next;
//
//    Node(String data){
//        this.data = data;
//        this.next = null;
//    }
//
//
//}
//
//public class LinkedList {
//    Node head;
//    private int size;
//
//    LinkedList(){
//        this.size = 0;
//    }
//
//    //add - first
//    public void addFirst(String data){
//        size++;
//        Node newNode = new Node(data);
//        if(head == null){
//            head = newNode;
//            return;
//        }
//
//        newNode.next = head;
//        head = newNode;
//    }
//
//    //add - last
//    public void addLast(String data){
//        size++;
//        Node newNode = new Node(data);
//        if(head == null){
//            head = newNode;
//            return;
//        }
//
//        Node currNode = head;
//        while (currNode.next != null){
//            currNode = currNode.next;
//        }
//        currNode.next = newNode;
//    }
//
//    //delete - first
//    public void deleteFirst(){
//        if(head == null){
//            System.out.println("The list is empty");
//            return;
//        }
//        size--;
//        head = head.next;
//    }
//
//    //delete - last
//    public void deleteLast(){
//        if(head == null){
//            System.out.println("The list is empty");
//            return;
//        }
//        size--;
//        if(head.next == null){
//            head = null;
//            return;
//        }
//        Node secondLast = head;
//        Node last = secondLast.next;
//
//        while (last.next != null){
//            last = last.next;
//            secondLast = secondLast.next;
//        }
//
//        secondLast.next = null;
//    }
//
//    //print
//    public void printList(){
//        if(head == null){
//            System.out.println("List is empty");
//            return;
//        }
//
//        Node currNode = head;
//        while(currNode != null){
//            System.out.print(currNode.data + " -> ");
//            currNode = currNode.next;
//        }
//        System.out.println("NULL");
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//
//
//        list.addFirst("a");
//        list.addFirst("is");
//
//        list.printList();
//
//        list.addLast("list");
//        list.printList();
//
//        list.deleteFirst();
//        list.printList();
//
//        list.deleteLast();
//        list.printList();
//
//        System.out.println(list.getSize());
//    }
//}
