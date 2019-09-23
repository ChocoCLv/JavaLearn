package com.choco.offer.Chapter5;

public class MoreThanHalfNumber {
    /**
     * 快排，每次定位一个数，如果该数的位置在中位数
     * @param nums
     * @return
     */
    public int getMoreThanHalfNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int middle = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }

        int count = 0;
        for (int n : nums) {
            count += n == nums[index] ? 1 : 0;
        }
        return count > middle ? nums[index] : 0;
    }

    public int getMoreThanHalfNumberFast(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int result = nums[0];
        int times = 1;
        for (int i : nums) {
            if (times == 0) {
                result = i;
                times = 1;
            } else if (i == result) {
                times++;
            } else {
                times--;
            }
        }
        int count = 0;
        for (int n : nums) {
            count += n == result ? 1 : 0;
        }
        return count > nums.length >>> 1 ? result : 0;
    }

    private int partition(int[] nums, int start, int end) {
        int middle = start + (end - start) / 2;
        while (start < end) {
            while (nums[start] <= nums[middle] && start < end) start++;
            while (nums[end] >= nums[middle] && start < end) end--;

            if (start < end)
                swap(nums, start, end);
        }
        swap(nums, start, middle);
        return start;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
