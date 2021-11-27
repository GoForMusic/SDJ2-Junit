package queue;

import java.util.ArrayList;
import java.util.List;

public class BoundedArrayQueue implements QueueADT{

    private List<Object> objectList;
    private int size;

    public BoundedArrayQueue(int size)
    {
        objectList = new ArrayList<>(size);
        this.size = size;
    }

    @Override
    public void enqueue(Object element) {
        if(element == null) throw new IllegalArgumentException("Null argument is not allowed!");
        objectList.add(element);
        if(objectList.size()>size) throw new IllegalStateException("The limit has been exceeded!");
    }

    @Override
    public Object dequeue() {
        return objectList.remove(objectList.size());
    }

    @Override
    public Object first() {
        return objectList.get(0);
    }

    @Override
    public int size() {
        return objectList.size();
    }

    @Override
    public boolean isEmpty() {
        return objectList.isEmpty();
    }

    @Override
    public int indexOf(Object element) {
        return objectList.indexOf(element);
    }

    @Override
    public boolean contains(Object element) {
        return objectList.contains(element);
    }
}
