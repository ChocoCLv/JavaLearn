package com.choco.leetcode;

import java.util.Arrays;
import java.util.Collections;

/***
 * 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 */

public class ArrayPairSum {
    public static void main(String[] args){
        ArrayPairSum aps = new ArrayPairSum();
        Solution solution = aps.new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1,2,3,4}));
    }
    class Solution {
        public int arrayPairSum(int[] nums) {
            int sum = 0;
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i+=2){
                sum+=nums[i];
            }
            return sum;
        }
    }
}
