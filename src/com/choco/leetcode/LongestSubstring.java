package com.choco.leetcode;


import java.util.ArrayList;

/*
 * Q3: longest substring without repeating
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class LongestSubstring {
    public static void main(String[] args) {

        LongestSubstring ls = new LongestSubstring();
        LongestSubstring.Solution solution = ls.new Solution();
        String test = "dvdf";
        System.out.println(solution.lengthOfLongestSubstring(""));
    }

    class Solution {
        private ArrayList<Integer> lengths = new ArrayList<>();

        private int maxLength;

        public int lengthOfLongestSubstring(String s) {
            StringBuilder sb = new StringBuilder();

            int pos;

            for (char c : s.toCharArray()) {
                pos = sb.indexOf(c + "");
                if (pos != -1) {
                    lengths.add(sb.toString().length());
                    sb.delete(0, pos + 1);
                }
                sb.append(c);
            }
            lengths.add(sb.toString().length());

            maxLength = lengths.get(0);
            for (int length : lengths) {
                if (length > maxLength) {
                    maxLength = length;
                }
            }
            return maxLength;
        }
    }
}
