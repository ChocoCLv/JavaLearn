package com.choco.leetcode;

/**
 * Q33 搜索旋转排序数组 
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。 ( 例如，数组 [0
 * 1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。 你的算法时间复杂度必须是 O(log n) 级别。 示例 1: 输入: nums 
 * [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2: 输入: nums = [4,5,6,7,0,1,2],  a  
 */

public class SearchInRotatedSortedArray {
    class Solution {
        // 先二分法找到最大值的位置，再在一侧二分查找target
        public int search(int[] nums, int target) {
            if (nums.length == 0)
                return -1;

            int minIndex = searchMinIndex(nums, 0, nums.length);

            if (target < nums[0]) {
                return searchTargetIndex(nums, minIndex, nums.length, target);
            } else {
                return searchTargetIndex(nums, 0, minIndex+1, target);
            }
        }

        public int searchMinIndex(int[] nums, int start, int end) {
            int mid = 0;
            while (start < end) {
                mid = start + (end - start) / 2;
                if (nums[mid] <= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            return start;
        }

        public int searchTargetIndex(int[] nums, int start, int end, int target) {
            int mid = 0;
            while (start < end) {
                mid = start + (end - start) / 2;
                if (nums[mid] == target)
                    return mid;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
        Solution solution = sirsa.new Solution();
        System.out.println(solution.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(solution.search(new int[] { 3 }, 3));
    }
}