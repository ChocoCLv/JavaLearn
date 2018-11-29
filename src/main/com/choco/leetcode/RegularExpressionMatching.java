package com.choco.leetcode;

/***
 * Q10 正则表达式匹配
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class RegularExpressionMatching {
    class Solution {
        String s;
        String p;

        public boolean isMatch(String s, String p) {
            this.s = s;
            this.p = p;

            return isMatch(0, 0);
        }

        private boolean isMatch(int i, int j) {
            boolean result;
            if (i == s.length() && j == p.length())
                return true;
            if (j == p.length())
                return false;
            if (i == s.length()) {
                if ((j + 1) < p.length() && p.charAt(j + 1) == '*')
                    return isMatch(i, j + 2);
                if (j < p.length() && p.charAt(j) == '*')
                    return isMatch(i, j + 1);
                return false;
            }
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                result = isMatch(i + 1, j + 1);
                if (result)
                    return true;
            }
            if (p.charAt(j) == '*') {
                //p[j-1]出现0次
                result = isMatch(i, j + 1);
                if (result)
                    return true;
                //p[j-1]至少出现1次
                while (j > 0 && i < s.length() && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    result = isMatch(++i, j + 1);
                    if (result)
                        return true;
                }
            }
            if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
                result = isMatch(i, j + 2);
                if (result)
                    return true;
            }
            return false;
        }
    }
}
