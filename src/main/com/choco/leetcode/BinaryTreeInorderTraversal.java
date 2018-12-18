package com.choco.leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * Q94 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode node) {
        if(node == null)
            return result;
        inorderTraversal(node.left);
        result.add(node.val);
        inorderTraversal(node.right);
        return result;
    }
}
