package com.choco.offer.Chapter2;

import java.util.Arrays;
import java.util.List;

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}

public class ConstructBinaryTree {

    public static void inOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderTraverse(root.left);
        System.out.print(root.value + " ");
        inOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        List<Integer> preOrder = Arrays.asList(1, 2, 4, 7, 3, 5, 6, 8);
        List<Integer> inOrder = Arrays.asList(4, 7, 2, 1, 5, 3, 8, 6);
        BinaryTreeNode root = new ConstructBinaryTree().construct(preOrder, inOrder);
        inOrderTraverse(root);
    }

    /**
     * 根据前序遍历序列和中序遍历序列构造二叉树,二叉树不包含重复数字
     *
     * @param preOrder 前序遍历序列
     * @param inOrder  中序遍历序列
     * @return 二叉树的根节点
     */
    public BinaryTreeNode construct(List<Integer> preOrder, List<Integer> inOrder) {
        if (preOrder.size() != inOrder.size() || preOrder.size() == 0)
            return null;

        return constructTree(preOrder, inOrder);
    }

    private BinaryTreeNode constructTree(List<Integer> preOrder, List<Integer> inOrder) {
        int rootVal = preOrder.get(0);
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = rootVal;

        if(preOrder.size()==1)
            return root;

        int rootIndexInOrder = 0;

        for(int i:inOrder){
            if(i==rootVal)
                break;
            rootIndexInOrder++;
        }

        if(rootIndexInOrder > 0){
            root.left = constructTree(preOrder.subList(1,rootIndexInOrder+1), inOrder.subList(0,rootIndexInOrder));
        }

        if(rootIndexInOrder<preOrder.size()-1){
            root.right = constructTree(preOrder.subList(rootIndexInOrder+1,preOrder.size()), inOrder.subList(rootIndexInOrder+1,preOrder.size()));
        }

        return root;
    }
}
