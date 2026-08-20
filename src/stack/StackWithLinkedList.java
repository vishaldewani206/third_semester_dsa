package stack;

/*
BASIC CONCEPT
A stack follows the LIFO (Last In, First Out) principle.
The last element added is the first one removed.
Example:
adding 1, 3, 0, 5 in the stack
and when you print the stack 5 will be at first position (5 0 3 1)
*/


import java.util.Arrays;

public class StackWithLinkedList implements Stack {
    private int size;
    private Node top; //element on the top of the stack

    private static class Node{
        Object data;
        Node next;

        Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    //add element at the top
    @Override
    public void push(Object obj) {
        top = new Node(obj, top);
        ++size;
    }

    // get value of the top element
    @Override
    public Object peek() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // remove the element from top and return the value of that element
    @Override
    public Object pop() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        Object temp = top.data;
        top = top.next;
        --size;
        return temp;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public String toString(){
        if(isEmpty()){
            return "Stack is empty";
        }
        StringBuilder bf = new StringBuilder();
        for (Node i = top; i != null; i = i.next) {
            bf.append(i.data).append(" ");
        }
        return bf.toString();
    }

    // get the element which is at bottom
    // to get to the bottom element we have to traverse until we reach NULL
    public Object bottom_element(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        Node temp = top;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp.data;
    }

    // get middle element in the stack
    public String middle_element() {
        int middle = size / 2;
        Node temp = top;

        for (int i = 0; i < middle - 1; i++) {
            temp = temp.next;
        }

        // works when the stack has even number of values
        StringBuilder sb = new StringBuilder();
        if (size % 2 == 0) {
            sb.append(temp.data).append(" ").append(temp.next.data);
            return sb.toString();
        }

        // works when the stack has odd number of values
        // so it returns both values as Array of Object

        sb.append(temp.next.data);
        return sb.toString();
    }

    public boolean equals(StackWithLinkedList sk){
        if(getSize() != sk.size){
            return false;
        }

        for(Node a = top, b = sk.top; a != null; a = a.next, b = b.next ){
            // this equals functions is for the String comparison (built-in function)
            if (!a.data.equals(b.data)) {
                return false;
            }
        }

        return true;
    }

    public Object[] spiltInHalf(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }

        Node temp = top;

        for(int i =1; i != getSize() / 2; i++){
            temp = temp.next;
        }
        Node newList = temp.next;
        temp.next = null; //splits the list
        return new Object[]{top, newList};
    }


    public Node merge(StackWithLinkedList sk){
        if(this.top == null){
            this.top = sk.top;
            this.size = sk.size;
            return this.top;
        }

        Node temp = top;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = sk.top;
        this.size = this.size + sk.getSize();
        return this.top;
    }




    public static void main(String[] args) {
        StackWithLinkedList s1 = new StackWithLinkedList();
        System.out.println("Is empty:" + s1.isEmpty());
        s1.push(1);
        s1.push(3);
        s1.push(0);
        s1.push(5);
        s1.push(6);

        System.out.println("Stack: " + s1);
        System.out.println("Size: " + s1.getSize());
        System.out.println("Top element: " + s1.peek());
        s1.pop();
        System.out.println("Stack after pop: " + s1);

        System.out.println("Middle Element: " + s1.middle_element());

        StackWithLinkedList s2 = new StackWithLinkedList();
        s2.push(8);
        s2.push(2);
        s2.push(100);

        s1.merge(s2);

        System.out.println("Stack after merge: " + s1);


    }

}
