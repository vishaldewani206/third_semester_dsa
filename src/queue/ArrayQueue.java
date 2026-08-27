package queue;

public class ArrayQueue implements Queue{
    private Object[] elements;
    private int size;

    ArrayQueue(int capacity){
        elements = new Object[capacity];
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(Object obj) {
        if(getSize() == elements.length){
            resize();
        }
        elements[size] = obj;
        size++;
    }

    public void resize(){
        Object[] tempArr = elements;
        elements = new Object[2 * tempArr.length]; //double the size
        System.arraycopy(tempArr, 0, elements, 0, getSize()); // copy all the elem from tempArr[] to elements[]
    }

    @Override
    public Object remove() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        Object data = elements[0];
        for (int i = 0; i < getSize() - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;

        return data;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(elements[i]).append(" ");
        }
        return sb.toString();
    }

    public Object first(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return elements[0];
    }

    public Object last(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return elements[getSize() - 1];
    }

    public boolean equal(ArrayQueue q){
        if(getSize() != q.getSize()) return false;

        for (int i = 0; i < getSize(); i++) {
            if(elements[i] != q.elements[i]){
                return  false;
            }
        }
        return true;
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
        System.out.println("First: " + arrayQueue.first());

//      at this point queue is full so if you
//      add more elements it will throw exception

        ArrayQueue arrayQueue2 = new ArrayQueue(5);
        arrayQueue2.add(3);
        arrayQueue2.add(2);
        arrayQueue2.add(5);
        arrayQueue2.add(4);
        arrayQueue2.add(6);

        System.out.println("Equal: " + arrayQueue.equal(arrayQueue2));

    }
}
