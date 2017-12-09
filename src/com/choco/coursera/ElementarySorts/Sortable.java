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

    void sort(Comparable[] datas);
}
