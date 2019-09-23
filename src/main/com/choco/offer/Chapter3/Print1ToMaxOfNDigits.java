package com.choco.offer.Chapter3;

/**
 * 给定位数n，打印从1到最大的n位数
 * 1. 字符串加法
 * 2. 字符的全排列
 */
public class Print1ToMaxOfNDigits {

    final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void print(int n) {
        if (n <= 0)
            return;

        char[] nums = new char[n];
        for (int i = 0; i < 10; i++) {
            nums[0] = digits[i];
            printRecursively(nums, n, 1);
        }
    }

    /**
     * @param nums
     * @param n     总长度
     * @param index 下一个应该填入的位置
     */
    private void printRecursively(char[] nums, int n, int index) {
        if (index == n) {
            print(nums);
            return;
        }

        for (int i = 0; i < 10; i++) {
            nums[index] = digits[i];
            printRecursively(nums, n, index + 1);
        }
    }

    private void print(char[] nums) {
        boolean isBeginning0 = true;
        for (int i = 0; i < nums.length; i++) {
            if (isBeginning0 && nums[i] != '0')
                isBeginning0 = false;
            if (!isBeginning0)
                System.out.print(nums[i]);
        }
        System.out.println();
    }
}
