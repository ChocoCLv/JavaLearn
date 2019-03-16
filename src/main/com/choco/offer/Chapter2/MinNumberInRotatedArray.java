package com.choco.offer.Chapter2;

public class MinNumberInRotatedArray {
    /**
     * 数组以某个位置做了旋转，找到旋转后数组的最小元素的下标
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int searchMinIndex(int[] nums) {
        int mid = 0;
        int i = 0;
        int j = nums.length - 1;

        while (nums[i] >= nums[j]) {
            if ((j - i) == 1) {
                mid = j;
                break;
            }

            while ((i + 1) < nums.length && nums[i] == nums[i + 1]) i++;
            while ((j - 1) >= 0 && nums[j] == nums[j - 1]) j--;

            mid = i + (j - i) / 2;

            if (nums[i] <= nums[mid])
                i = mid;
            else
                j = mid;
        }
        return mid;
    }
}
