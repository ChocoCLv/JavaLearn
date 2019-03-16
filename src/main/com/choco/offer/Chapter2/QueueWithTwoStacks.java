package com.choco.offer.Chapter2;

import java.util.Stack;

/**
 * 使用两个栈实现一个队列
 *
 * @param <T>
 */
public class QueueWithTwoStacks<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    /**
     * 出队：当stack2不为空时，直接弹出stack2的栈顶源宿；否则将stack1的元素依次出栈，并依次压入stack2
     *
     * @return
     */
    public T deleteHead() {
        if (!stack2.isEmpty())
            return stack2.pop();
        if (stack1.isEmpty())
            return null;

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public void appendTail(T ele) {
        stack1.push(ele);
    }
}
