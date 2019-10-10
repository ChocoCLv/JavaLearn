package com.choco.leetcode;

import java.util.*;

public class ContainsNearbyAlmostDuplicate {
    static class Solution {
        /**
         * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
         * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
         * 并且 i 和 j 之间的差的绝对值最大为 ķ。
         * <p>
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums == null || nums.length < 2 || k < 1) {
                return false;
            }
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Integer pre = set.ceiling(nums[i]);
                if (pre != null && pre <= nums[i] + t) return true;

                Integer succ = set.floor(nums[i]);
                if (succ != null && nums[i] <= succ + t) return true;

                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
}
