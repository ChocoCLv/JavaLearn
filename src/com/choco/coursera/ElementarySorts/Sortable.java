package com.choco.coursera.ElementarySorts;

public interface Sortable {
    static void swap(Comparable[] datas, int i, int j) {
        Comparable temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) == -1) {
            return true;
        }
        return false;
    }

    /*
    判断一个数组，在区间[begin, end]内是否有序
     */
    static boolean isSorted(Comparable[] datas, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (less(datas[i + 1], datas[i])) {
                return false;
            }
        }
        return true;
    }

    void sort(Comparable[] datas);
}
