package com.choco.leetcode;

/***
 * Q53 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        Solution solution = msa.new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    class Solution {
        int[] M;
        int max;

        //M[i]存储的是以nums[i]为结尾的最大子数组和
        public int maxSubArray(int[] nums) {
            M = new int[nums.length];
            max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    M[i] = nums[i];
                } else {
                    M[i] = Math.max(M[i - 1] + nums[i], nums[i]);
                }

                max = Math.max(M[i], max);
            }
            return max;
        }
    }
}
