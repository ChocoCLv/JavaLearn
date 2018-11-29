package com.choco.leetcode;


/***
 * 747. 至少是其他数字两倍的最大数
 * 注意特例[1,0]
 */
public class DominantIndex {
    public static void main(String[] args) {
        DominantIndex di = new DominantIndex();
        Solution solution = di.new Solution();
        System.out.println(solution.dominantIndex(new int[]{1, 0}));
    }

    class Solution {
        public int dominantIndex(int[] nums) {
            if (nums.length == 1)
                return 0;
            int largetestIndex = 0;
            int secLargestIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[largetestIndex] < nums[i]) {
                    secLargestIndex = largetestIndex;
                    largetestIndex = i;
                } else if (nums[secLargestIndex] < nums[i] || secLargestIndex == largetestIndex) {
                    secLargestIndex = i;
                }
            }
            if (nums[largetestIndex] >= 2 * nums[secLargestIndex])
                return largetestIndex;
            else
                return -1;
        }
    }
}

