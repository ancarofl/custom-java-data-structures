package anca.ds.lists;

public class LinkedList implements ListInterface {
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

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
        System.out.print("Linked List: [");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println("]");
    }
}