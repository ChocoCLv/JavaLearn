package com.choco.leetcode;

import java.util.*;

/***
 *给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 数组 counts 有该性质：
 * counts[i] 的值是nums[i] 右侧小于 nums[i] 的元素的数量。
 *示例:
 输入: [5,2,6,1]
 输出: [2,1,1,0]
 解释:
 5 的右侧有 2 个更小的元素 (2 和 1).
 2 的右侧仅有 1 个更小的元素 (1).
 6 的右侧有 1 个更小的元素 (1).
 1 的右侧有 0 个更小的元素.
 */
public class CountSmaller {
    public static void main(String[] args) {
        CountSmaller cs = new CountSmaller();
        Solution solution = cs.new Solution();
        System.out.println(solution.countSmaller(new int[]{5, 2, 6, 1}));
    }

    class Solution {
        List<Integer> result;
        Map<Integer, Integer> resultMap;
        int[] numsCopy;
        public List<Integer> countSmaller(int[] nums) {
            result = new ArrayList<>();
            resultMap = new LinkedHashMap<>();
            numsCopy = new int[nums.length];
            int[] aux = new int[nums.length];
            for(int i = 0;i<nums.length;i++){
                numsCopy[i] = nums[i];
                resultMap.put(nums[i],0);
            }
            sortAndCount(nums, aux, 0, nums.length - 1);
            for(int i:numsCopy){
                result.add(resultMap.get(i));
            }
            return result;
        }

        void sortAndCount(int[] a, int[] aux, int start, int end) {
            if (start >= end) {
                return;
            }

            int mid = start + (end - start) / 2;
            sortAndCount(a, aux, start, mid);
            sortAndCount(a, aux, mid + 1, end);
            if (a[mid] <= a[mid + 1])
                return;
            mergeAndCount(a, aux, start, mid, end);
        }

        void mergeAndCount(int[] a, int[] aux, int start, int mid, int end) {
            for(int k = start;k<=end;k++){
                aux[k] = a[k];
            }
            int i = start;
            int j = mid+1;
            for(int k = start;k<=end;k++){
                //对比两个序列的每个元素
            }
        }
    }
}
