package com.choco.offer.Chapter3;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode addLeft(BinaryTreeNode left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode addRight(BinaryTreeNode right) {
        this.right = right;
        return this;
    }

    public BinaryTreeNode(int v) {
        this.val = v;
    }

    public BinaryTreeNode addLeft(int val) {
        addLeft(new BinaryTreeNode(val));
        return this;
    }

    public BinaryTreeNode addRight(int val) {
        addRight(new BinaryTreeNode(val));
        return this;
    }

}
