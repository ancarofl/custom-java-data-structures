package anca.ds.lists;

public class LinkedList implements ListInterface {
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size;

    public LinkedList(int value) {
        head = tail = new Node(value);
        size = 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printList() {
        System.out.println("The values in the linked list are: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}