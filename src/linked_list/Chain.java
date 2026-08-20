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
        // when inserting first element or the value
        // is smaller than first element's value
        if(start == null || start.data > x){
            start = new Node(x, start);
            return start;
        }

        //inserting when one or more node exists

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
    int count = 0;
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
        //list doesn't exist or value not exists
        if(start == null || start.data > x){
            return start;
        }
        //if value exists on first node
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

    static Node replace(Node start, int x, int y){
        if(start == null || start.data > x){
            return start;
        }
        if(start.data  == x){
            start.data = y;
            return start;
        }
        for(Node i = start; i.next != null; i = i.next){
            if(i.next.data > x){
                break;
            }
            if(i.next.data == x){
                i.next.data = y;
                break;
            }
        }
        return start;
    }
//reverse, slicing, insert, sum, sublist, merge

    public static Node merge(Node firstList, Node secondList){
        Node mergedList = firstList;

        Node temp2 = secondList;
        while(temp2 != null){
            mergedList = Node.insert(mergedList, temp2.data);
            temp2 = temp2.next;
        }
        return mergedList;
    }


    public static int sum(Node start){
        int total = 0;
        Node p = start;
        while(p != null){
            total += p.data;
            p = p.next;
        }
        return total;
    }

    public static void reverse(Node start){
        ArrayList<Integer> temp_arr = new ArrayList<>();
        Node p = start;
        while(p != null){
            temp_arr.add(p.data);
            p = p.next;
        }
        for (int i = temp_arr.size()-1; i > 0; i--) {
            System.out.print(temp_arr.get(i) + " -> ");
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static Node sublist(Node start, int p, int q){
        if(start == null || p < 0 || p > q ){
            return null;
        }
        Node newList = null;
        Node current = start;
        int counter = 0;

        while(current != null && counter <= q){
            if (counter >= q){
                newList = Node.insert(newList, current.data);
            }
            current = current.next;
            counter++;
        }

        return newList;

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


        start = delete(start, 1);

        start = replace(start, 4, 5);

        Node start2 = null;
        start2 = Node.insert(start2, 8);
        start2 = Node.insert(start2, 4);
        start2 = Node.insert(start2, 10);

        Node mergedList = merge(start, start2);

        printList(mergedList);

        System.out.println(sum(mergedList));

        reverse(start);

    }
}
