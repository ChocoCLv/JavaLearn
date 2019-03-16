package com.choco.offer.Chapter2;


import java.util.LinkedList;
import java.util.Queue;


/**
 * 使用两个队列实现一个栈
 * 只使用其中的一个队列存储所有数据
 *
 * @param <T>
 */
public class StackWithTwoQueues<T> {

    private Queue<T> queueEmpty = new LinkedList<T>();
    private Queue<T> queueValid = new LinkedList<T>();

    public void push(T ele) {
        queueValid.add(ele);
    }

    public T pop() {
        if (queueValid.isEmpty())
            return null;

        while (queueValid.size() != 1) {
            queueEmpty.add(queueValid.remove());
        }

        Queue<T> queue = queueValid;
        queueValid = queueEmpty;
        queueEmpty = queue;
        return queueEmpty.remove();
    }
}
