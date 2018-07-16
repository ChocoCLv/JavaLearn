package com.choco.leetcode;


/***
 * Q14
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        Solution solution = lcp.new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{}));
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                try {
                    char c = strs[0].charAt(i);
                    for (String s : strs) {
                        if (c != s.charAt(i))
                            return sb.toString();
                    }
                    sb.append(c);
                    i++;
                } catch (IndexOutOfBoundsException e) {
                    return sb.toString();
                }
            }
        }
    }
}
