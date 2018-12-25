package com.choco.DataStructure;

/**
 * Created by choco on 2018/12/24.
 */
public class AvlNode<T extends Comparable> {
    T element;
    AvlNode<T> left;
    AvlNode<T> right;
    int height;

    AvlNode(T x) {
        this.element = x;
    }

    AvlNode(T x, AvlNode<T> left, AvlNode<T> right) {
        this.element = x;
        this.left = left;
        this.right = right;
        height = 0;//用于记录高度
    }
}
