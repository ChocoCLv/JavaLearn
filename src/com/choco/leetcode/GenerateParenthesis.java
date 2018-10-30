package com.choco.leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * Q22 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {
    class Solution {
        List<String> result;
        char[] a;
        int length;
        int n;

        public List<String> generateParenthesis(int n) {
            result = new ArrayList<>();
            a = new char[2 * n];
            length = 2 * n;
            this.n = n;
            dfs(0, 0, 0);
            return result;
        }

        private void dfs(int step, int usedLeft, int usedRight) {
            if (step == length) {
                StringBuilder sb = new StringBuilder();
                for (char c : a) {
                    sb.append(c);
                }
                result.add(sb.toString());
                return;
            }
            if (usedLeft == n) {
                a[step] = ')';
                dfs(step + 1, usedLeft, usedRight + 1);
            } else if (usedLeft == usedRight) {
                a[step] = '(';
                dfs(step + 1, usedLeft + 1, usedRight);
            } else {
                a[step] = '(';
                dfs(step + 1, usedLeft + 1, usedRight);

                a[step] = ')';
                dfs(step + 1, usedLeft, usedRight + 1);
            }
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> r = gp.new Solution().generateParenthesis(3);
        for (String s : r) {
            System.out.println(s);
        }
    }
}
