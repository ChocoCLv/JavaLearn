package com.choco.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecoverBinarySearchTreeTest {
    @Test
    public void testRecoverTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node3.right = node4;
        node4.left = node2;
        assertFalse(new ValidateBinarySearchTree().new Solution().isValidBST(node3));
        new RecoverBinarySearchTree().recoverTree(node3);
        assertTrue(new ValidateBinarySearchTree().new Solution().isValidBST(node3));
    }
}