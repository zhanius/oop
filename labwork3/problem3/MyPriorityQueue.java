package labwork3.problem3;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueue implements MyCollection {
    Queue<Object> queue = new PriorityQueue<>();
    @Override
    public void add(Object element){
        queue.add(element);
    }
    @Override
    public void clear(){
        queue.clear();
    }
    @Override
    public int size(){
        return queue.size();
    }
    @Override
    public void remove(Object element){
        queue.remove();
    }
    @Override
    public boolean contains(Object element){
        return queue.contains(element);
    }
    @Override
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    @Override
    public String toString(){
        return queue.toString();
    }
}
