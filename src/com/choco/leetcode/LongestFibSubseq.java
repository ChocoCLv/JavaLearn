package com.choco.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Q 873
 */

public class LongestFibSubseq {
    class Solution {
        HashMap<Integer, Integer> M;
        HashMap<Integer, Integer> index;

        // 斐波那契数列中任意两个连续的数可以唯一确定一个序列
        public int lenLongestFibSubseq(int[] A) {
            M = new HashMap<>();
            index = new HashMap<>();

            for (int i = 0; i < A.length; i++) {
                index.put(A[i], i);
            }
            int num1, num2;
            int res = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    num1 = A[i];
                    num2 = A[j];
                    int k = index.getOrDefault(num2 - num1, -1);
                    if (k >= 0 && k < i) {
                        int len = M.getOrDefault(k * A.length + i, 2) + 1;
                        M.put(i * A.length + j, len);
                        res = res < len ? len : res;
                    }
                }
            }

            return res < 3 ? 0 : res;
        }
    }

    public static void main(String[] args) {
        LongestFibSubseq lfs = new LongestFibSubseq();
        Solution solution = lfs.new Solution();
        System.out.println(solution.lenLongestFibSubseq(new int[] { 1, 3, 7, 12, 14, 18 }));
    }
}