package queue;

import java.util.ArrayList;
import java.util.List;

public class BoundedArrayQueue implements QueueADT{

    private List<Object> objectList;

    public BoundedArrayQueue(int size)
    {
        objectList = new ArrayList<>(size);
    }

    @Override
    public void enqueue(Object element) {
        objectList.add(element);
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
