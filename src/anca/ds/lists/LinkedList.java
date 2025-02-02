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

    public LinkedList() {};

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
         if (head == null) { // if size==0 also works
            head = tail = newNode;
         }
         else {
             tail.next = newNode;
             tail = newNode;
         }
         size++;
    }

    @Override
    public void removeLast() {
        // Case 1: Empty list.
        // If checking it by checking if head == tail, case 2 would also technically handle this case.
        if (size == 0) { // or head == null
            return;
        }

        // Case 2: List has only one element
        if (size == 1) {
            /* Or if (head == tail) or if(temp.next) == null
            Checking size for edge cases is clearer for this custom implementation.
            Not sure if it's better, and it's not consistent with the case 3 check.
            On the other hand, by just checking head == tail we would be checking for both case 1 and 2. */
            head = tail = null;
            size = 0; // or size--
            return;
        }

        // Case 3: List has more than one element
        Node temp = head;
        /* while (temp.next.next != null) {
            temp = temp.next;
        } */
        // Slightly more readable and 1 less operation. Both find the second to last node
        while (temp.next != tail) {
            temp = temp.next;
        }

        // Update tail to the second to last node and remove the last node
        tail = temp;
        tail.next = null;
        size--;
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