package com.choco.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesIITest {

    @Test
    public void generateTrees() {
        List<TreeNode> res = new UniqueBinarySearchTreesII().generateTrees(3);
        for(TreeNode root:res){
            preOrderTraval(root);
            System.out.println();
        }
    }

    private void preOrderTraval(TreeNode root){
        if(root==null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.val+" ");
        preOrderTraval(root.left);
        preOrderTraval(root.right);
    }
}