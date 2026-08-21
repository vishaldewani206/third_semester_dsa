package linked_list;


public class Test {
    static class Node {
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }


    void sumAndAvg(Node start, Node second){
        int total = 0;
        int count = 0;

        Node p = start;
        Node q = second;

        while(p != null){
            total += p.data;
            count++;
            p = p.next;
        }
        while(q != null){
            total += q.data;
            count++;
            q = q.next;
        }
        float avg = (float) total / count;
        System.out.println("Total: "+ total);
        System.out.println("Avg: " + avg);
    }

    void printing(Node first, Node second){
        Node p = first;
        Node q = second;

        System.out.print("Print both lists together: ");
        while(p != null && q != null){
            System.out.print(p.data + " " + q.data + " ");
            p = p.next;
            q = q.next;
        }
        System.out.println();
    }

    void lastElm(Node first, Node second){
        Node p = first;
        Node q = second;

        Node temp = null;

        while(p.next != null){
            temp = p;
            p = p.next;
        }
        System.out.println("Second Last Value: " + temp.data);

        while(q.next != null){
            temp = q;
            q = q.next;
        }
        System.out.println("Second last value of second list: " + temp.data
        );

    }


     Node  insert(Node start, int x){
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
    public static void main(String[] args) {
        Test m = new Test();
        Node start = null;
        start = m.insert(start, 4);
        start = m.insert(start, 8);
        start = m.insert(start, 12);
        start = m.insert(start, 16);
        Node second = null;
        second = m.insert(second, 6);
        second = m.insert(second, 9);
        second = m.insert(second, 11);
        second = m.insert(second, 13);

        m.lastElm(start, second);
        m.printing(start, second);
        m.sumAndAvg(start, second);
    }
}
