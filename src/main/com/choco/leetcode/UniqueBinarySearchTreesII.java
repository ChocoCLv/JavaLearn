package com.choco.leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * Q95 不同的二叉搜索树II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 2][n + 2];

        return generateSubTrees(1, n, dp);
    }

    private List<TreeNode> generateSubTrees(int start, int end, List<TreeNode>[][] dp) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; i++) {
            //以i为根节点，生成子树，左子树范围为[start, i-1]，右子树范围为[i+1,end]
            List<TreeNode> leftSubTree = dp[start][i-1];
            if (leftSubTree == null) {
                leftSubTree = generateSubTrees(start, i - 1, dp);
                dp[start][i - 1] = leftSubTree;
            }
            List<TreeNode> rightSubTree = dp[i + 1][end];
            if (rightSubTree == null) {
                rightSubTree = generateSubTrees(i + 1, end, dp);
                dp[i + 1][end] = rightSubTree;
            }
            for (TreeNode leftChild : leftSubTree) {
                for (TreeNode rightChild : rightSubTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }
}
