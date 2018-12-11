package com.choco.leetcode;

/**
 * Q221 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 */
public class MaximalSquare {
    int M[][];//存储以matrix[i][j]为右下角的正方形的最大边长

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int result = 0;
        M = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0) && matrix[i][j] == '1') {
                    M[i][j] = 1;
                    result = Math.max(1, result);
                    continue;
                }
                if (matrix[i][j] == '1') {
                    //尝试结合到当前点左上角的所属的正方形中
                    int length = M[i - 1][j - 1];
                    //更新M[i][j]
                    M[i][j] = Math.min(M[i - 1][j], M[i][j - 1]);
                    M[i][j] = Math.min(M[i][j], length) + 1;
                    result = Math.max(result, M[i][j]);
                }
            }
        }
        return result * result;
    }
}
