package com.choco.offer.Chapter5;

/**
 * 查找排序数组中k出现的次数
 */
public class NumberOfK {
    public static void main(String[] args) {
        int result = 1;
        result>>=1;
        System.out.println(result);
    }
    public int GetNumberOfK(int[] array, int k) {
        int lower = findLower(array, k);
        if (lower >= array.length || array[lower] != k)
            return 0;
        int upper = findUpper(array, k);
        return upper - lower;
    }

    public int findLower(int[] array, int k) {
        //查找第一个>=k的位置
        int start = 0;
        int end = array.length;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (array[middle] < k)
                start = middle + 1;
            else
                end = middle;
        }
        return start;
    }

    public int findUpper(int[] array, int k) {
        int start = 0;
        int end = array.length;
        //查找第一个大于k的位置
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (array[middle] > k)
                end = middle;
            else
                start = middle + 1;
        }
        return start;
    }
}
