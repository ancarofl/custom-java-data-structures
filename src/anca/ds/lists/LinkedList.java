package anca.ds.lists;

public class LinkedList {
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int length;

    public LinkedList(int value) {
        head = tail = new Node(value);
        length = 1;
    }

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