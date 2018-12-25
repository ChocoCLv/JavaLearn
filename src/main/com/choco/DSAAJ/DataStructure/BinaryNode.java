package com.choco.DSAAJ.DataStructure;

import java.util.Random;

public class BinaryNode<T extends Comparable<? super T>> {
    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T x){
        this.element = x;
    }

    public BinaryNode(BinaryNode<T> x){
        this(x,null,null);
    }

    public BinaryNode(BinaryNode<T> x, BinaryNode<T> left,BinaryNode<T> right){
        this.element = x.element;
        this.left = left;
        this.right = right;
    }

    public static Generator<BinaryNode> randomIntegerGenerator =
            new Generator<BinaryNode>() {
                @Override
                public BinaryNode next() {
                    return new BinaryNode<>(new Random().nextInt());
                }
            };
}
