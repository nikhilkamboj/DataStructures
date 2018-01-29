package com.developement.datastructures.queues;

/*

  ******************************** basic approach ***************************
  * circular array is a good approach to handle cases where we have limited space and it can be used when there are too
  * many deQueue operations thus reaching the other end of the Queue(array it self) , therefore array starts getting empty
  * from behind and it can be used to fill.
  * we use front as  front+1 modulo length(f%length) to achieve its next position.
  *
  *
  isFull():-  to check if array is full or not. only uses front+1%length != rear; then array is available to use
  isEmpty():- to check if array is empty or not empty
        if rear = -1 and front = -1;  OR
        if rear and front are equal i.e at same location then after deQueue operation queue will become empty hence
        rear and front should be made equal to -1.
 enQueue():- in this we will keeping on increasing front and adding values to queue until array is not full.
 deQueue():- in this we will deQueue if list is not empty but if it becomes empty then show error message for the op'n.

 */
public class QueueCircularArray {

    // to checkif the quesue is full or not.
    // using private isFull to check if full or not
    private static final boolean ARRAY_FULL = true;
    private static final boolean ARRAY_NOT_FULL = false;

    int[] array = new int[4];
    int rear = -1;
    int front = -1;
    int arrayLength = array.length;

    // inserting a element into the queue, sine array is circular we use modulas for index calculation
    // complexity O(1)
    public void enQueue(int data){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        if(isEmpty()){
            rear++;
            front++;
        }else{
            front = (front+1)%array.length;
        }

        array[front] = data;
    }

    // deleting an element from the queue, using modulus to  find the index of the list.
    // using isEmpty to check if queue is empty or not.
    // complexity O(1)
    public Integer deQueue(){
        if(isEmpty()){
            System.out.println("empty queue");
            return null;
        }

        if(rear == front){
            System.out.println("deQueued element = " + array[front]);
            rear =  -1;
            front = -1;
            return null;
        }
        int temp = array[rear];
        System.out.println("deQueued element = " + temp);
        rear = (rear+1)%array.length ;
        return temp;
    }

    // printing the queue
    // using lengthOfQueue to get the length of queue and then indexing in loop for getiing he elements of the queue.
    // complexity O(n)
    public void printQueue(){
       if(isEmpty()){
           System.out.println("queue is empty");
       }else{
           int queueLength = lengthOfQueue();
           int index = rear;

           for(int i = 0  ; i < queueLength ; i++){
               System.out.print(array[index] + " ");
               index = (index+1) % arrayLength;
           }
       }
    }

    // to get the length of the queue in array
    private int lengthOfQueue(){
        int queueLength;
        queueLength = (front+arrayLength-rear)%arrayLength+1;
        return queueLength;
    }

    // to check if the queue is empty or not
    private boolean isEmpty(){
        return rear == -1 && front == -1;
    }

    // to check if queue is full or not.
    private boolean isFull(){
        if((front+1)%array.length == rear){
            return ARRAY_FULL;
        }else{
            return ARRAY_NOT_FULL;
        }
    }

}
