package com.choco.leetcode;

import org.junit.Test;

import java.util.List;

public class BinaryTreeInorderTraversalTest {

    @Test
    public void inrderTraversal() {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;
        List<Integer> result = btit.inorderTraversal(node1);
        for(int n:result){
            System.out.println(n);
        }
    }
}