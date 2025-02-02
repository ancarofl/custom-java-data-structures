package anca.ds.lists;

public interface ListInterface {
    void add(int value); // aka append
    void addFirst(int value); // aka prepend
    // void remove();
    Node removeFirst();
    Node removeLast();
    // boolean contains(int value);
    int size();
    // boolean isEmpty();
    void printList();
}
