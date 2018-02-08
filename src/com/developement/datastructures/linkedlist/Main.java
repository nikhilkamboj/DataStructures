package com.developement.datastructures.linkedlist;

import com.developement.datastructures.linkedlist.LinkedList;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        LinkedList list1= new LinkedList();

        list1.addToFront(4);
        list1.addToFront(3);
        list1.addToFront(2);
        list1.addToFront(1);

        list1.addToLast(5);
        list1.addToLast(6);
        list1.addToLast(7);
        list1.addToLast(8);

        list1.deleteNode(0);
        list1.deleteNode(0);
        list1.deleteNode(5);
        list1.addToMiddle(1,1);
        list1.addToMiddle(2,2);
        list1.addToMiddle(7,7);
        list1.addToMiddle(9,9);
        list1.addToMiddle(10,10);

        list1.printList();

//        list1.reverseList();
//
//        list1.printList();
        list1.deleteNodeRecursively(5);

        list1.printList();

    }
}
