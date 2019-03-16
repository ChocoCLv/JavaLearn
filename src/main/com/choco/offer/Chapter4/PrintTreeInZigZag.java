package com.choco.offer.Chapter4;

import com.choco.offer.Chapter3.BinaryTreeNode;

import java.util.Stack;

/**
 * Z字形从上往下打印二叉树，第一行从左到右
 */
public class PrintTreeInZigZag {
    public void print(BinaryTreeNode root) {
        Stack<BinaryTreeNode>[] stacks = new Stack[]{new Stack<>(), new Stack<>()};
        stacks[0].push(root);
        int current = 0;
        int next = 1;
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            BinaryTreeNode node;
            do {
                node = stacks[current].pop();
                System.out.print(node.val + " ");
                if (current == 0) {
                    //从左向右
                    if (node.left != null) {
                        stacks[next].push(node.left);
                    }
                    if (node.right != null) {
                        stacks[next].push(node.right);
                    }
                } else {
                    //
                    if (node.right != null) {
                        stacks[next].push(node.right);
                    }
                    if (node.left != null) {
                        stacks[next].push(node.left);
                    }
                }
            } while (!stacks[current].isEmpty());
            System.out.println();
            current = 1 - current;
            next = 1 - next;
        }
    }
}
