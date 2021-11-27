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
    public void enqueue(Object element) throws IllegalArgumentException, IllegalStateException{
        if(element==null){
            throw new IllegalArgumentException("Null is not allowed");
        }else if(size < objectList.size()+1){
            throw new IllegalStateException("Q is full");
        }else objectList.add(element);
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
