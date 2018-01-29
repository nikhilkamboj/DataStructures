package com.developement.datastructures.doublylinkedlist;

public class DoublyLinkedList {
    NodeDoubly head;

    private NodeDoubly createDoublyNode(Integer data){
        NodeDoubly newNode = new NodeDoubly();

        newNode.setData(data);
        newNode.setPrev(null);
        newNode.setNext(null);

        return newNode;
    }



    public DoublyLinkedList() {
        head = null;
    }



    public void insertAtFront(Integer data){
        NodeDoubly newNode = createDoublyNode(data);

        if(head == null){
            head = newNode;
        }else{
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }


    }



    public void insertAtTail(Integer data){
        NodeDoubly newNode = createDoublyNode(data);

        if(head == null){
            head = newNode;
        }else{
            NodeDoubly temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }

            temp.setNext(newNode);
            newNode.setPrev(temp);
        }

    }



    public void deleteAtPosition(int position){
        NodeDoubly temp = head;
        NodeDoubly prevTemp = null;

        if(position == 1){
            head = temp.getNext();
        }else{
            for(int i = 1; i < position-1; i++){
                temp = temp.getNext();
            }

            temp.setNext(temp.getNext().getNext());
            prevTemp = temp.getNext();
            if(prevTemp != null) {
                prevTemp.setPrev(temp);
            }
        }

    }


    public void addInMiddel(int position, int data){
        NodeDoubly newNode = createDoublyNode(data);
        NodeDoubly temp = head;
        NodeDoubly prevTemp = null;

        for(int i = 1; i < position-1; i++){
            temp = temp.getNext();
        }

        newNode.setPrev(temp);
        newNode.setNext(temp.getNext());

        temp.setNext(newNode);
        prevTemp = newNode.getNext();
        prevTemp.setPrev(newNode);

    }



    public void printList(){
        NodeDoubly temp = head;

        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }

        System.out.println(" ");
    }


    public static class NodeDoubly {
        private Integer data;
        private NodeDoubly prev;
        private NodeDoubly next;

        public Integer getData() {
            return data;
        }

        public NodeDoubly getPrev() {
            return prev;
        }

        public NodeDoubly getNext() {
            return next;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public void setPrev(NodeDoubly prev) {
            this.prev = prev;
        }

        public void setNext(NodeDoubly next) {
            this.next = next;
        }
    }
}
