package com.choco.offer.Chapter4;

import com.choco.offer.Chapter3.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 */
public class PrintTreeFromTopToBottomInLines {
    void print(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        int toBePrinted = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
