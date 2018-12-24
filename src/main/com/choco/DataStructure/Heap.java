package com.choco.DataStructure;


public interface Heap<T extends Comparable> {
    T deleteMin();
    void insert(T x);
}
