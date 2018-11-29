package com.choco.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args){
        Permutation p = new Permutation();
        Solution solution = p.new Solution();
        List<List<Integer>> result = solution.permute(new int[]{1,2,3});
        for(List<Integer> l:result){
            for(int i:l){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        private int n;
        private int[] book;
        private int[] a;
        private int[] copy;
        private List<Integer> queue;
        public List<List<Integer>> permute(int[] nums) {
            n = nums.length;
            copy = nums;
            book = new int[n];
            a = new int[n];
            dfs(0);
            return result;
        }
        private void dfs(int step){
            if(step == n){
                //输出全排列
                queue = new ArrayList<>();
                for(int i:a){
                    queue.add(i);
                }
                result.add(queue);
                return;
            }

            for(int i = 0; i < n;i++){
                if(book[i] == 0){
                    a[step] = copy[i];
                    book[i] = 1;
                    dfs(step+1);
                    book[i] = 0;
                }
            }
        }
    }
}
