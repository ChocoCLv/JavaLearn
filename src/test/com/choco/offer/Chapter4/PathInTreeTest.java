package com.choco.offer.Chapter4;

import com.choco.offer.Chapter3.BinaryTreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PathInTreeTest {

    @Test
    public void findPath() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.addLeft(5).addRight(12);
        root.left.addLeft(4).addRight(7);
        List<List<Integer>> results = new PathInTree().findPath(root, 22);
        results.forEach(result -> {
            System.out.println(Arrays.deepToString(result.toArray()));
        });
    }
}