package anca.ds.lists;

public interface ListInterface {
    void add(int value); // aka append
    void addFirst(int value); // aka prepend
    // void remove();
    Node removeFirst();
    Node removeLast();
    Node get(int index);

    // boolean contains(int value);
    int size();
    // boolean isEmpty();
    void printList();
}
