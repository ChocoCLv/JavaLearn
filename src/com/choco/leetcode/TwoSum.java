package com.choco.leetcode;


public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSum ts = new TwoSum();
        TwoSum.Solution solution = ts.new Solution();
        solution.twoSum(nums, target);
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if ((nums[i] + nums[j]) == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }
    }
}
