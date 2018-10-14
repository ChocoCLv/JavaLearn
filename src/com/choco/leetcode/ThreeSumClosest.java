package com.choco.leetcode;

import java.util.Arrays;

/**
 * Created by choco on 2018/10/14.
 * Q16 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            int sum;
            for (int k = 0; k < nums.length; k++) {
                int i = k + 1;
                int j = nums.length - 1;
                if (k >= 1 && nums[k] == nums[k - 1]) continue;
                while (i < j) {
                    sum = nums[k] + nums[i] + nums[j];
                    if(nums[j] == nums[j - 1]){
                        while ((i < j) && (nums[j] == nums[j - 1])) j--;
                        j++;
                    }
                    if(nums[i] == nums[i + 1]){
                        while ((i < j) && (nums[i] == nums[i + 1])) i++;
                        i--;
                    }
                    if (sum == target) {
                        return target;
                    } else if (sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                    result = Math.abs(sum - target) > Math.abs(result - target) ? result : sum;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        Solution solution = tsc.new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
    }
}
