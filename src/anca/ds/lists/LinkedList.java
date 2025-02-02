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
        if (size == 0) {
            return null;
        }

        Node firstNode = head;
        if (size == 1) {
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
        // Case 1: Empty list.
        // If checking it by checking if head == tail, case 2 would also technically handle this case.
        if (size == 0) { // or head == null
            return null;
        }

        Node temp = head;
        // Case 2: List has only one element
        if (size == 1) {
            /* Or if (head == tail) or if(temp.next) == null
            Checking size for edge cases is clearer for this custom implementation.
            Not sure if it's better, and it's not consistent with the case 3 check.
            On the other hand, by just checking head == tail we would be checking for both case 1 and 2. */
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