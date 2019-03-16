package com.choco.offer.Chapter3;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class RecorderArray {

    public void recorderOddEven(int[] nums) {
        if (nums.length <= 1)
            return;
        int odd = 0;
        int even = nums.length - 1;
        while (odd < even) {
            //跳过奇数
            while (odd < even && nums[odd] % 2 == 1) odd++;
            //跳过偶数
            while (odd < even && nums[even] % 2 == 0) even--;

            //增加判断 防止上面循环因odd==even而退出
            if (odd < even) {
                int tmp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = tmp;
            }
        }
    }
}
