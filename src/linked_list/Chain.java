package linked_list;
import java.util.ArrayList;

/*
BASIC CONCEPT
A linked list stores elements in nodes.
Each node contains data and a link to the next node and
the last node is null which means end of the list.
*/



public class Chain {
    static class Node {
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

    }


    static int count = 0;

    static Node insert(Node start, int x){
        // when inserting first element or
        // the given value (x) is smaller than first node's value
        if(start == null || start.data > x){
            count++;
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
        count++;
        return start;
    }

    //print
    static void printList(Node start){
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

    // print only even numbers from list
    static void printEven(Node start){
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

    //delete a node
    static Node delete(Node start, int x){
        //list doesn't exist or value (x) is not in the list
        if(start == null || start.data > x){
            return start;
        }
        //if value exists on first node
        if(start.data  == x){
            count--;
            return start.next;
        }
        for(Node i = start; i.next != null; i = i.next){
            if(i.next.data > x){
                break;
            }
            if(i.next.data == x){
                count--;
                i.next = i.next.next;
                break;
            }
        }
        return start;
    }

    // replace a value in a node
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

    // combine two lists and return the combined list
    static Node merge(Node firstList, Node secondList){
        Node mergedList = firstList;

        Node temp2 = secondList;
        while(temp2 != null){
            mergedList = insert(mergedList, temp2.data);
            temp2 = temp2.next;
        }
        return mergedList;
    }


    // sum of all the values of list
    static int sum(Node start){
        int total = 0;
        Node p = start;
        while(p != null){
            total += p.data;
            p = p.next;
        }
        return total;
    }

    // reverse the list
    static void reverse(Node start){
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

    // return a portion of the list
    static Node sublist(Node start, int p, int q){
        if(start == null || p < 0 || p > q ){
            return null;
        }
        Node newList = null;
        Node current = start;
        int counter = 0;

        while(current != null && counter <= q){
            if (counter >= q){
                newList = insert(newList, current.data);
            }
            current = current.next;
            counter++;
        }

        return newList;

    }



    public static void main(String[] args) {
        Node start = null;

        start = insert(start, 1);
        start =  insert(start, 2);
        start =  insert(start, 3);
        start = insert(start, 4);
        start = insert(start, 5);
        start = insert(start, 6);


        start = delete(start, 1);

        start = replace(start, 4, 5);

        Node start2 = null;
        start2 = insert(start2, 8);
        start2 = insert(start2, 4);
        start2 = insert(start2, 10);

        Node mergedList = merge(start, start2);

        System.out.print("List: ");
        printList(mergedList);

        System.out.println("Sum of values: " + sum(mergedList));

        System.out.print("Reversed List: ");
        reverse(start);

    }
}
