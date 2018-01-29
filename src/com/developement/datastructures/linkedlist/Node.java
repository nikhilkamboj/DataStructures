package com.developement.datastructures.linkedlist;

public class Node {

    private Integer data;
    private Node next;

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

}
