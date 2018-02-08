package com.developement.datastructures.linkedlist;

public class LinkedList {

    private Node head;

    public LinkedList() {
        head = new Node();
        head.setNext(null);
        head.setData(null);
    }

    public Node getHead() {
        return head;
    }

    public void addToFront(Integer data){
        //creating a new node
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(null);

        //adding created node to correct position
        if(head.getNext() == null){
            head.setNext(newNode);
        }else{
            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }
    }

    public void addToLast(Integer data){
        Node newNode = new Node();
        Node temp = head.getNext();

        newNode.setNext(null);
        newNode.setData(data);

        if(temp == null){
            head.setNext(newNode);
        }else{
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);

        }
    }

    public void addToMiddle(int position, int data){
        Node newNode = new Node();
        Node temp = head;

        newNode.setNext(null);
        newNode.setData(data);

        for(int i = 1; i < position; i++){
            temp = temp.getNext();
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }

    //TODO reimplement the code for deletion based on data of the node, not position.
    public void deleteNode(int position) {
        Node temp = head;
        for(int i = 1;i < position; i++){
            temp = temp.getNext();
        }
        if(temp.getNext().getNext() == null){
            temp.setNext(null);
        }else{
            temp.setNext(temp.getNext().getNext());
        }

    }

    //TODO instead of SOPs, use string buffer to prepare the printable representation of list.
    public void printList(){
        Node temp= head.getNext();

        if(temp == null){
            System.out.println("empty list !!!");
        }else{
            while(temp != null){
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    public void reverseIterative(){
        Node current = head.getNext();
        Node next = null;
        Node prev = null;

        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head.setNext(prev);

    }

    public void deleteNodeRecursively(int data) {
        head.setNext(deleteRecursive(head.getNext(),data));
    }


    //TODO add a wrapper method similar to reverseList

    public void printOriginalList(){

        this.printRecursiveOriginal(this.head);
    }


    private void printRecursiveOriginal(Node head){
        if(head == null){
            System.out.print("\n");
            return;
        }
        System.out.print(head.getData() + " ");
        printRecursiveOriginal(head.getNext());
    }

    //TODO add a wrapper method similar to reverseList


    public void printReverseList(){
        this.printRecursiveReverse(this.head);
    }

    private void printRecursiveReverse(Node head){
        if(head == null){
            return;
        }

        printRecursiveReverse(head.getNext());
        System.out.print(head.getData() + " ");
    }

    public void reverseList() {

        this.reverseListRecursively(this.head);
    }

    private void reverseListRecursively(Node p){
        if( p.getNext() == null){
            head.setNext(p);
            return;
        }
        reverseListRecursively(p.getNext());
        Node q = p.getNext();
        q.setNext(p);
        p.setNext(null);
    }

    /**
     * the basic concept is,  when you reach that particular node to be deleted
     * you set the head(at any given stack trace) to its next node and then return head.
     *
     * when returned setNext for the previous node in stack gets set.
     *
     * @param head current node reference at any pont in stack trace
     * @param data the value to be deleted
     * @return returns the Node
     */
    private Node deleteRecursive(Node head, int data) {

        if (head == null) {
            return head;
        }

        if (head.getData() == data) {
            head = head.getNext();
        } else {
            head.setNext(deleteRecursive(head.getNext(),data));
        }

        return head;
    }

}
