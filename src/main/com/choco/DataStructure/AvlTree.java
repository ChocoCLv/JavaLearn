package com.choco.DataStructure;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by choco on 2018/12/25.
 * from 《数据结构与算法分析 java语言描述》 p92
 * 需要对照学习笔记《AVL树》查看
 */
public class AvlTree<T extends Comparable> {

    private static final int ALLOWED_IMBLANCE = 1;
    private AvlNode<T> root;

    public void insert(T x) {
        root = insert(x, root);
    }

    public void printTreeInfoByInOrder() {
        printTreeInfoByInOrder(root);
    }

    private void printTreeInfoByInOrder(AvlNode<T> t){
        if(t == null)
            return;
        printTreeInfoByInOrder(t.left);
        System.out.println("val:"+t.element+" height divide:"+String.valueOf(height(t.left)-height(t.right)));
        printTreeInfoByInOrder(t.right);
    }

    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null)
            return new AvlNode<T>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {
            //重复元素
        }

        //平衡树
        return balance(t);
    }

    @Contract("null -> null")
    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null)
            return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBLANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t); //情形a
            } else {
                t = doubleWithLeftChild(t); //情形b
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBLANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);//情形d
            } else {
                t = doubleWithRightChild(t);//情形c
            }
        }

        //更新根节点的高度信息
        t.height = updateHeight(t);
        return t;
    }

    @Contract(pure = true)
    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    private int updateHeight(@NotNull AvlNode<T> node) {
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private AvlNode<T> rotateWithLeftChild(@NotNull AvlNode<T> k2) {
        //单旋转
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        //更新高度信息只有k1 k2的左右子树高度差发生了变化
        k2.height = updateHeight(k2);
        k1.height = updateHeight(k1);
        //返回新的子树的根节点 以便连接
        return k1;
    }

    private AvlNode<T> doubleWithLeftChild(@NotNull AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> rotateWithRightChild(@NotNull AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k2.height = updateHeight(k2);
        k1.height = updateHeight(k1);
        return k2;
    }

    private AvlNode<T> doubleWithRightChild(@NotNull AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

}
