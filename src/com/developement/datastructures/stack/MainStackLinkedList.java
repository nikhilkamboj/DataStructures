package com.developement.datastructures.stack;

import com.developement.datastructures.stack.StackLinkedList;

public class MainStackLinkedList {

    public static void main(String[] args){

        StackLinkedList stack = new StackLinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printStack();

        stack.pop();

        stack.printStack();

        stack.top();
    }
}
