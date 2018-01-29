package com.developement.datastructures.queues;

import com.developement.datastructures.linkedlist.LinkedList;
import com.developement.datastructures.linkedlist.Node;

public class QueueLinkedList {

    LinkedList list = new LinkedList();

    // just a reference pointing to the head of the list.
    // in our implementation we have Node as head not just a reference.
    Node head = list.getHead();


    // O(n)
    public void enQueue(int data){
        list.addToLast(data);
    }

    // O(1)
    public void deQueue(){
        if(head.getNext() == null){
            System.out.println("empty Queue");
        }else if(head.getNext().getNext() == null){
            head.setNext(null);
        }else{
            head.setNext(head.getNext().getNext());
        }
    }

    public void printQueue(){
        list.printList();
    }


}
