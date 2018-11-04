package com.choco.leetcode;

/***
 * Q561 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 * 示例 1:
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 *
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 */

public class ArrayPairSum {
    public static void main(String[] args) {
        ArrayPairSum aps = new ArrayPairSum();
        Solution solution = aps.new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1, 2, 3, 4}));
    }

    class Solution {
        public int arrayPairSum(int[] nums) {
            int[] index = new int[20001];
            for (int i = 0; i < nums.length; i++) {
                //指定了数据量的大小 就可以使用桶排序
                index[nums[i] + 10000]++;
            }

            int res = 0;
            boolean odd = true;
            for (int i = 0; i < index.length; i++) {
                while (index[i] > 0) {
                    if (odd) {
                        //将索引i恢复到原始数据
                        res += i - 10000;
                    }
                    //将相邻的数分成一对
                    odd = !odd;
                    index[i]--;
                }
            }
            return res;
        }
    }
}
