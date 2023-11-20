package labwork3.problem3;

//for ArrayList, PriorityQueue
public interface MyCollection<T> {
    void add(T element);
    void clear();
    int size();
    void remove(T element);
    boolean contains(T element);
    boolean isEmpty();
    String toString();
}
