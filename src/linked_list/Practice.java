package linked_list;

public class Practice {
    public class Node3 {
        int data;
        Node3 next;

        public Node3(int data, Node3 next){
            this.data = data;
            this.next = next;
        }

        public Node3 insert(int x, Node3 start){
            if(start == null || start.data > x){
                start = new Node3(x, start);
                return start;
            }

            Node3 p = start;

            while(p.next != null){
                if(p.next.data > x){
                    break;
                }
                p = p.next;
            }
            p.next = new Node3(x, p.next);
            return start;
        }
    }



    public static void main(String[] args) {
        Node3 start = null;
        start = start.insert(10, start);
        start = start.insert(20, start);

    }

}
