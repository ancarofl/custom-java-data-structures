package anca.ds.lists;

public interface ListInterface {
    void add(int value); // aka append
    void addFirst(int value); // aka prepend
    Node removeFirst();
    Node removeLast();
    Node remove(int index);
    Node get(int index);
    boolean set(int index, int value);
    int setAndReturn(int index, int value);
    boolean insert(int index, int value);
    // boolean contains(int value);
    int size();
    // boolean isEmpty();
    void printList();
    void reverse();

}
