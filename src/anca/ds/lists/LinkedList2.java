package anca.ds.lists;

// This LL implementation uses head & tail to handle edge cases
public class LinkedList2 implements ListInterface {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList2(int value) {
        head = tail = new Node(value);
        size = 1;
    }

    public LinkedList2() {};

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
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public Node removeFirst() {
        if (head == null) {
            return null;
        }

        Node firstNode = head;
        if (head == tail) {
            head = tail = head.next;
            size--;
        }
        else {
            head = head.next;
            size--;
        }
        return firstNode;
    }


    @Override
    public Node removeLast() {
        // Case 1: Empty list
        // Case 2 would also handle this case, if it wasn't handled here first.
        if (head == null) {
            return null;
        }

        Node temp = head;
        // Case 2: List has only one element
        if (head == tail) {
            head = tail = null;
            size = 0; // or size--
            return temp;
        }

        // Case 3: List has more than one element
        /* while (temp.next.next != null) {
            temp = temp.next;
        } */
        // Slightly more readable and 1 less operation. Both find the second to last node
        while (temp.next != tail) {
            temp = temp.next;
        }

        // Save the previous last node to return it
        Node previousTail = tail;

        // Update tail to the second to last node
        tail = temp;
        tail.next = null;
        size--;

        // Return the previous last node
        return previousTail;
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