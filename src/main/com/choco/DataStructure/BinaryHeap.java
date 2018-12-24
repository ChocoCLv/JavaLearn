package com.choco.DataStructure;

import java.util.Comparator;

public class BinaryHeap<T extends Comparable> implements Heap<T> {
    public T[] data;
    int size;
    int currentSize;

    public void buildHeap(int size) {
        this.size = size;
        this.currentSize = 0;
        //使用data[0]临时存储待排序的元素
        data = (T[]) new Comparable[size + 1];
    }

    @Override
    public T deleteMin() {
        T result = data[1];
        data[1] = data[currentSize];

        int loc = 1;
        //为最后一个元素找到合适的位置
        while (loc < currentSize) {
            int tmp;
            if ((2 * loc + 1) < currentSize) {
                tmp = data[2 * loc].compareTo(data[2 * loc + 1]) < 0 ? 2 * loc : 2 * loc + 1;
            } else if (2 * loc < currentSize) {
                tmp = 2 * loc;
            } else {
                break;
            }

            data[loc] = data[tmp];
            loc = tmp;
        }
        //将最后一个元素放入该位置
        if (loc < currentSize)
            data[loc] = data[currentSize];
        currentSize--;
        return result;
    }

    @Override
    public void insert(T x) {
        //将x放入data[0]
        data[0] = x;
        int loc = ++currentSize;
        while (loc > 0 && x.compareTo(data[loc / 2]) < 0) {
            data[loc] = data[loc / 2];
            loc /= 2;
        }
        data[loc] = x;
    }
}
