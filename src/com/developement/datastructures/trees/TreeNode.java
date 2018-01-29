package com.developement.datastructures.trees;

public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;


    public TreeNode(Integer data) {
        this.data = data;
        this.left = null ;
        this.right = null;
    }

    public Integer getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
