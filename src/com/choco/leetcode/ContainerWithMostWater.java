package com.choco.leetcode;

/**
 * Created by choco on 2018/10/8.
 * Q11
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int length = height.length;
            int maxAres = (length - 1) * Math.min(height[0], height[length - 1]);
            int temp = 0;
            int left = 0;
            int right = length - 1;
            while (left < right) {
                int temMax = (right - left) * Math.min(height[right], height[left]);
                if (temMax > maxAres) maxAres = temMax;
                if (height[left] < height[right]) {
                    temp = left;
                    while (height[temp] >= height[left] && left < right) {
                        left++;
                    }
                } else {
                    temp = right;
                    while (height[temp] >= height[right] && left < right) {
                        right--;
                    }
                }
            }
            return maxAres;
        }
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        Solution solution = cwmw.new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
