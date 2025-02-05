package anca.ds;

import anca.ds.lists.LinkedList;
import anca.ds.lists.Node;

public class Main {
    public static void main(String[] args) {
        /* Start Linked List methods tests */
        /*LinkedList ll = new LinkedList(11);
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

        ll4.set(0, 1995);
        ll4.printList();

        System.out.println(ll4.setAndReturn(0, 2000));
        ll4.printList();
        System.out.println(ll4.setAndReturn(0, 1000));
        ll4.printList();
        System.out.println(ll4.setAndReturn(0, 5000));
        ll4.printList();
        System.out.println(ll4.setAndReturn(2, 10000));
        ll4.printList();
        System.out.println(ll4.setAndReturn(3, 20000));
        ll4.printList();
        *//*System.out.println(ll4.setAndReturn(10, 50000));
        ll4.printList();*//*

        ll4.set2(2, 30);
        ll4.set2(0, 40);
        ll4.set2(5, 60);
        ll4.printList();

        LinkedList ll5 = new LinkedList(1);
        ll5.add(2);
        ll5.add(3);
        ll5.add(4);
        ll5.add(5);
        ll5.printList();
        ll5.insert(4,4444);
        ll5.printList();
        ll5.insert(0,-10000);
        ll5.printList();
        ll5.insert(7,5555);
        ll5.printList();
        ll5.insert(10,11111);
        ll5.printList();

        LinkedList ll6 = new LinkedList(1995);
        ll6.add(1996);
        ll6.add(1994);
        ll6.add(1967);
        ll6.printList();

        System.out.println(ll6.remove(0).getValue());
        ll6.printList();
        System.out.println(ll6.remove(3));
        ll6.printList();
        System.out.println(ll6.remove(2).getValue());
        ll6.printList();

        ll6.add(2996);
        ll6.add(2994);
        ll6.add(2967);
        ll6.printList();
        System.out.println(ll6.remove(3).getValue());
        ll6.printList();

        ll6.reverse();
        ll6.printList();
        ll6.removeLast();
        ll6.reverse();
        ll6.printList();
        ll6.removeFirst();
        ll6.reverse();
        ll6.printList();
        ll6.remove(0);
        ll6.reverse();
        ll6.printList();*/
        /* End Linked List methods tests */
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printList();
        list.reverse();
        list.printList();
    }
}