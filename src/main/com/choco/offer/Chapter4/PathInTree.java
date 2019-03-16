package com.choco.offer.Chapter4;

import com.choco.offer.Chapter3.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 应该使用List存储path，而不是int[],因为不知道二叉树的高度
 * 应该在叶子结点时就结束，而不是根据当前节点是否为null来判断是否结束，这样会造成路径重复，因为每个叶子结点都有两个null子节点
 */
public class PathInTree {
    private List<List<Integer>> results = new ArrayList<>();

    List<List<Integer>> findPath(BinaryTreeNode root, int target) {
        if (root == null)
            return results;

        findPathCore(root, target, new int[10], 0, 0);
        return results;
    }

    private void findPathCore(BinaryTreeNode root, int target, int[] path, int currentLevel, int currentSum) {
        //已走完一条路径
        if (root == null) {
            if (currentSum == target) {
                List<Integer> result = new ArrayList<>();
                for (int i : path)
                    result.add(i);
                results.add(result);
            }
            return;
        }

        path[currentLevel] = root.val;

        findPathCore(root.left, target, path, currentLevel + 1, currentSum + root.val);
        findPathCore(root.right, target, path, currentLevel + 1, currentSum + root.val);
    }
}
