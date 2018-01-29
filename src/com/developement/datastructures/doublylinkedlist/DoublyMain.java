package com.developement.datastructures.doublylinkedlist;

import com.developement.datastructures.doublylinkedlist.DoublyLinkedList;

import java.util.Stack;

public class DoublyMain {

    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();


        list1.insertAtTail(5);
        list1.insertAtTail(6);
        list1.insertAtFront(4);

        list1.printList();

        list1.addInMiddel(2,8);

        list1.printList();

        list1.addInMiddel(3,10);

        list1.printList();

        Stack s = new Stack();
    }
}
