package linked_list;

// linked list with objects as data. object will be of users (HW)

class Node1 {
    String data;
    Node1 next;

    Node1(String data){
        this.data = data;
    }




}

public class SecondList {


    static void printList(Node1 start){
        for(Node1 i = start; i != null; i = i.next){
            System.out.println(i.data);
        }
    }

    public static void main(String[] args) {
        Node1 head = new Node1("Vishal");
        head.next = new Node1("Ali");
        head.next.next = new Node1("Shahzaib");
        head.next.next.next = new Node1("Haroon");
        head.next.next.next.next = new Node1("Hameed");
        head.next.next.next.next.next = new Node1("Mehdi");


        printList(head);

    }
}
