package com.choco.leetcode;

import org.junit.Test;

import java.util.List;

public class BinaryTreeInorderTraversalTest {

    @Test
    public void inorderTraversal() {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        BinaryTreeInorderTraversal.TreeNode node1 = btit.new TreeNode(1);
        BinaryTreeInorderTraversal.TreeNode node2 = btit.new TreeNode(2);
        BinaryTreeInorderTraversal.TreeNode node3 = btit.new TreeNode(3);

        node1.right = node2;
        node2.left = node3;
        List<Integer> result = btit.inorderTraversal(node1);
        for(int n:result){
            System.out.println(n);
        }
    }
}