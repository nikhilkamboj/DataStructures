package com.developement.datastructures.trees;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    TreeNode treeRoot;


    public Tree() {

    }

    public void insert(Integer data){

        treeRoot = insertToTree(treeRoot,data);
    }

    public boolean search(Integer data){
        return searchInTree(treeRoot,data);
    }

    public Integer findMin(){
        return findMinInTree(treeRoot);
    }

    public Integer findMax(){
        return findMaxInTree(treeRoot);
    }

    public Integer findHeightOfTree(){
        return findTreeHeight(treeRoot);
    }

    public void levelOrderTraversal(){
        if(treeRoot == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeRoot);

        while(!queue.isEmpty()){
            TreeNode queueHead = queue.remove();
            System.out.print(queueHead.getData() + " ");

            if(queueHead.getLeft() != null){
                queue.add(queueHead.getLeft());
            }
            if(queueHead.getRight() != null){
                queue.add(queueHead.getRight());
            }

        }
        System.out.println("");


    }

    public void preOrder(){
        preOrderTraversal(treeRoot);
        System.out.println(" ");
    }

    public void inOrder(){
        inOrderTraversal(treeRoot);
        System.out.println(" ");
    }

    public void postOrder(){
        postOrderTraversal(treeRoot);
        System.out.println(" ");
    }

    public boolean isTreeBst(){
        return isBst(treeRoot);
    }

    public void deleteNode(int valueToDelete) {
        deleteNodeFromTree(treeRoot,valueToDelete);
    }

    public Integer findInOrderSuccessor(int value){
        return inOrderSuccessor(treeRoot, value);
    }

    public Integer findInOrderPredecessor(int value){
        return inOrderPredecessor(treeRoot, value);
    }


    private TreeNode insertToTree(TreeNode root, Integer key){
        if(root == null){
            TreeNode newNode = new TreeNode(key);
            return newNode;
        }

        if(key <= root.getData()){
//        address value is being passed
            root.setLeft(insertToTree(root.getLeft(),key));
        }else if(key > root.getData()){
            root.setRight(insertToTree(root.getRight(),key));
        }

        return root;
    }

    private boolean searchInTree(TreeNode root, Integer key){
        if(root == null){
            return false;
        }

        if(key == root.getData()){
            return true;
        }

        if(key < root.getData()){

            if(root.getLeft() == null){
                return false;
            }else{
                return searchInTree(root.getLeft(),key);
            }

        }else{

            if(root.getRight() == null){
                return false;
            }else{
                return searchInTree(root.getRight(),key);
            }
        }

    }

    private Integer findMinInTree(TreeNode root){
        if(root == null){
            return -1;
        }
        if(root.getLeft() == null){
            return root.getData();
        }else {
            return findMinInTree(root.getLeft());
        }
    }

    private Integer findMaxInTree(TreeNode root){
        if(root == null){
            return -1;
        }

        if(root.getRight() == null){
            return root.getData();
        }else {
            return findMaxInTree(root.getRight());
        }

    }

    private Integer findTreeHeight(TreeNode root){
        if(root == null){
            return -1;
        }
        int leftTreeHeight = findTreeHeight(root.getLeft());
        int rightTreeHeight = findTreeHeight(root.getRight());

        return Math.max(leftTreeHeight,rightTreeHeight) +1 ;
    }

    private void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    private void inOrderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRight());
    }

    private void postOrderTraversal(TreeNode root){
        if (root == null) {
            return;
        }

        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getData() + " ");
    }

    private boolean isBst(TreeNode root) {
        if(root == null){
            return true;
        }
        if (isLesser(root.getLeft(), root.getData()) && isGreater(root.getRight(),root.getData())
                 && isBst(root.getLeft()) && isBst(root.getRight())){
            return true;
        } else {
            return false;
        }
    }

    private boolean isLesser(TreeNode root, int value){
        if (root == null){
            return true;
        }
        if(root.getData() <= value && isLesser(root.getLeft(),value) && isLesser(root.getRight(),value)) {
            return true;
        }else{
            return false;
        }
    }

    private boolean isGreater(TreeNode root, int value){
        if (root == null){
            return true;
        }
        if (root.getData() > value && isGreater(root.getLeft(), value) && isGreater(root.getRight(), value)) {
            return true;
        }else {
            return false;
        }
    }

    private boolean isTreeBstOptimalSolution(TreeNode root, int minValue, int maxValue){
        if (root == null) {
            return true;
        }
        if(root.getData() >= minValue && root.getData() < maxValue &&
                isTreeBstOptimalSolution(root.getLeft(), minValue, root.getData()) &&
                isTreeBstOptimalSolution(root.getRight(), root.getData(), maxValue)) {
            return true;
        }else {
            return false;
        }

    }

    private TreeNode deleteNodeFromTree(TreeNode root, int valueToBeDeleted){

        if (root == null){
            return root;
        } else if (root.getData() > valueToBeDeleted) {
            root.setLeft(deleteNodeFromTree(root.getLeft(), valueToBeDeleted));
            return root;
        }else if (root.getData() < valueToBeDeleted){
            root.setRight(deleteNodeFromTree(root.getRight(), valueToBeDeleted));
            return root;
        } else {
            if (root.getLeft() == null && root.getRight() == null){
                root = null;
            } else if (root.getLeft() == null){
                root = root.getLeft();
            } else if (root.getRight() == null) {
                root = root.getRight();
            } else {
                TreeNode minNode = findMinInTreeForDelete(root.getRight());
                int minValueOfSubtree = minNode.getData();
                root.setData(minValueOfSubtree);
                root.setRight(deleteNodeFromTree(root.getRight(),minValueOfSubtree));
            }
            return root;
        }
    }

    private TreeNode findMinInTreeForDelete(TreeNode root){
        if (root.getLeft() == null){
            return root;
        }
        return findMinInTreeForDelete(root.getLeft());
    }

    private Integer inOrderSuccessor(TreeNode root, int value){
        if (root == null){
            return null;
        }
        while (root.getData() != value){
            if (root.getData() >= value){
                root = root.getLeft();
            }else {
                root = root.getRight();
            }
        }

        if (root.getRight() != null){
            TreeNode successor = findMinInTreeForDelete(root.getRight());
            return successor.getData();
        }else {
            TreeNode ancestor = treeRoot;
            TreeNode current = root;
            Integer successor = null;

            while (ancestor != current){
                if (ancestor.getData() >= value){
                    successor = ancestor.getData();
                    ancestor = ancestor.getLeft();
                } else {
                    ancestor = ancestor.getRight();
                }
            }
            return successor;

        }

    }

    private Integer inOrderPredecessor(TreeNode root, int value){
        if (root == null){
            return null;
        }
        while (root.getData() != value){
            if (root.getData() >= value){
                root = root.getLeft();
            }else {
                root = root.getRight();
            }
        }

        if (root.getLeft() != null){
            TreeNode predecessor = root.getLeft();
            return predecessor.getData();
        }else {
            TreeNode ancestor = treeRoot;
            TreeNode current = root;
            Integer predecessor = null;

            while (ancestor != current){
                if (ancestor.getData() < value){
                    predecessor = ancestor.getData();
                    ancestor = ancestor.getRight();
                } else {
                    ancestor = ancestor.getLeft();
                }
            }
            return predecessor;

        }

    }
}
