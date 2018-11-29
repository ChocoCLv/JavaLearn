package com.choco.leetcode;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};
        MinPathSum mps = new MinPathSum();
        Solution solution = mps.new Solution();
        System.out.println(solution.minPathSum(grid));
    }

    class Solution {
        int[][] M;
        int[][] g;

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            M = new int[m][n];
            g = grid;
            int ret = OPT(m - 1, n - 1);
            return ret;
        }

        private int OPT(int m, int n) {
            if (m < 0 || n < 0) {
                return 0;
            }
            if (M[m][n] != 0) {
                return M[m][n];
            }

            if (m == 0) {
                M[m][n] = OPT(m, n - 1) + g[m][n];
                return M[m][n];
            }

            if (n == 0) {
                M[m][n] = OPT(m - 1, n) + g[m][n];
                return M[m][n];
            }
            M[m][n] = Math.min(OPT(m, n - 1), OPT(m - 1, n)) + g[m][n];
            return M[m][n];
        }
    }
}
