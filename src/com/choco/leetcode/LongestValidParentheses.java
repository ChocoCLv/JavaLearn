package com.choco.leetcode;

import java.util.Stack;

/**
 * Q32 最长有效括号
 * 给定一个只包含“（”和“）”的字符串，找出最长包含有效括号的子串的长度
 */

public class LongestValidParentheses {
    class Solution {
        String s;

        public int longestValidParentheses(String s) {
            this.s = s;
            return dynamicPrograming();
        }

        private int clear() {
            int res = 0;
            Element e;
            char c;
            Stack<Element> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == '(') {
                    e = new Element();
                    e.c = c;
                    stack.push(e);
                } else {
                    if (stack.size() == 1) {
                        if (stack.peek().c == '(') {
                            stack.pop();
                            e = new Element();
                            e.num = 2;
                            stack.push(e);
                            res = Math.max(res, 2);
                        } else if (stack.peek().num != 0) {
                            stack.pop();
                        }
                    } else if (stack.size() >= 2) {
                        Element top = stack.pop();
                        if (top.c == '(') {
                            int num = 2;
                            if (stack.peek().num != 0) {
                                num += stack.pop().num;
                            }
                            e = new Element();
                            e.num = num;
                            stack.push(e);
                            res = Math.max(res, num);
                        } else if (top.num != 0) {
                            int num = 2;
                            num += top.num;
                            stack.pop();
                            while (!stack.isEmpty() && stack.peek().num != 0) {
                                num += stack.pop().num;
                            }
                            e = new Element();
                            e.num = num;
                            stack.push(e);
                            res = Math.max(res, num);
                        }
                    }
                }
            }
            return res;
        }

        private int dynamicPrograming() {
            int res = 0;
            char c;
            int[] dp = new int[s.length() + 1];
            dp[0] = 0;
            for (int i = 1; i <= s.length(); i++) {
                int j = i - 2 - dp[i - 1];
                c = s.charAt(i-1);
                if (c == '(' || j < 0 || s.charAt(j) == ')')
                    dp[i] = 0;
                else {
                    dp[i] = dp[i - 1] + 2 + dp[j];
                    res = res > dp[i] ? res : dp[i];
                }
            }
            return res;
        }

        class Element {
            int num;
            int c;
        }
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        Solution solution = lvp.new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
    }
}
