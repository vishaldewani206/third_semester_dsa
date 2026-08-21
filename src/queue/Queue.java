package queue;

public interface Queue {
    public int getSize();
    public void add(Object obj);
    public Object remove();
}
