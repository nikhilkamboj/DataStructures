package com.developement.datastructures.queues;

/*
 here we are using array to perform implementation of the queue datastructure
 ------------basic structure-------------
    [rear][][][][][][front][][][]
 we are inserting element at the end of the array i.e. front as show above, rear remains static until a dequeue
 i.e. a deletion operation is performed on the queue.

 as per the basic definition of queue ds It follows FIFO(first- in- first- out) approach hence element at rear
 is the one which would be removed for every dequeue operation.
so for dequeue rear = rear+1; and front = front+1;
***** Border Cases *****
until array is full
queue is empty
rear has reached the front or even overtaken its value.(rear > front)
*************************
 */

public class QueueArray {

    int[] array = new int[10];
    int rear = -1;
    int front = -1;

    // insert data into the queue
    // O(1) complexity
    public void enQueue(int data){

        if(front > array.length-1){
            System.out.println("queue is full");
            return;
        }
        if(rear == -1 && front == -1){
            front++;
            rear++;
        }else{
            front++;
        }
        array[front] = data;
    }

    // delete data from the queue
    // O(1) complexity
    public void deQueue(){

        boolean empty = isEmpty();
        if(empty){
            System.out.println("queue is empty");
            return;
        }
        if(rear == array.length-1){
            front = -1;
            rear = -1;
        }else{
            rear++;
        }
    }

    // print data from the queue
    // O(n) complexity
    public void printQueue(){
        if(!isEmpty()){
            int i = rear;
            while(i <= front){
                System.out.print(array[i]);
                i++;
            }
            System.out.println(" ");
        }else{
            System.out.println("queue is empty");
            return;
        }
    }

    // checks if queue is empty or not
    // removes redundancy of code present in above methods
    private boolean isEmpty(){

        if(rear == -1){
            return true;
        }else if(rear > front){
            return true;
        }else{
            return false;
        }
    }
}
