package com.choco.leetcode;

import com.choco.Util.Print;

/***
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 等效于将数组的后K个元素移动到数组前面
 */
public class Rotate {
    public static void main(String[] args) {
        Rotate r = new Rotate();
        Solution solution = r.new Solution();
        int[] nums = {1};
        solution.rotate(nums, 2);
        Print.PrintIntArray(nums);
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int N = nums.length;
            k %= N;
            reverse(nums, 0, N - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, N - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            int tmp;
            while (start < end) {
                tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
