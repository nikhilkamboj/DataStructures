package com.developement.datastructures.stack;

public class StackArray {

    // stack array
    private Integer[] array;

    // points to top of the stack
    private int top = -1;

    public StackArray() {

        array =  new Integer[101];
    }

    public void push(Integer data){
        if(top == array.length-1){
            System.out.println("stack out of bound");
            return;
        }
        top++;
        array[top] = data;
    }

    public void pop(){
        if(top == -1){
            System.out.println("empty stack");
            return;
        }
        top--;
    }

    public Integer top(){
        if(top == -1){
            System.out.println("empty stack");
            return null;
        }
        System.out.println("top = " + top);
        return array[top];
    }

    public void printStack(){
        if(top == -1){
            System.out.println("empty stack");
            return;
        }

        for(int i = 0; i<= top; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

}
