package com.choco.offer.Chapter4;

import com.choco.offer.Chapter3.BinaryTreeNode;
import org.junit.Test;

public class PrintTreeInZigZagTest {

    @Test
    public void print() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.addLeft(2).addRight(3);
        root.left.addLeft(4).addRight(5);
        root.right.addLeft(6).addRight(7);
        new PrintTreeInZigZag().print(root);
    }
}