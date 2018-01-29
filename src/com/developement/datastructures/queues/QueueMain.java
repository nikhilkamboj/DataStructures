package com.developement.datastructures.queues;

public class QueueMain  {
    public static void main(String[] args){
        QueueLinkedList queue = new QueueLinkedList();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        queue.printQueue();

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        queue.printQueue();

        queue.deQueue();




    }
}
