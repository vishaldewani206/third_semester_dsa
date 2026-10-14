package recursion;

public class LinkedListRecursion {
    static class Node{
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }


    static void printList(Node list){
        if(list == null){
            return;
        }
        System.out.println(list.data);
        printList(list.next);
    }

    static int sum(Node list){
        if(list == null){
            return 0;
        }

        return list.data + sum(list.next);
    }

    static void even(Node list){
        if(list == null){
            return;
        }

        if(list.data % 2 == 0){
            System.out.println(list.data);
        }

        even(list.next);
    }


    public static void main(String[] args) {
        Node head = new Node(10, null);
        head.next = new Node(20, null);
        head.next.next = new Node(30, null);
        head.next.next.next = new Node(40, null);


        printList(head);
        System.out.println(sum(head));
    }
}
