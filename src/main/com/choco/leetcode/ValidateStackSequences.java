package com.choco.leetcode;

import java.util.Stack;

/**
 * Q946
 */
public class ValidateStackSequences {
    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int i = 0;
            int j = 0;
            Stack<Integer> stack = new Stack<>();
            while (i < pushed.length) {
                stack.push(pushed[i++]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
}
