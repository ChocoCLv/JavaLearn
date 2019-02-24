package com.choco.offer.Chapter2;

import com.choco.Util.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的。
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 例如{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3
 */
public class DuplicateDigits {
    public int findDuplicates(int[] nums) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            //直到nums[i] == i
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }else {
                    int tmp = nums[i];
                    nums[i]=nums[nums[i]];
                    nums[tmp] = tmp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DuplicateDigits dd = new DuplicateDigits();
        System.out.println(dd.findDuplicates(new int[]{2,3,1,0,5,2,3}));
    }
}
