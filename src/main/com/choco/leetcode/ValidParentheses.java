package com.choco.leetcode;

import java.util.Stack;

/**
 * Created by choco on 2018/7/27.
 * Q20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (isLeft(c)) {
                    stack.push(c);
                } else {
                    if(stack.isEmpty())
                        return false;
                    if(isPaired(stack.peek(),c)){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private boolean isLeft(char c) {
            return c == '(' || c == '{' || c == '[';
        }

        private boolean isPaired(char c1, char c2) {
            switch (c2) {
                case ')':
                    return c1 == '(';
                case ']':
                    return c1 == '[';
                case '}':
                    return c1 == '{';
                default:
                    return false;
            }
        }
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        Solution solution = vp.new Solution();
        System.out.println(solution.isValid("()"));
    }
}
