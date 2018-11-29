package com.choco.leetcode;

import java.util.Arrays;

/***
 * Q31 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        Solution solution = np.new Solution();
        int nums[] = new int[]{3, 5, 5, 1};
        solution.nextPermutation(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    class Solution {
        /***
         * [a,b,c,d,e]
         * 找到最后的极大值点（包括端点），比如2,5,4,2,3，为3
         * 在极大值右侧（包括极大值）找到与左侧差值最小的点，交换该点与左侧的点，并将剩余的数升序排列
         */

        public void nextPermutation(int[] nums) {
            int length = nums.length;
            if (length < 2)
                return;
            //最后一个极大值在末尾
            if (nums[length - 1] > nums[length - 2]) {
                int tmp = nums[length - 1];
                nums[length - 1] = nums[length - 2];
                nums[length - 2] = tmp;
                return;
            }
            int maximal = 0;
            for (int i = 1; i < (nums.length - 1); i++) {
                if (nums[i] > nums[i - 1] && nums[i] >= nums[i + 1]) {
                    maximal = i;
                }
            }
            //最后一个极大值在起点
            if (maximal == 0) {
                Arrays.sort(nums);
                return;
            }

            //一般情况
            int left = nums[maximal - 1];
            int rightIndex = maximal;
            for (int i = maximal; i < length; i++) {
                if (nums[i] > left && nums[i] < nums[rightIndex])
                    rightIndex = i;
            }
            nums[maximal - 1] = nums[rightIndex];
            nums[rightIndex] = left;
            Arrays.sort(nums, maximal, length);
        }
    }
}
