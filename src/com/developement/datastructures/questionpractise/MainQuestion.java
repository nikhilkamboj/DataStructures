package com.developement.datastructures.questionpractise;


import com.developement.datastructures.linkedlist.LinkedList;

public class MainQuestion {
    public static void main(String[] args){
        String name = "nikhil is cool";

        StackQuestions operation = new StackQuestions();

        System.out.println(operation.reverseStringWordsUnchanged(name));

        LinkedList list = new LinkedList();

        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
        list.addToFront(4);

        list.printList();

        list.getHead().setNext(operation.reverseLinkedList(list.getHead()));

        list.printList();

        String parathesis = "{{{}}}[[]]]]";

        System.out.println(operation.isParenthesisBalanced(parathesis));

        String post = "400 5 * 6 +";

        System.out.println(operation.evaluatePostfixString(post));

    }
}
