package com.developement.datastructures.trees;

public class TreeMain {
    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(15);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(17);
        tree.insert(20);
        tree.insert(3);
        tree.insert(1);

//        System.out.println(tree.search(20));
//        System.out.println("MaxValue :" +tree.findMax());
//        System.out.println("height :" +tree.findHeightOfTree());
//
//        tree.levelOrderTraversal();
//        tree.preOrder();
//        tree.inOrder();
//        tree.postOrder();
//        System.out.println(tree.isTreeBst());
//
//        tree.deleteNode(6);
//
//        tree.preOrder();

//        tree.deleteNode(6);
//
//        tree.preOrder();

        System.out.println( "value for inorder: " + tree.findInOrderSuccessor(7));
    }

}
