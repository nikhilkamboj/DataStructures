package com.developement.datastructures.stack;

import com.developement.datastructures.stack.StackArray;

public class MainStackArray {

    public static void main(String[] args){
        StackArray stack = new StackArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.printStack();

        stack.pop();

        int top = stack.top();



        stack.printStack();



    }
}
