package com.choco.leetcode;

/***
 * Q28 实现strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class ImplementStrStr {
    class Solution {
        public int strStr(String haystack, String needle) {

            int nl = needle.length();
            int hl = haystack.length();
            int index = 0;
            if (nl == 0)
                return 0;
            if(hl < nl)
                return -1;
            while ((index + nl) <= hl) {
                if(needle.equals(haystack.substring(index,index+nl)))
                    return index;
                index++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        ImplementStrStr iss = new ImplementStrStr();
        Solution solution = iss.new Solution();
        System.out.println(solution.strStr("a", "a"));
    }
}
