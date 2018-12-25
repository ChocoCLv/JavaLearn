package com.choco.DSAAJ.DataStructure;


public interface Heap<T extends Comparable> {
    T deleteMin();
    void insert(T x);
}
