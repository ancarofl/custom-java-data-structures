package anca.ds;

import anca.ds.lists.LinkedList;
import anca.ds.lists.Node;

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
        emptyLL.add(8);
        emptyLL.printList();

        System.out.println("Removed node with value: " + emptyLL.removeLast().getValue());
        emptyLL.printList();

        LinkedList ll3 = new LinkedList();
        ll3.printList();

        ll3.addFirst(100);
        ll3.printList();

        ll3.addFirst(300);
        ll3.addFirst(200);
        ll3.printList();

        System.out.println("Removed node with value: " + ll3.removeFirst().getValue());
        ll3.printList();

        System.out.println("Removed node with value: " + ll3.removeFirst().getValue());
        ll3.printList();

        System.out.println("Removed node with value: " + ll3.removeFirst().getValue());
        ll3.printList();

        LinkedList ll4 = new LinkedList(60);
        ll4.add(61); ll4.add(62); ll4.add(63);
        ll4.printList();

        System.out.println(ll4.get(0).getValue());
        System.out.println(ll4.get(2).getValue());
        System.out.println(ll4.get(1).getValue());
        System.out.println(ll4.get(3).getValue());
        Node node = ll4.get(10);
        System.out.println(node != null ? node.getValue() : null);
        node = ll4.get(-4);
        System.out.println(node != null ? node.getValue() : null);
        node = ll4.get(4);
        System.out.println(node != null ? node.getValue() : null);
    }
}