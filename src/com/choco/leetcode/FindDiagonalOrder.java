package com.choco.leetcode;

import com.choco.Util.Print;

/***
 * 498. 对角线遍历
 */

public class FindDiagonalOrder {
    public static void main(String[] args) {
        FindDiagonalOrder fdo = new FindDiagonalOrder();
        Solution solution = fdo.new Solution();
        Print.PrintIntArray(solution.findDiagonalOrder(new int[][]{}));
    }

    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if(matrix.length==0)
                return new int[0];
            int row = matrix.length;
            int column = matrix[0].length;
            int N = row * column;
            int[] n = new int[N];
            int i = 0;
            int j = 0;
            int direction = 1;//1 for up, -1 for down
            for (int p = 0; p < N; p++) {
                n[p] = matrix[i][j];
                if (direction == 1) {
                    j++;
                    i--;
                    if (j >= column) {
                        j--;
                        i += 2;
                        direction = -1;
                    } else if (i < 0) {
                        i++;
                        direction = -1;
                    }
                } else {
                    j--;
                    i++;
                    if (i >= row) {
                        i--;
                        j += 2;
                        direction = 1;
                    } else if (j < 0) {
                        j++;
                        direction = 1;
                    }
                }
            }
            return n;
        }
    }
}
