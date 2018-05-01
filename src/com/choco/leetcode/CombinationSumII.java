package com.choco.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        Solution solution = cs.new Solution();
        List<List<Integer>> result = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> l : result) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    class Solution {
        List<List<Integer>>[][] M;
        List<Integer> nums;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            nums = new ArrayList<>();
            for (int i : candidates) {
                nums.add(i);
            }
            Collections.sort(nums);
            M = new ArrayList[nums.size()][target + 1];
            return OPT(nums.size() - 1, target);
        }

        private List<List<Integer>> OPT(int i, int w) {
            if (0 == w) {
                List<List<Integer>> l = new ArrayList<>();
                List<Integer> ll = new ArrayList<>();
                l.add(ll);
                return l;
            }

            if (w < 0 || i < 0) {
                return new ArrayList<>();
            }

            if (M[i][w] != null) {
                return M[i][w];
            }

            //跳过重复的数字
            int duplicateNums = 1;
            while (i >= 1 && nums.get(i).equals(nums.get(i - 1))) {
                i--;
                duplicateNums++;
            }
            List<List<Integer>> l3 = new ArrayList<>();

            while (duplicateNums >= 0) {
                //根据重复数字的数量
                List<List<Integer>> l1 = OPT(i - 1, w - duplicateNums * nums.get(i));
                //这儿不能直接在返回的l1上增加nums[i]，这样会修改之前的结果
                //而要新建一个
                List<List<Integer>> l4 = new ArrayList<>();
                List<Integer> l;
                for (List<Integer> lt : l1) {
                    l = new ArrayList<>();
                    for (int t : lt) {
                        l.add(t);
                    }
                    for (int n = 0; n < duplicateNums; n++) {
                        l.add(nums.get(i));
                    }
                    l4.add(l);
                }
                l3.addAll(l4);
                duplicateNums--;
            }

            M[i][w] = l3;
            return M[i][w];
        }
    }
}
