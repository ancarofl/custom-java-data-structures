package anca.ds;

import anca.ds.lists.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(11);
        ll.printList();
        System.out.println("The size of the list is: " + ll.size());
    }
}