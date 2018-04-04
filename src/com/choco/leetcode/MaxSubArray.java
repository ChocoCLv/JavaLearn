package com.choco.leetcode;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        Solution solution = msa.new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    class Solution {
        int[] M;
        int max;

        public int maxSubArray(int[] nums) {
            M = new int[nums.length];
            for(int i = 0;i<nums.length;i++){
                if(i==0){
                    M[i] = nums[i];
                }else{
                    M[i] = Math.max(M[i-1]+nums[i],nums[i]);
                }

                max = Math.max(M[i],max);
            }
            return max;
        }
    }
}
