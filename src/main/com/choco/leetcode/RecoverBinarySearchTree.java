package com.choco.leetcode;

/***
 * Q99 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 */

public class RecoverBinarySearchTree {
    TreeNode lastNode;//上一个遍历的节点
    TreeNode firstNode;//第一个逆序的
    TreeNode secondNode;

    public void recoverTree(TreeNode root) {
        inOrderTravel(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void inOrderTravel(TreeNode root) {
        if (root == null)
            return;
        inOrderTravel(root.left);

        //当前节点为中序遍历的第一个节点
        if (lastNode == null) {
            lastNode = root;
        } else {
            if (lastNode.val > root.val) {
                if (firstNode == null) {
                    firstNode = lastNode;
                }
                if (firstNode != null) {
                    secondNode = root;
                }
            }
            lastNode = root;
        }

        inOrderTravel(root.right);
    }
}
