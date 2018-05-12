package com.choco.leetcode;

public class PivotIndex {
    class Solution {
        public int pivotIndex(int[] nums) {
            if(nums.length < 3)
                return -1;
            int[] S = new int[nums.length + 1];
            S[0] = 0;
            int left;
            int right;
            for(int i = 1;i <= nums.length;i++){
                S[i] = S[i-1] + nums[i-1];
            }
            for(int i = 0;i<nums.length;i++){
                left = S[i];
                right = S[S.length-1] - S[i+1];
                if(left == right)
                    return i;
            }
            return -1;
        }
    }

    public static void main(String[] args){
        PivotIndex pi = new PivotIndex();
        Solution solution = pi.new Solution();
        System.out.println(solution.pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
    }
}
