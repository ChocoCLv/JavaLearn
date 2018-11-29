package com.choco.leetcode;

import com.choco.Util.Print;

/***
 * 27. 移除元素
 * 题目不要求顺序一致，本实现保证了顺序不变
 */

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        Solution solution = re.new Solution();
        int[] nums = { 2, 2};
        System.out.println(solution.removeElement(nums, 3));
        Print.PrintIntArray(nums);
    }

    class Solution {
        public int removeElement(int[] nums, int val) {
            int i, j;
            for (i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    j = i;
                    while (++j < nums.length && nums[j] == val) ;
                    if (j < nums.length) {
                        nums[i] = nums[j];
                        nums[j] = val;
                    } else {
                        break;
                    }
                }
            }
            return i;
        }
    }
}
