package anca.ds;

import anca.ds.lists.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(11);
        ll.printList();
        System.out.println("The size of the list after creation is: " + ll.size());
        ll.add(5);
        ll.add(27);
        ll.printList();
        System.out.println("The size of the list is after add: " + ll.size());
        ll.add(100);
        ll.printList();
        System.out.println("The size of the list is afer more add: " + ll.size());
        ll.removeLast();
        ll.printList();
        System.out.println("The size of the list after removeLast: " + ll.size());
        LinkedList ll2 = new LinkedList(1);
        ll2.printList();
        System.out.println("The size of the list after removeLast: " + ll2.size());
        ll2.removeLast();
        ll2.printList();
        System.out.println("The size of the list after removeLast: " + ll2.size());
    }
}