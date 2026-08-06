package linked_list;

import java.util.ArrayList;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }


    static Node  insert(Node start, int x){
        if(start == null || start.data > x){
            start = new Node(x, start);
            return start;
        }

        Node p = start;

        while(p.next != null){
            if(p.next.data > x){
                break;
            }
            p = p.next;
        }

        p.next = new Node(x, p.next);

        return start;
    }




}



public class Chain {


    //print
    public static void printList(Node start){
        if(start == null){
            System.out.println("List is empty");
            return;
        }

        Node currNode = start;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void printEven(Node start){
        ArrayList<Integer> arr = new ArrayList<>();
        for(Node i = start; i != null; i = i.next ){
            arr.add(i.data);
        }

        for(int j =0; j < arr.size(); j++){
            if(arr.get(j) % 2 == 0){
                System.out.println(arr.get(j));
            }
        }
    }


    static Node delete(Node start, int x){
        if(start == null || start.data > x){
            return start;
        }
        if(start.data  == x){
            return start.next;
        }
        for(Node i = start; i.next != null; i = i.next){
            if(i.next.data > x){
                break;
            }
            if(i.next.data == x){
                i.next = i.next.next;
                break;
            }
        }
        return start;
    }


    public static void main(String[] args) {
//        Node p = start;
//        for(int i =2; i < 5; i++){
//            p.next = new Node(i *10);
//            p = p.next;
//        }

        Node start = null;

        start = Node.insert(start, 1);
        start =  Node.insert(start, 2);
        start =  Node.insert(start, 3);
        start = Node.insert(start, 4);
        start = Node.insert(start, 5);
        start = Node.insert(start, 6);

        printList(start);

        printEven(start);

        start = delete(start, 1);

        printList(start);


    }
}
