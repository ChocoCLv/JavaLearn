package com.choco.leetcode;

import java.util.*;

/***
 * Q17 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

public class LetterCombinationsOfAPhoneNumber {
    class Solution {
        private String[] digitToString;
        char[] a;
        String digits;
        List<String> result;
        int n;

        public List<String> letterCombinations(String digits) {
            digitToString = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            result = new ArrayList<>();
            if (digits.length() == 0) {
                return result;
            }
            a = new char[digits.length()];
            this.digits = digits;
            n = digits.length();
            dfs(0);
            return result;
        }

        private void dfs(int step) {
            if (step == n) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(a[i]);
                }
                result.add(sb.toString());
                return;

            }
            String s = digitToString[digits.charAt(step) - '0' - 2];
            for (int i = 0; i < s.length(); i++) {
                a[step] = s.charAt(i);
                dfs(step + 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber lcoan = new LetterCombinationsOfAPhoneNumber();
        Solution solution = lcoan.new Solution();
        List<String> result = solution.letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
