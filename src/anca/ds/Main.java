package anca.ds;

import anca.ds.lists.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(11);
        ll.printList();

        ll.add(5);
        ll.add(27);
        ll.printList();

        ll.add(100);
        ll.printList();

        ll.removeLast();
        ll.printList();

        LinkedList ll2 = new LinkedList(1);
        ll2.printList();

        ll2.removeLast();
        ll2.printList();

        LinkedList emptyLL = new LinkedList();
        emptyLL.printList();

        emptyLL.add(2);
        emptyLL.add(4);
        emptyLL.add(6);
        emptyLL.printList();

        System.out.println("Removed node with value: " + emptyLL.removeLast().value);
    }
}