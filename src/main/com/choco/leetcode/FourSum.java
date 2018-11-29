package com.choco.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * Q18 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

public class FourSum {
    class Solution {
        List<List<Integer>> result;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            result = new LinkedList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for (int a = 0; a < n - 3; a++) {
                // 跳过重复的
                if (a >= 1 && nums[a] == nums[a - 1])
                    continue;
                //nums[a]太大
                if ((nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3]) > target)
                    continue;
                //nums[a]太小
                if ((nums[a] + nums[n - 1] + nums[n - 2] + nums[n - 3]) < target)
                    continue;

                for (int b = a + 1; b < n - 2; b++) {
                    //跳过重复的
                    if (b >= (a + 2) && nums[b] == nums[b - 1])
                        continue;
                    //nums[b]太大
                    if ((nums[a] + nums[b] + nums[b + 1] + nums[b + 2]) > target)
                        continue;
                    //nums[b]太小
                    if ((nums[a] + nums[n - 1] + nums[n - 2] + nums[b]) < target)
                        continue;

                    int i = b + 1;
                    int j = n - 1;
                    while (i < j) {
                        int sum = nums[a] + nums[b] + nums[i] + nums[j];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[a], nums[b], nums[i], nums[j]));
                            while ((i < j) && (nums[i] == nums[i + 1])) i++;
                            while ((i < j) && (nums[j] == nums[j - 1])) j--;
                            i++;
                            j--;
                        } else if (sum > target) {
                            j--;
                        } else {
                            i++;
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        Solution solution = fs.new Solution();
        System.out.println(solution.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
    }
}
