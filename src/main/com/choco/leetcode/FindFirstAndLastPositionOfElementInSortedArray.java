package com.choco.leetcode;

/***
 * Q34 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

public class FindFirstAndLastPositionOfElementInSortedArray {
    private int[] range;

    public int[] searchRange(int[] nums, int target) {
        range = new int[]{-1, -1};
        binarySearch(nums, 0, nums.length, target);
        return range;
    }

    //range [start,end) [1,5)
    private void binarySearch(int[] nums, int start, int end, int target) {
        if (start == end) {
            return;
        }

        int mid = (end - start) / 2 + start;
        if (nums[mid] == target) {
            confirmRange(nums, mid, target);
        } else if (nums[mid] < target) {
            //mid已经处理过 所以需要写成mid+1
            binarySearch(nums, mid+1, end, target);
        } else {
            binarySearch(nums, start, mid, target);
        }
    }

    private void confirmRange(int[] nums, int index, int target) {
        int left = index;
        int right = index;
        while (left >= 0) {
            if (nums[left] == target) {
                range[0] = left;
            } else {
                break;
            }
            left--;
        }
        while (right < nums.length) {
            if (nums[right] == target) {
                range[1] = right;
            } else {
                break;
            }
            right++;
        }
    }
}
