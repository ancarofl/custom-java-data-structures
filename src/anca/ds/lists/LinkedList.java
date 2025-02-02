package anca.ds.lists;

// This LL implementation uses size to handle edge cases
public class LinkedList implements ListInterface {
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
         if (size == 0) {
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
        if (size == 0) {
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
            head = tail = null;
        }
        else {
            head = head.next;
        }

        size--;
        firstNode.next = null;
        /* If we skip the step above,
        the removed node might still hold a reference to the list,
        potentially causing memory leaks in long-running applications.
        This isn't strictly necessary in Java, but it helps the Garbage Collector.
        It's also clearer this way that
        this node has been disconnected from the LL.
        Furthermore, if we still had a note which points to the (new) first node
        of the LL, we'd technically have access and
        could traverse the LL through the solitary node. */
        return firstNode;
    }


    @Override
    public Node removeLast() {
        // Case 1: Empty list
        if (head == null) {
            return null;
        }

        Node temp = head;
        // Case 2: List has only one element. This would also handle case 1 if it wasn't already handled
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
    public Node get(int index) {
        // Validate that the index isn't out of bounds
        if (index < 0 || index >= size) { // or index > size - 1
            return null;
        }

        // Fast access to tail
        if (index == size - 1) {
            return tail;
        }

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
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