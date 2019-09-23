package com.choco.offer.Chapter6;

import com.choco.offer.Chapter3.BinaryTreeNode;

public class TreeDepth {

    public int depth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        return left > right ? left + 1 : right + 1;
    }
}
