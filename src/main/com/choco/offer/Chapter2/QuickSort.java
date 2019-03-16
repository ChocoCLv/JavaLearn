package com.choco.offer.Chapter2;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        sort(nums, 0, 8);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void sort(int[] nums, int start, int end) {
        if (start == end)
            return;
        int index = partition(nums, start, end);
        if (index > start) {
            sort(nums, start, index - 1);
        }
        if (index < end) {
            sort(nums, index + 1, end);
        }
    }


    private static int partition(int[] nums, int start, int end) {
        int middle = start + (end - start) / 2;
        //将基准数放到最后
        swap(nums, middle, end);
        int i = start;
        int small = start - 1;

        while (i < end) {
            if (nums[i] < nums[end]) {
                small++;
                if (i != small)
                    swap(nums, i, small);
            }
            i++;
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private static void swap(int data[], int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
