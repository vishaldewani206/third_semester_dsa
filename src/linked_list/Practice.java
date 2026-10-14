package linked_list;

public class Practice {
    static class Node{
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    static Node insert(Node start, int x){
        if(start == null || start.data > x){
            start = new Node(x, start);
            return start;
        }

        Node temp = start;

        while(temp.next != null){
            if(temp.next.data > x ){
                break;
            }
            temp = temp.next;
        }

        temp.next = new Node(x, temp.next);

        return start;
    }

    public static void main(String[] args) {
        Node start = null;

        start = insert(start, 1);
        start = insert(start, 2);


    }

}
