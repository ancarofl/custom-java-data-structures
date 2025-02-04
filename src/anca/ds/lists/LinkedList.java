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
         if (head == null) {
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
            size--;
            return temp;
        }

        // Case 3: List has more than one element
        /* while (temp.next.next != null) {
            temp = temp.next;
        } */
        /* Slightly more readable and 1 less operation. Both find the second to last node.
        Temp.next can never be null because the while stops before that happens.
        It could only be null in a 1 element list, which is already handled in case 2. */
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
    public Node remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        /* Node beforeToRemove = head;
        for (int i = 0; i < index - 1; i++) {
            beforeToRemove = beforeToRemove.next;
        }
        Node toRemove = beforeToRemove.next; */

        Node beforeToRemove = get(index-1);
        Node toRemove = beforeToRemove.next;
        beforeToRemove.next = toRemove.next;
        toRemove.next = null;
        size--;
        return toRemove;
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

    // Replaces an item at a specific position in the list
    @Override
    public boolean set(int index, int value) {
        // Validate that the index isn't out of bounds
        if (index < 0 || index >= size) { // or index > size - 1
            return false;
        }

        if (index == size - 1) {
            tail.setValue(value);
            return true;
        }

        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        current.setValue(value);

        return true;
    }

    @Override
    public boolean set2(int index, int value) {
        Node currentNode = get(index);
        if (currentNode != null) {
            currentNode.setValue(value);
            return true;
        }
        else {
            return false;
        }
    }

    // Replaces an item at a specific position in the list and returns the value which was replaced
    @Override
    public int setAndReturn(int index, int value) {
        // Validate that the index isn't out of bounds. What's a better way to deal with it?
        if (index < 0 || index >= size) { // or index > size - 1
            throw new IndexOutOfBoundsException();
        }

        if (index == size - 1) {
            int prevValue = tail.getValue();
            tail.setValue(value);
            return prevValue;
        }

        Node current = head;
        for(int i = 0; i < index ; i++){
            current = current.next;
        }
        int prevValue = current.getValue();
        current.setValue(value);

        return prevValue;
    }

    @Override
    public boolean insert(int index, int value) {
        /* Out of bounds index. Note that unlike for other methods,
        it's ok to have an index which is equal to the size,
        aka 1 higher than existing LL index.
        That just means we append an item. */
        if (index < 0 || index > size) {
            return false;
        }

        // Case 1: insert at the end OR to an empty list (index = 0, size = 0)
        if (index == size) {
            add(value);
            return true;
        }

        /* Case 2: insert at the beginning (would also work for empty list, but it's handled in case 1).
        It actually does not matter if we handle case 1 or case 2 first, aka
        it does not matter which way we handle the empty list case, because add and addFirst are both O(1). */
        if (index == 0) {
            addFirst(value);
            return true;
        }
        /* Size isn't increased for cases 1 and 2 cus it's handled by the called methods */

        /* Case 3: the rest. The idea when inserting in the middle of a LL is that we need to know the node that will
        come before the new node, as well as the node that will come after it, because we need to create links between those and the new node. */
        Node current = head;
        Node prev = null;
        for (int i = 0;i < index; i++) {
            prev = current;
            current = current.next;
        }
        Node newNode = new Node(value);
        prev.next = newNode;
        newNode.next = current;

        size++;
        return true;
    }

    @Override
    public boolean insert2(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }

        // Case 1: insert at the end
        if (index == size) {
            add(value);
            return true;
        }

        // Case 2: insert at the beginning
        if (index == 0) {
            addFirst(value);
            return true;
        }

        // Case 3: the rest
        Node newNode = new Node(value);
        Node prevNode = get(index-1);
        // if (prevNode == null) return false; // pointless to add this check, because this would only happen if index is 0, which is handled
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
        return true;
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