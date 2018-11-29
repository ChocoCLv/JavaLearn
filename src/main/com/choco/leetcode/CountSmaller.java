package com.choco.leetcode;

import java.util.Arrays;
import java.util.List;

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
        System.out.println(solution.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
    }

    class Solution {
        Element[] elements;

        public List<Integer> countSmaller(int[] nums) {
            elements = new Element[nums.length];
            Element[] aux = new Element[nums.length];
            for (int i = 0; i < nums.length; i++) {
                elements[i] = new Element();
                elements[i].index = i;
                elements[i].num = nums[i];
                elements[i].smaller = 0;
            }

            sortAndCount(elements, aux, 0, nums.length - 1);
            Integer[] result = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[elements[i].index] = elements[i].smaller;
            }
            return Arrays.asList(result);
        }

        void sortAndCount(Element[] a, Element[] aux, int start, int end) {
            if (start >= end) {
                return;
            }

            int mid = start + (end - start) / 2;
            sortAndCount(a, aux, start, mid);
            sortAndCount(a, aux, mid + 1, end);
            if (a[mid].num <= a[mid + 1].num)
                return;
            mergeAndCount(a, aux, start, mid, end);
        }

        void mergeAndCount(Element[] a, Element[] aux, int start, int mid, int end) {
            for (int k = start; k <= end; k++) {
                aux[k] = a[k];
            }
            int i = start;
            int j = mid + 1;
            //归并排序
            for (int k = start; k <= end; k++) {
                if (i > mid)
                    a[k] = aux[j++];
                else if (j > end)
                    a[k] = aux[i++];
                else if (aux[j].num < aux[i].num) {
                    for(int t = i;t<=mid;t++){
                        aux[t].smaller++;
                    }
                    a[k] = aux[j++];
                } else
                    a[k] = aux[i++];
            }
        }

        class Element {
            int num;
            int index;
            int smaller;
        }
    }
}
