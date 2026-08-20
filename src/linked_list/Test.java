package linked_list;


public class Test {
    public class Node4 {
        int data;
        Node4 next;

        Node4(int data, Node4 next){
            this.data = data;
            this.next = next;
        }
    }


    public void sumAndAvg(Node4 start, Node4 second){
        int total = 0;
        int count = 0;

        Node4 p = start;
        Node4 q = second;

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
        float avg = total / count;
        System.out.println("Total: "+ total);
        System.out.println("Avg: " + avg);
    }

    public void printing(Node4 first, Node4 second){
        Node4 p = first;
        Node4 q = second;

        while(p != null && q != null){
            System.out.print(p.data + " " + q.data + " ");
            p = p.next;
            q = q.next;
        }
        System.out.println();
    }

    public void lastElm(Node4 first, Node4 second){
        Node4 p = first;
        Node4 q = second;

        Node4 temp = null;

        while(p.next != null){
            temp = p;
            p = p.next;
        }
        System.out.println("Second Last:" + temp.data);

        while(q.next != null){
            temp = q;
            q = q.next;
        }
        System.out.println("Second last of second:" + temp.data
        );

    }


     Node4  insert(Node4 start, int x){
        // when inserting first element or the value
        // is smaller than first element's value
        if(start == null || start.data > x){
            start = new Node4(x, start);
            return start;
        }

        //inserting when one or more node exists

        Node4 p = start;

        while(p.next != null){
            if(p.next.data > x){
                break;
            }
            p = p.next;
        }

        p.next = new Node4(x, p.next);

        return start;
    }
    public static void main(String[] args) {
        Test m = new Test();
        Node4 start = null;
        start = m.insert(start, 4);
        start = m.insert(start, 8);
        start = m.insert(start, 12);
        start = m.insert(start, 16);
        Node4 second = null;
        second = m.insert(second, 6);
        second = m.insert(second, 9);
        second = m.insert(second, 11);
        second = m.insert(second, 13);

        m.lastElm(start, second);
        m.printing(start, second);
        m.sumAndAvg(start, second);
    }
}
