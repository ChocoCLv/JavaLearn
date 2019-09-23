package com.choco.offer.Chapter4;

import java.util.Stack;

public class StackPushPopOrder {

    /**
     *
     * @param s1 一个栈的push序列
     * @param s2 判断该序列是否可能为该栈的pop序列
     * @return
     */
    public boolean isPopOrder(int[] s1, int[] s2) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean result = false;
        int i = 0, j = 0;
        for (; j < s2.length; j++) {
            //当栈顶元素与pop元素相等时，说明此时应该pop虚拟栈
            while (stack.isEmpty() || stack.peek() != s2[j]) {
                if (i == s1.length)
                    break;
                stack.push(s1[i]);
                i++;
            }

            if (stack.peek() != s2[j])
                break;

            stack.pop();
        }

        if (stack.empty() && j == s2.length)
            result = true;
        return result;
    }
}
