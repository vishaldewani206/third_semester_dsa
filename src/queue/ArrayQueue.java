package queue;

public class ArrayQueue implements Queue{
    private Object[] elements;
    private int front;
    private int rear;
    private int size;

    ArrayQueue(int capacity){
        elements = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(Object obj) {
        if(getSize() == elements.length){
            throw new IllegalStateException("Queue is full");
        }

        elements[rear] = obj;
        rear = (rear + 1) % elements.length;
        size++;
    }

    @Override
    public Object remove() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        Object data = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return data;
    }


    public Object peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        return elements[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            int index = (front + i) % elements.length;
            sb.append(elements[index]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);

        arrayQueue.add(1);
        arrayQueue.add(3);
        arrayQueue.add(2);
        arrayQueue.add(5);

        System.out.println("OUT <- " + arrayQueue + " <- IN");
        System.out.println("Element removed: " + arrayQueue.remove());
        System.out.println("After removed: " + arrayQueue);

        arrayQueue.add(4);
        arrayQueue.add(6);
        System.out.println("After add: " + arrayQueue);
        System.out.println("Peek: " + arrayQueue.peek());

//      at this point queue is full so if you
//      add more elements it will throw exception

    }
}
