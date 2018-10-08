package com.choco.leetcode;

/***
 * 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
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
            for(int i =0;i<nums.length;i++){
                index[ nums[i]+10000 ]++;
            }

            int res = 0;
            boolean odd = true;
            for(int i =0;i<index.length;i++){
                while(index[i]>0){
                    if(odd){
                        res +=i-10000;
                    }
                    odd = !odd;
                    index[i]--;
                }
            }
            return res;
        }
    }
}
