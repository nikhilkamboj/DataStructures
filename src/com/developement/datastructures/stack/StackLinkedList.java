package com.developement.datastructures.stack;

import com.developement.datastructures.linkedlist.LinkedList;

public class StackLinkedList {

    LinkedList list;

    public StackLinkedList() {

        list = new LinkedList();
    }

    public void push(Integer data){

        list.addToFront(data);
    }

    public void pop(){
        if(list.getHead().getNext() == null){
            System.out.println("empty stack");
            return;
        }
        list.getHead().setNext(list.getHead().getNext().getNext());
        System.out.println("\n");
    }

    public Integer top(){
        if(list.getHead().getNext() == null){
            System.out.println("empty stack");
            return null;
        }
        System.out.println("top = " + list.getHead().getNext().getData() + "\n");
        return list.getHead().getNext().getData();
    }

    public boolean isEmpty(){
        if(list.getHead().getNext() == null){
            return true;
        }
        return true;
    }

    public void printStack(){
        list.printList();
    }
}
