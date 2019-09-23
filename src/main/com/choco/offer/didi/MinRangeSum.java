package com.choco.offer.didi;

import java.util.Scanner;

public class MinRangeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int minSum = Integer.MAX_VALUE;
        int curSum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < m; i++) {
            curSum += nums[i];
        }
        minSum = curSum;
        right = m;
        while (left + m < n) {
            while (right - left < m) {
                curSum += nums[right++];
            }
            minSum = Math.min(minSum, curSum);
            if (curSum >= 0) {
                curSum = curSum + nums[right] - nums[left];
                right++;
                left++;
            } else {
                curSum += nums[right];
                right++;
            }
            minSum = Math.min(minSum, curSum);
        }
        System.out.println(minSum);
    }
}
