package com.choco.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * Q15 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new LinkedList<>();
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0)
                    break;
                int sum = 0 - nums[k];
                int i = k + 1;
                int j = nums.length - 1;
                if (k >= 1 && nums[k] == nums[k - 1]) continue;
                while (i < j) {
                    if ((nums[i] + nums[j]) == sum) {
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(nums[k]);
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        result.add(tmp);
                        while ((i < j) && (nums[i] == nums[i + 1])) i++;
                        while ((i < j) && (nums[j] == nums[j - 1])) j--;
                        i++;
                        j--;
                    } else if ((nums[i] + nums[j]) > sum) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        Solution solution = ts.new Solution();
        System.out.println(solution.threeSum(new int[]{0,0,0,0,0,0,0}));
    }
}
