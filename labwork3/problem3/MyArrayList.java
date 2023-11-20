package labwork3.problem3;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList implements MyCollection{
    List<Object> list = new ArrayList<>();
    @Override
    public void add(Object element){
        list.add(element);
    }
    @Override
    public void clear(){
        list.clear();
    }
    @Override
    public int size(){
        return list.size();
    }
    @Override
    public void remove(Object element) {
        list.remove(element);
    }
    @Override
    public boolean contains(Object element) {
        return list.contains(element);
    }
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString(){
        return list.toString();
    }
}
