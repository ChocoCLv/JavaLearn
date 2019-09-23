package com.choco.offer.Chapter5;

import java.util.ArrayList;

public class KLeastNumbersInQuickSort {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);

        while (index != (k - 1)) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(input, start, end);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private int partition(int[] nums, int i, int j) {
        if (i == j)
            return i;
        int start = i;
        int end = j;
        int base = start;//这种写法基准数据必须是最左侧
        int tmp = nums[base];//将基准数据拿出来，此时该位置可以被覆盖
        while (start < end) {
            //这种写法必须是先从后往前
            while (start < end && nums[end] >= tmp) end--;
            while (start < end && nums[start] <= tmp) start++;
            if (start < end)
                swap(nums, start, end);
        }
        nums[i] = nums[start];
        nums[start] = tmp;
        return start;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
